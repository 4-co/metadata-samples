package com.ms.cse.harvestor.dwh.service;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.ms.cse.harvestor.dwh.controller.MasterMetadataDetails;
import com.ms.cse.harvestor.dwh.model.Table;


public class TableService  {
	final static Logger logger = Logger.getLogger(TableService.class);
	

	public
	void getTableDetails(DatabaseMetaData metadata,String sqlServerUri) throws IOException, Exception  {
		  String tableNames[] = { "TABLE" };
		  
		  System.out.println("Inside TableServiceImpl - > getTableDetails");
	       ResultSet result = null;
	       result = metadata.getTables(null, null, null, tableNames);
	       while (result.next()) {
	    	   String TABLE_CAT = result.getString(1);
	            String TABLE_SCHEM = result.getString(2);
	            String TABLE_NAME = result.getString(3);
	            if(TABLE_SCHEM.toLowerCase().contains("sys")||
	            		TABLE_SCHEM.toLowerCase().contains("db_")||
	            		TABLE_SCHEM.toLowerCase().contains("information_schema")||
	            		TABLE_SCHEM.toLowerCase().contains("guest")

	            		)
	            	continue;
	    	   Table table= new Table();
	    	   table.setTableName(TABLE_NAME);
	    	   table.setGuid(Integer.toString(MasterMetadataDetails.tableGUID++));
	    	   table.setQualifiedName("");
	    	   table.setTmpQualifiedName(sqlServerUri+"/"+TABLE_CAT+"/"+TABLE_SCHEM+"/"+TABLE_NAME);
	    	   table.setSchema(MasterMetadataDetails.schemas.get(sqlServerUri+"/"+TABLE_CAT+"/"+TABLE_SCHEM));
	            MasterMetadataDetails.tables.put(sqlServerUri+"/"+TABLE_CAT+"/"+TABLE_SCHEM+"/"+TABLE_NAME, table);
	       }
	       

			}
	
	}
	


