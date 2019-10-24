package com.ms.cse.harvestor.dwh.conf;


public  class Configurations {

	public Configurations(){

		Constants.SQLSERVERNAME=System.getenv("SqlServerName").split("~");

		Constants.SQLDBUSERNAME=System.getenv("SQLDBUserName").split("~");

		Constants.SQLDBPASSWORD=System.getenv("SQLPassword").split("~");
		Constants.SQLDBRESOURCEGROUP=System.getenv("SQLResourceGroup").split("~");
		Constants.QNSSERIVCE=System.getenv("QnsServiceUri");

		Constants.JSONGENERATORSERIVCE=System.getenv("JSONGeneratorUri");

		Constants.ATLASENTITYBULKSERIVCE=System.getenv("AtlasBulkEntitiyUri");

		
		Constants.TYPENAMES.put("server", "azure_sql_server");
		Constants.TYPENAMES.put("database", "azure_sql_db");
		Constants.TYPENAMES.put("schema", "azure_sql_schema");
		Constants.TYPENAMES.put("table", "azure_sql_table");
		Constants.TYPENAMES.put("column", "azure_sql_column");

	}
}
