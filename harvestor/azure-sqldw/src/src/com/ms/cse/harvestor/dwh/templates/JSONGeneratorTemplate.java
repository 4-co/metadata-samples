package com.ms.cse.harvestor.dwh.templates;

import com.ms.cse.harvestor.dwh.model.Column;
import com.ms.cse.harvestor.dwh.model.Database;
import com.ms.cse.harvestor.dwh.model.DatabaseServer;
import com.ms.cse.harvestor.dwh.model.Schema;
import com.ms.cse.harvestor.dwh.model.Table;

public class JSONGeneratorTemplate {

	public String schemaTemplate(Schema schema)
	{
		String finalTemplate= "{\r\n" + 
				"    \"entity_type_name\": \"azure_sql_schema\",\r\n" + 
				"    \"guid\":\""+schema.getGuid()+"\",\r\n" + 
				"    \"attributes\": [{\r\n" + 
				"        \"attr_name\": \"qualifiedName\",\r\n" + 
				"        \"attr_value\": \""+schema.getQualifiedName()+"\"\r\n" + 
				"    }, {\r\n" + 
				"        \"attr_name\": \"name\",\r\n" + 
				"        \"attr_value\": \""+schema.getSchemaName()+"\",\r\n" + 
				"        \"is_entityref\": false\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"        \"attr_name\": \"db\",\r\n" + 
				"        \"attr_value\": {\"guid\":\""+schema.getDatabase().getGuid()+"\",\"typeName\":\"azure_sql_db\",\"optionalAttibutes\":{}}\r\n" + 
				"        \r\n" + 
				"    }\r\n" + 
				"    ],\r\n" + 
				"    \"created_by\": \"harvester\"\r\n" + 
				"}";
		return finalTemplate;
		
	}
	public String serverTemplate(DatabaseServer databaseServer)
	{
		String finalTemplate= "{\r\n" + 
				"    \"entity_type_name\": \"azure_sql_server\",\r\n" + 
				"    \"guid\":\""+databaseServer.getGuid()+"\",\r\n" + 
				"    \"attributes\": [{\r\n" + 
				"        \"attr_name\": \"qualifiedName\",\r\n" + 
				"        \"attr_value\": \""+databaseServer.getQualifiedName()+"\"\r\n" + 
				"    }, {\r\n" + 
				"        \"attr_name\": \"name\",\r\n" + 
				"        \"attr_value\": \""+databaseServer.getDatabaseServerUri()+"\",\r\n" + 
				"        \"is_entityref\": false\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"        \"attr_name\": \"resourceGroupName\",\r\n" + 
				"        \"attr_value\": \""+databaseServer.getResourceGroup()+"\",\r\n" + 
				"        \"is_entityref\": false\r\n" + 
				"    }\r\n" + 
				"    ],\r\n" + 
				"    \"created_by\": \"harvester-dwh\"\r\n" + 
				"}";
		return finalTemplate;
		
	}
	public String tableTemplate(Table table)
	{
		String finalTemplate= "{\r\n" + 
				"    \"entity_type_name\": \"azure_sql_table\",\r\n" + 
				"    \"guid\":\""+table.getGuid()+"\",\r\n" + 
				"    \"attributes\": [{\r\n" + 
				"        \"attr_name\": \"qualifiedName\",\r\n" + 
				"        \"attr_value\": \""+table.getQualifiedName()+"\"\r\n" + 
				"    }, {\r\n" + 
				"        \"attr_name\": \"name\",\r\n" + 
				"        \"attr_value\": \""+table.getTableName()+"\",\r\n" + 
				"        \"is_entityref\": false\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"        \"attr_name\": \"dbSchema\",\r\n" + 
				"        \"attr_value\": {\"guid\":\""+table.getSchema().getGuid()+"\",\"typeName\":\"azure_sql_schema\",\"optionalAttibutes\":{}}\r\n" + 
				"        \r\n" + 
				"    }\r\n" + 
				"    ],\r\n" + 
				"    \"created_by\": \"harvester\"\r\n" + 
				"}";
		return finalTemplate;
		
	}
	public String databaseTemplate(Database database)
	{
		String finalTemplate= "{\r\n" + 
				"    \"entity_type_name\": \"azure_sql_db\",\r\n" + 
				"    \"guid\":\""+database.getGuid()+"\",\r\n" + 
				"    \"attributes\": [{\r\n" + 
				"        \"attr_name\": \"qualifiedName\",\r\n" + 
				"        \"attr_value\": \""+database.getQualifiedName()+"\"\r\n" + 
				"    }, {\r\n" + 
				"        \"attr_name\": \"name\",\r\n" + 
				"        \"attr_value\": \""+database.getDatabaseName()+"\",\r\n" + 
				"        \"is_entityref\": false\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"        \"attr_name\": \"server\",\r\n" + 
				"        \"attr_value\": {\"guid\":\""+database.getDatabaseServer().getGuid()+"\",\"typeName\":\"azure_sql_server\",\"optionalAttibutes\":{}},\r\n" + 
				"        \"is_entityref\": false\r\n" + 
				"    }\r\n" + 
				"    ],\r\n" + 
				"    \"created_by\": \"harvester-dwh\"\r\n" + 
				"}";
		return finalTemplate;
		
	}
	public String columnTemplate(Column column)
	{
		String finalTemplate= "{\r\n" + 
				"   \"entity_type_name\": \"azure_sql_column\",\r\n" + 
				"   \"guid\": \""+column.getGuid()+"\",\r\n" + 
				"   \"created_by\": \"harvester-dwh\",\r\n" + 
				"   \"attributes\": [\r\n" + 
				"      {\r\n" + 
				"         \"attr_name\": \"qualifiedName\",\r\n" + 
				"         \"attr_value\": \""+column.getQualifiedName()+"\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"attr_name\": \"name\",\r\n" + 
				"         \"attr_value\": \""+column.getColumnName()+"\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"attr_name\": \"table\",\r\n" + 
				"         \"attr_value\": {\r\n" + 
				"            \"guid\": \""+column.getTable().getGuid()+"\",\r\n" + 
				"            \"typeName\": \"azure_sql_table\",\r\n" + 
				"            \"optionalAttibutes\": {}\r\n" + 
				"         }\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"attr_name\": \"data_type\",\r\n" + 
				"         \"attr_value\": \""+column.getColumnType()+"\"\r\n" + 
				"      }\r\n" + 
				"   ]\r\n" + 
				"}";
		return finalTemplate;
		
	}
}
