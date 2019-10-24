package com.ms.cse.harvestor.dwh.model;

public class Database {
	private String databaseName;
	private String tmpQualifiedName;


	private String qualifiedName;
	 private String guid;
	 private DatabaseServer databaseServer;
	 
	 public String getTmpQualifiedName() {
		return tmpQualifiedName;
	}
	public void setTmpQualifiedName(String tmpQualifiedName) {
		this.tmpQualifiedName = tmpQualifiedName;
	}
	 
	 public DatabaseServer getDatabaseServer() {
		return databaseServer;
	}
	public void setDatabaseServer(DatabaseServer databaseServer) {
		this.databaseServer = databaseServer;
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

	 public Database(String databaseName, String guid, String qualifiedName,DatabaseServer databaseServer,String tmpQualifiedName ) {
		  super();
		  this.databaseName = databaseName;
		  this.guid = guid;
		  this.qualifiedName = qualifiedName;
		  this.databaseServer = databaseServer;
		  this.tmpQualifiedName=tmpQualifiedName;
		 }

	public Database() {
		// TODO Auto-generated constructor stub
		 super();
		  this.databaseName = "";
		  
		  this.guid = "";
		  this.qualifiedName = "";
		  this.databaseServer = null;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}


}
