package com.ms.cse.harvestor.dwh.controller;

import static java.lang.System.exit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ms.cse.harvestor.dwh.conf.Constants;
import com.ms.cse.harvestor.dwh.conf.DBConnection;
import com.ms.cse.harvestor.dwh.model.Column;
import com.ms.cse.harvestor.dwh.model.Database;
import com.ms.cse.harvestor.dwh.model.DatabaseServer;
import com.ms.cse.harvestor.dwh.model.Schema;
import com.ms.cse.harvestor.dwh.model.Table;
import com.ms.cse.harvestor.dwh.service.ColumnService;
import com.ms.cse.harvestor.dwh.service.DatabaseService;
import com.ms.cse.harvestor.dwh.service.TableService;
import org.apache.commons.collections4.map.MultiKeyMap;

public class MasterMetadataDetails {
	static DatabaseService databaseService = new DatabaseService();;
	

	
	static TableService tableService = new TableService();
	

	
	static ColumnService columnService = new ColumnService();
	
	static HashMap<String, DatabaseServer> databaseServers = new HashMap<String, DatabaseServer>();
	public static HashMap<String, Database> databases = new HashMap<String, Database>();
	public static HashMap<String, Schema> schemas = new HashMap<String, Schema>();
	public static HashMap<String, Table> tables = new HashMap<String, Table>();
	public static HashMap<String, Column> columns = new HashMap<String, Column>();
	
	
	public static int databaseServerGUID=-10000;
	public static int databaseGUID=-20000;
	public static int schemaGUID=-30000;
	public static int tableGUID=-40000;
	public static int columnsGUID=-50000;
	
	public void getDetails() throws IOException, Exception
	{
		
		for(int i=0;i<Constants.SQLSERVERNAME.length;i++)
		{
			MetadataDetails metadataDetails = new MetadataDetails();
			metadataDetails.getDetails(Constants.SQLSERVERNAME[i], Constants.SQLDBUSERNAME[i], Constants.SQLDBPASSWORD[i],Constants.SQLDBRESOURCEGROUP[i]);
		}
		//Call Qns Service to get Qualified Name and GUID
		QnsServicesController qnsServicesController= new QnsServicesController();
		qnsServicesController.setGuids();
		
		JSONGeneratorServicesController jSONGeneratorServicesController= new JSONGeneratorServicesController();
		String atlasAPIInput=jSONGeneratorServicesController.getFinalJSON();
		
		AtlasEntityBulkServicesController atlasEntityBulkServicesController= new AtlasEntityBulkServicesController();
		atlasEntityBulkServicesController.processAllEntities(atlasAPIInput);;
	
	}
	private void listObjects()
	{
		System.out.println("******************List of DatabaseServers*************************"); 
        Iterator hmIterator = MasterMetadataDetails.databaseServers.entrySet().iterator(); 
        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            DatabaseServer databaseServer = ((DatabaseServer)mapElement.getValue()); 
            System.out.println(mapElement.getKey() ); 
        } 
        System.out.println("******************List of Databases*************************"); 
        hmIterator = MasterMetadataDetails.databases.entrySet().iterator(); 
        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            Database database = ((Database)mapElement.getValue()); 
            System.out.println(mapElement.getKey()); 
        } 
        System.out.println("******************List of Schemas*************************"); 
        hmIterator = MasterMetadataDetails.schemas.entrySet().iterator(); 
        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            Schema schema = ((Schema)mapElement.getValue()); 
            System.out.println(mapElement.getKey() ); 
        } 
        System.out.println("******************List of Tables*************************"); 
        hmIterator = MasterMetadataDetails.tables.entrySet().iterator(); 
        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            Table table = ((Table)mapElement.getValue()); 
            System.out.println(mapElement.getKey() ); 
        } 
        System.out.println("******************List of Columns*************************"); 
        hmIterator = MasterMetadataDetails.columns.entrySet().iterator(); 
        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            Column column = ((Column)mapElement.getValue()); 
            System.out.println(mapElement.getKey() );
        } 
        
	}
}
