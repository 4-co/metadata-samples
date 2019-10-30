output "base_resource_group_name" {
  value = "${azurerm_resource_group.this.name}"
}

output "base_user_assigned_identity_name" {
  value = "${azurerm_user_assigned_identity.this.name}"
}

output "base_storage_account_name" {
  value = "${azurerm_storage_account.this.name}"
}

output "base_vnet_name" {
  value = "${azurerm_virtual_network.this.name}"
}

output "base_keyvault_name" {
  value = "${azurerm_key_vault.this.name}"
}

output "base_acr_name" {
  value = "${azurerm_container_registry.this.name}"
}

output "base_sql_server_name" {
  value = "${azurerm_sql_server.base.name}"
}

output "base_sql_database_name" {
  value = "${azurerm_sql_database.base_db.name}"
}

output "base_sql_datawarehouse_name" {
  value = "${azurerm_sql_database.base_dw.name}"
}

output "sql_db_connection_string" {
  value = "Server=tcp:${azurerm_sql_server.base.name}.database.windows.net,1433;Initial Catalog=${azurerm_sql_database.base_db.name};Persist Security Info=False;User ID=${var.sql_username};Password=${var.sql_password};MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;"
}

output "sql_dw_connection_string" {
  value = "Server=tcp:${azurerm_sql_server.base.name}.database.windows.net,1433;Initial Catalog=${azurerm_sql_database.base_dw.name};Persist Security Info=False;User ID=${var.sql_username};Password=${var.sql_password};MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;"
}

output "adls_container_name" {
  value = "${azurerm_storage_data_lake_gen2_filesystem.this.name}"
}

output "sql_username" {
  value = "${var.sql_username}"
}

output "sql_password" {
  value = "${var.sql_password}"
}
