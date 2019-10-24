package com.ms.cse.harvestor.dwh.model;

public class Schema {
	private String schemaName;
	 private String qualifiedName;
	 private String guid;
	 private Database database;
	 private String tmpQualifiedName;
	 
	 
	 public String getTmpQualifiedName() {
		return tmpQualifiedName;
	}
	public void setTmpQualifiedName(String tmpQualifiedName) {
		this.tmpQualifiedName = tmpQualifiedName;
	}
	public Database getDatabase() {
		return database;
	}
	public void setDatabase(Database database) {
		this.database = database;
	}
	public String getQualifiedName() {
		return qualifiedName;
	}
	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}

	 public Schema(String schemaName, String databaseServerUri,String guid, String qualifiedName,Database database,String tmpQualifiedName ) {
		  super();
		  this.schemaName = schemaName;
		  this.guid = guid;
		  this.qualifiedName = qualifiedName;
		  this.database = database;
		  this.tmpQualifiedName=tmpQualifiedName;
		
		 }

	public Schema() {
		// TODO Auto-generated constructor stub
		 super();
		  this.schemaName = "";
		  this.guid = "";
		  this.qualifiedName = "";
		  this.database = null;
		
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}


}
