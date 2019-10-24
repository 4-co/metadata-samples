package com.ms.cse.harvestor.dwh.model;

public class Table {
	private String tableName;
	 private String qualifiedName;
	 private String guid;
	 private Schema schema;
	 private String tmpQualifiedName;
	 
	 
	 public String getTmpQualifiedName() {
		return tmpQualifiedName;
	}
	public void setTmpQualifiedName(String tmpQualifiedName) {
		this.tmpQualifiedName = tmpQualifiedName;
	}
	public Schema getSchema() {
		return schema;
	}
	public void setSchema(Schema schema) {
		this.schema = schema;
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

	 
	 
	 public Table(String tableName, String guid, String qualifiedName,Schema schema, String tmpQualifiedName) {
		  super();
		  this.tableName = tableName;
		  this.guid = guid;
		  this.qualifiedName = qualifiedName;
		  this.schema = schema;
		  this.tmpQualifiedName=tmpQualifiedName;
		 }
	 
	public Table() {
		// TODO Auto-generated constructor stub
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
