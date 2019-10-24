package com.ms.cse.harvestor.dwh.service;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.ms.cse.harvestor.dwh.controller.MasterMetadataDetails;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;

import com.ms.cse.harvestor.dwh.model.Database;
import com.ms.cse.harvestor.dwh.model.Schema;

public class SchemaService {
	final static Logger logger = Logger.getLogger(SchemaService.class);

	public void getSchemaDetails(DatabaseMetaData metadata, Database database) throws IOException, Exception {

		System.out.println("Inside Schema Service : getSchemaDetails+");
		ResultSet result = metadata.getSchemas();

		while (result.next()) {

			String TABLE_SCHEM = result.getString(1);

			if (TABLE_SCHEM.toLowerCase().contains("sys") || TABLE_SCHEM.toLowerCase().contains("db_")
					|| TABLE_SCHEM.toLowerCase().contains("information_schema")
					|| TABLE_SCHEM.toLowerCase().contains("guest")

			)
				continue;
			Schema schema = new Schema();
			schema.setSchemaName(TABLE_SCHEM);
			schema.setDatabase(database);
			schema.setGuid(Integer.toString(MasterMetadataDetails.schemaGUID++));
			schema.setQualifiedName("");
			schema.setTmpQualifiedName(database.getTmpQualifiedName() + "/" + TABLE_SCHEM);
			// System.out.println(TABLE_SCHEM);
			MasterMetadataDetails.schemas.put(database.getTmpQualifiedName() + "/" + TABLE_SCHEM, schema);
		}

	}

}
