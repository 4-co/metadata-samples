package com.ms.cse.harvestor.dwh.service;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ms.cse.harvestor.dwh.controller.MasterMetadataDetails;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;

import com.ms.cse.harvestor.dwh.model.Database;
import com.ms.cse.harvestor.dwh.model.DatabaseServer;

public class DatabaseService {
	final static Logger logger = Logger.getLogger(DatabaseService.class);

	public void getDatabaseDetails(DatabaseMetaData metadata, DatabaseServer databaseServer)
			throws IOException, Exception {

		HashMap<String, Database> databases = new HashMap<String, Database>();
		System.out.println("Inside Database Service -> getDatabaseDetails+");
		// ArrayList<Database> tables = null;
		ResultSet result = metadata.getCatalogs();
		while (result.next()) {
			String aDBName = result.getString(1);
			if (aDBName.toLowerCase().equals("master"))
				continue;
			Database database = new Database();
			database.setDatabaseName(aDBName);
			database.setDatabaseServer(databaseServer);
			database.setGuid(Integer.toString(MasterMetadataDetails.databaseGUID++));
			database.setQualifiedName("");
			database.setTmpQualifiedName(databaseServer.getTmpQualifiedName() + "/" + aDBName);
			MasterMetadataDetails.databases.put(databaseServer.getTmpQualifiedName() + "/" + aDBName, database);
		}

	}

}
