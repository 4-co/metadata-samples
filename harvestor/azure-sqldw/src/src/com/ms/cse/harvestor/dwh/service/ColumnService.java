package com.ms.cse.harvestor.dwh.service;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import com.ms.cse.harvestor.dwh.controller.MasterMetadataDetails;
import com.ms.cse.harvestor.dwh.model.Column;
import com.ms.cse.harvestor.dwh.model.Table;

public class ColumnService {
	final static Logger logger = Logger.getLogger(ColumnService.class);

	public void getColumnDetails(DatabaseMetaData metadata) throws IOException, Exception {
		
		System.out.println("Inside ColumnServiceImpl - > getColumnDetails");
		ResultSet rs = null;

		Iterator hmIterator = MasterMetadataDetails.tables.entrySet().iterator();

		while (hmIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry) hmIterator.next();
			Table table = ((Table) mapElement.getValue());

			String stractualTable = table.getTableName();
			rs = metadata.getColumns(null, null, stractualTable, null);
			while (rs.next()) {
				String COLUMN_NAME = rs.getString("COLUMN_NAME");
				String TYPE_NAME = rs.getString("TYPE_NAME");
				String COLUMN_SIZE = rs.getString("COLUMN_SIZE");

				Column column = new Column();
				column.setColumnName(COLUMN_NAME);
				column.setGuid(Integer.toString(MasterMetadataDetails.columnsGUID++));
				column.setQualifiedName("");
				column.setTmpQualifiedName(table.getTmpQualifiedName() + "/" + COLUMN_NAME);
				column.setColumnLength(COLUMN_SIZE);
				column.setColumnType(TYPE_NAME);
				column.setTable(table);
				MasterMetadataDetails.columns.put(table.getTmpQualifiedName() + "/" + COLUMN_NAME, column);
			}

		}
	}
}
