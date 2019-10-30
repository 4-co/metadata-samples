resource "azurerm_data_factory" "lineage" {
  name                = "${var.data_factory_name}"
  location            = "${azurerm_resource_group.this.location}"
  resource_group_name = "${azurerm_resource_group.this.name}"
}

resource "azurerm_data_factory_pipeline" "lineage_copy" {
  name                = "${azurerm_data_factory.lineage.name}-message-post"
  resource_group_name = "${azurerm_resource_group.this.name}"
  data_factory_name   = "${azurerm_data_factory.lineage.name}"
}

resource "azurerm_template_deployment" "test" {
  name                = "acctesttemplate-01"
  resource_group_name = "${azurerm_resource_group.this.name}"
  template_body       = "${file("arm_templates/adf-pipelines.json")}"

  parameters = {
    "factoryName" = "${azurerm_data_factory.lineage.name}",
    "sqldatabase_connectionString" = "${var.sql_db_connection_string}",
    "adls_primary_access_key" = "${data.azurerm_storage_account.base.primary_access_key}",
    "adls_properties_url" = "${data.azurerm_storage_account.base.primary_dfs_endpoint}",
    "adls_container_name" = "${var.adls_container_name}",
    "sqldatawarehouse_connectionString" = "${var.sql_dw_connection_string}",
    "sql_server_name" = "${data.azurerm_sql_server.base.name}"
    "sql_dw_name" = "${var.base_sql_datawarehouse_name}"
  }
  deployment_mode = "Incremental"
}
