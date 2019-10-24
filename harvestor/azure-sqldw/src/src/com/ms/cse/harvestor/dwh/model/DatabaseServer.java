package com.ms.cse.harvestor.dwh.model;

public class DatabaseServer {
	private String tmpQualifiedName;
	 private String databaseServerUri;
	 private String qualifiedName;
	 private String guid;
	 private String resourceGroup;
	 
	 
	 public String getResourceGroup() {
		return resourceGroup;
	}
	public void setResourceGroup(String resourceGroup) {
		this.resourceGroup = resourceGroup;
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

	 public DatabaseServer(String tmpQualifiedName, String databaseServerUri,String guid, String qualifiedName , String resourceGroup) {
		  super();
		  this.tmpQualifiedName = tmpQualifiedName;
		  this.databaseServerUri = databaseServerUri;
		  this.guid = guid;
		  this.qualifiedName = qualifiedName;
		  this.resourceGroup= resourceGroup;
		
		 }

	public DatabaseServer() {
		// TODO Auto-generated constructor stub
		 super();
		  this.tmpQualifiedName = "";
		  this.databaseServerUri = "";
		  this.guid = "";
		  this.qualifiedName = "";
		  this.resourceGroup="";
	}

	

	public String getTmpQualifiedName() {
		return tmpQualifiedName;
	}
	public void setTmpQualifiedName(String tmpQualifiedName) {
		this.tmpQualifiedName = tmpQualifiedName;
	}
	public String getDatabaseServerUri() {
		return databaseServerUri;
	}

	public void setDatabaseServerUri(String databaseServerUri) {
		this.databaseServerUri = databaseServerUri;
	}
}
