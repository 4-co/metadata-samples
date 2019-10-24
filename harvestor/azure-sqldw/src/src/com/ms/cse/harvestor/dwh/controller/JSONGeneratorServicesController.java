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
import com.ms.cse.harvestor.dwh.service.rest.JSONGeneratorRestService;
import com.ms.cse.harvestor.dwh.service.rest.QnsRestService;
import com.ms.cse.harvestor.dwh.templates.JSONGeneratorTemplate;
import com.ms.cse.harvestor.dwh.templates.QnsTemplate;

public class JSONGeneratorServicesController {
public String getFinalJSON()
{
	System.out.println("JSONGeneratorServicesController - > getFinalJSON - >"); 
	JSONGeneratorRestService jSONGeneratorRestService= new JSONGeneratorRestService();
	String inputJSON= listAllEntitiesJSON();
	//System.out.println(inputJSON);
    String json = jSONGeneratorRestService.postFunc(inputJSON);
    //System.out.println("JSONGeneratorServicesController - > getFinalJSON - > Final Result from JSON Generator is ");
    //System.out.println(json);
    return json;
    }

private String listAllEntitiesJSON()
{
	String jSONGenetatorInput="";
	String jSONGenetatorServerInput="";
	String jSONGenetatorDatabaseInput="";
	String jSONGenetatorSchemaInput="";
	String jSONGenetatorTableInput="";
	String jSONGenetatorColumnInput="";
	JSONGeneratorTemplate jSONGeneratorTemplate= new JSONGeneratorTemplate();
	System.out.println("******************List of DatabaseServers*************************"); 
    Iterator hmIterator = MasterMetadataDetails.databaseServers.entrySet().iterator(); 
    while (hmIterator.hasNext()) { 
        Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
        DatabaseServer databaseServer = ((DatabaseServer)mapElement.getValue()); 
        String input=jSONGeneratorTemplate.serverTemplate(databaseServer);
        jSONGenetatorServerInput=jSONGenetatorServerInput+input+",";
    } 
    System.out.println("******************List of Databases*************************"); 
    hmIterator = MasterMetadataDetails.databases.entrySet().iterator(); 
    while (hmIterator.hasNext()) { 
        Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
        Database database = ((Database)mapElement.getValue()); 
        String input=jSONGeneratorTemplate.databaseTemplate(database);
        jSONGenetatorDatabaseInput=jSONGenetatorDatabaseInput+input+",";
    } 
    System.out.println("******************List of Schemas*************************"); 
    hmIterator = MasterMetadataDetails.schemas.entrySet().iterator(); 
    while (hmIterator.hasNext()) { 
        Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
        Schema schema = ((Schema)mapElement.getValue()); 
        String input=jSONGeneratorTemplate.schemaTemplate(schema);
        jSONGenetatorSchemaInput=jSONGenetatorSchemaInput+input+",";
    } 
    System.out.println("******************List of Tables*************************"); 
    hmIterator = MasterMetadataDetails.tables.entrySet().iterator(); 
    while (hmIterator.hasNext()) { 
        Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
        Table table = ((Table)mapElement.getValue()); 
        String input=jSONGeneratorTemplate.tableTemplate(table);
        jSONGenetatorTableInput=jSONGenetatorTableInput+input+",";
    } 
    System.out.println("******************List of Columns*************************"); 
    hmIterator = MasterMetadataDetails.columns.entrySet().iterator(); 
    while (hmIterator.hasNext()) { 
        Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
        Column column = ((Column)mapElement.getValue()); 
        String input=jSONGeneratorTemplate.columnTemplate(column);
        jSONGenetatorColumnInput=jSONGenetatorColumnInput+input+",";
    } 
    jSONGenetatorInput= jSONGenetatorServerInput
	+ jSONGenetatorDatabaseInput
	+ jSONGenetatorSchemaInput
	+ jSONGenetatorTableInput
	+ jSONGenetatorColumnInput;
    
    jSONGenetatorInput=jSONGenetatorInput.substring(0, jSONGenetatorInput.lastIndexOf(","));
    jSONGenetatorInput="["+jSONGenetatorInput+"]";
    return jSONGenetatorInput;
}
}
