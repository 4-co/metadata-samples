package com.ms.cse.harvestor.dwh.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

import com.ms.cse.harvestor.dwh.conf.DBConnection;
import com.ms.cse.harvestor.dwh.model.DatabaseServer;
import com.ms.cse.harvestor.dwh.service.ColumnService;
import com.ms.cse.harvestor.dwh.service.DatabaseService;
import com.ms.cse.harvestor.dwh.service.SchemaService;
import com.ms.cse.harvestor.dwh.service.TableService;

public class MetadataDetails {
	static DatabaseService databaseService = new DatabaseService();;

	static TableService tableService = new TableService();
	static SchemaService schemaService = new SchemaService();

	static ColumnService columnService = new ColumnService();

	public void getDetails(String sqlServerUri, String sqlServerUserName, String sqlServerPassword,String sqlServerResourceGroup)
			throws IOException, Exception {

		Connection connection = DBConnection.getConnection(sqlServerUri, sqlServerUserName, sqlServerPassword);

		DatabaseMetaData metadata = connection.getMetaData();
		DatabaseServer databaseServer = new DatabaseServer();
		databaseServer.setTmpQualifiedName(sqlServerUri);
		databaseServer.setGuid(Integer.toString(MasterMetadataDetails.databaseServerGUID++));
		databaseServer.setDatabaseServerUri(sqlServerUri);
		databaseServer.setQualifiedName(sqlServerUri);
		databaseServer.setResourceGroup(sqlServerResourceGroup);
		MasterMetadataDetails.databaseServers.put(sqlServerUri, databaseServer);
		databaseService.getDatabaseDetails(metadata, databaseServer);
		connection.close();
		for (String key : MasterMetadataDetails.databases.keySet()) {
			connection = DBConnection.getConnection(
					sqlServerUri + ";database=" + key.substring(key.lastIndexOf('/') + 1), sqlServerUserName,
					sqlServerPassword);

			metadata = connection.getMetaData();
			// set Values of schemas
			schemaService.getSchemaDetails(metadata, MasterMetadataDetails.databases
					.get(databaseServer.getTmpQualifiedName() + "/" + key.substring(key.lastIndexOf('/') + 1)));
			// set Values of Tables
			tableService.getTableDetails(metadata, sqlServerUri);
			// set Values of Columns
			columnService.getColumnDetails(metadata);
		}

		connection.close();

	}
}
