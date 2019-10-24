package com.ms.cse.harvestor.dwh.templates;

public class QnsTemplate {

	public String schemaTemplate(String azure_sql_server_uri,String database_name,String schema_name)
	{
		String finalTemplate= "{\"azure_sql_server_uri\":\""+azure_sql_server_uri+"\","
				+ "\"database_name\":\""+database_name+"\","
				+ "\"schema_name\":\""+schema_name+"\""
				+ "}";
		return finalTemplate;
		
	}
	public String serverTemplate(String azure_sql_server_uri)
	{
		String finalTemplate= "{\"azure_sql_server_uri\":\""+azure_sql_server_uri+"\"}";
		return finalTemplate;
		
	}
	public String tableTemplate(String azure_sql_server_uri,String database_name,String azure_sql_table_name)
	{
		String finalTemplate= "{\"azure_sql_server_uri\":\""+azure_sql_server_uri+"\","
				+ "\"database_name\":\""+database_name+"\","
						+ "\"azure_sql_table_name\":\""+azure_sql_table_name+"\""
						+ "}";
		return finalTemplate;
		
	}
	public String databaseTemplate(String azure_sql_server_uri,String database_name)
	{
		String finalTemplate= "{\"azure_sql_server_uri\":\""+azure_sql_server_uri+"\","
				+ "\"database_name\":\""+database_name+"\"}";
		return finalTemplate;
		
	}
	public String columnTemplate(String azure_sql_server_uri,String database_name,String azure_sql_table_name,String azure_sql_column_name)
	{
		String finalTemplate= "{\"azure_sql_server_uri\":\""+azure_sql_server_uri+"\","
				+ "\"database_name\":\""+database_name+"\","
				+ "\"azure_sql_table_name\":\""+azure_sql_table_name+"\","
				+ "\"azure_sql_column_name\":\""+azure_sql_column_name+"\""
				+ "}";
		return finalTemplate;
		
	}
}
