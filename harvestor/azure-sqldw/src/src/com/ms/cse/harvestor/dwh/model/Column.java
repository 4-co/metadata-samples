package com.ms.cse.harvestor.dwh.model;

public class Column {
	private String columnName;
	 private String columnType;
	 private String columnLength;
	 //private String serverUri;
	 //private String databaseName;
	 private Table table;
	 private String qualifiedName;
	 private String tmpQualifiedName;
	 public String getTmpQualifiedName() {
		return tmpQualifiedName;
	}
	public void setTmpQualifiedName(String tmpQualifiedName) {
		this.tmpQualifiedName = tmpQualifiedName;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	private String guid;
	 
	 
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
	public Column(String columnName, String columnType, String columnLength, Table table, String guid, String qualifiedName,String tmpQualifiedName ) {
		  super();
		  this.columnName = columnName;
		  this.columnType = columnType;
		  this.columnLength = columnLength;

		  this.table = table;
		  this.guid = guid;
		  this.qualifiedName = qualifiedName;
		  this.tmpQualifiedName=tmpQualifiedName;
		 }
	
	public Column() {
		// TODO Auto-generated constructor stub
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getColumnLength() {
		return columnLength;
	}
	public void setColumnLength(String columnLength) {
		this.columnLength = columnLength;
	}
}
