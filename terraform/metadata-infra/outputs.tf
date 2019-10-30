output "datafactory_rg" {
  value = "${azurerm_data_factory.lineage.resource_group_name}"
}
output "datafactory_name" {
  value = "${azurerm_data_factory.lineage.name}"
}
