package com.ms.cse.harvestor.dwh.controller;

import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

import com.ms.cse.harvestor.dwh.conf.Constants;
import com.ms.cse.harvestor.dwh.model.Column;
import com.ms.cse.harvestor.dwh.model.Database;
import com.ms.cse.harvestor.dwh.model.DatabaseServer;
import com.ms.cse.harvestor.dwh.model.Schema;
import com.ms.cse.harvestor.dwh.model.Table;
import com.ms.cse.harvestor.dwh.service.rest.QnsRestService;
import com.ms.cse.harvestor.dwh.templates.QnsTemplate;

public class QnsServicesController {
public void setGuids()
{
	System.out.println("^^^^^^^^^^^^^^^List of Columns^^^^^^^^^^^^^^^^^^^^^^"); 
	Iterator hmIterator = Constants.TYPENAMES.entrySet().iterator(); 
	Iterator hmIteratorInternal =null;
    while (hmIterator.hasNext()) { 
        Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
        String typeName = ((String)mapElement.getValue()); 
        System.out.println("ServicesController - > setGuids - > "+typeName);
        switch(typeName) {
        
		case "azure_sql_server":
			
			hmIteratorInternal = MasterMetadataDetails.databaseServers.entrySet().iterator(); 
	        while (hmIteratorInternal.hasNext()) { 
	            Map.Entry mapElementInternal = (Map.Entry)hmIteratorInternal.next(); 
	            DatabaseServer databaseServer = ((DatabaseServer)mapElementInternal.getValue()); 
	            QnsTemplate qnsTemplate= new QnsTemplate();
	            String input=qnsTemplate.serverTemplate(databaseServer.getDatabaseServerUri());
	            QnsRestService qns= new QnsRestService();
	            JSONObject json = qns.postFunc(typeName, input);
	            String qualifiedName = json.getString("qualifiedName");
	            databaseServer.setQualifiedName(qualifiedName);
			    boolean  isExists=json.getBoolean("isExists");;
			    String guid ="";
			    if(isExists)
			    {
			    	guid = json.getString("guid");
			    	databaseServer.setGuid(guid);
			    }
			   // System.out.println(mapElementInternal.getKey().toString()+"~"+qualifiedName+"~"+isExists);
			    MasterMetadataDetails.databaseServers.replace(mapElementInternal.getKey().toString(), databaseServer);
	        }
			break;
		case "azure_sql_db":
			hmIteratorInternal = MasterMetadataDetails.databases.entrySet().iterator(); 
	        while (hmIteratorInternal.hasNext()) { 
	            Map.Entry mapElementInternal = (Map.Entry)hmIteratorInternal.next(); 
	            Database database = ((Database)mapElementInternal.getValue()); 
	            QnsTemplate qnsTemplate= new QnsTemplate();
	            String input=qnsTemplate.databaseTemplate(database.getDatabaseServer().getDatabaseServerUri(),database.getDatabaseName());
	            QnsRestService qns= new QnsRestService();
	            JSONObject json = qns.postFunc(typeName, input);
	            String qualifiedName = json.getString("qualifiedName");
	            database.setQualifiedName(qualifiedName);
			    boolean  isExists=json.getBoolean("isExists");;
			    String guid ="";
			    //System.out.println(json.toString());
			    if(isExists)
			    {
			    	guid = json.getString("guid");
			    	database.setGuid(guid);
			    }
			    System.out.println(mapElementInternal.getKey().toString()+"~"+qualifiedName+"~"+isExists);
			    
			    MasterMetadataDetails.databases.replace(mapElementInternal.getKey().toString(), database);
	        }
			//input=qnsTemplate.serverTemplate(typeParameters[0]);
			break;
		case "azure_sql_schema":
			hmIteratorInternal = MasterMetadataDetails.schemas.entrySet().iterator(); 
	        while (hmIteratorInternal.hasNext()) { 
	            Map.Entry mapElementInternal = (Map.Entry)hmIteratorInternal.next(); 
	            Schema schema = ((Schema)mapElementInternal.getValue()); 
	            QnsTemplate qnsTemplate= new QnsTemplate();
	            String input=qnsTemplate.schemaTemplate(schema.getDatabase().getDatabaseServer().getDatabaseServerUri(),schema.getDatabase().getDatabaseName(),schema.getSchemaName());
	            QnsRestService qns= new QnsRestService();
	            JSONObject json = qns.postFunc(typeName, input);
	            String qualifiedName = json.getString("qualifiedName");
	            schema.setQualifiedName(qualifiedName);
			    boolean  isExists=json.getBoolean("isExists");;
			    String guid ="";
			    //System.out.println(json.toString());
			    if(isExists)
			    {
			    	guid = json.getString("guid");
			    	schema.setGuid(guid);
			    }
			  //  System.out.println(mapElementInternal.getKey().toString()+"~"+qualifiedName+"~"+isExists);
			    
			    MasterMetadataDetails.schemas.replace(mapElementInternal.getKey().toString(), schema);
	        }
			break;
		case "azure_sql_table":
			hmIteratorInternal = MasterMetadataDetails.tables.entrySet().iterator(); 
	        while (hmIteratorInternal.hasNext()) { 
	            Map.Entry mapElementInternal = (Map.Entry)hmIteratorInternal.next(); 
	            Table table = ((Table)mapElementInternal.getValue()); 
	            QnsTemplate qnsTemplate= new QnsTemplate();
	            String input=qnsTemplate.tableTemplate(table.getSchema().getDatabase().getDatabaseServer().getDatabaseServerUri(),table.getSchema().getDatabase().getDatabaseName(),table.getTableName());
	            QnsRestService qns= new QnsRestService();
	            JSONObject json = qns.postFunc(typeName, input);
	            String qualifiedName = json.getString("qualifiedName");
	            table.setQualifiedName(qualifiedName);
			    boolean  isExists=json.getBoolean("isExists");;
			    String guid ="";
			    //System.out.println(json.toString());
			    if(isExists)
			    {
			    	guid = json.getString("guid");
			    	table.setGuid(guid);
			    }
			   // System.out.println(mapElementInternal.getKey().toString()+"~"+qualifiedName+"~"+isExists);
			    
			    MasterMetadataDetails.tables.replace(mapElementInternal.getKey().toString(), table);
	        }
			break;
		case "azure_sql_column":
			hmIteratorInternal = MasterMetadataDetails.columns.entrySet().iterator(); 
	        while (hmIteratorInternal.hasNext()) { 
	            Map.Entry mapElementInternal = (Map.Entry)hmIteratorInternal.next(); 
	            Column column = ((Column)mapElementInternal.getValue()); 
	            QnsTemplate qnsTemplate= new QnsTemplate();
	            String input=qnsTemplate.columnTemplate(column.getTable().getSchema().getDatabase().getDatabaseServer().getDatabaseServerUri(),column.getTable().getSchema().getDatabase().getDatabaseName(),column.getTable().getTableName(),column.getColumnName());
	            QnsRestService qns= new QnsRestService();
	            JSONObject json = qns.postFunc(typeName, input);
	            String qualifiedName = json.getString("qualifiedName");
	            column.setQualifiedName(qualifiedName);
			    boolean  isExists=json.getBoolean("isExists");;
			    String guid ="";
			   // System.out.println(json.toString());
			    if(isExists)
			    {
			    	guid = json.getString("guid");
			    	column.setGuid(guid);
			    }
			  //  System.out.println(mapElementInternal.getKey().toString()+"~"+qualifiedName+"~"+isExists);
			    
			    MasterMetadataDetails.columns.replace(mapElementInternal.getKey().toString(), column);
	        }
		}
        //Qns.getFun(typeName);
    } 
}
}
