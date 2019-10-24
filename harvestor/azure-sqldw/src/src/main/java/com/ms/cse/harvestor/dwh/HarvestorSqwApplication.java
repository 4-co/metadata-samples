package com.ms.cse.harvestor.dwh;

import java.util.HashMap;

import com.microsoft.azure.functions.ExecutionContext;
import com.ms.cse.harvestor.dwh.conf.Configurations;
import com.ms.cse.harvestor.dwh.controller.MasterMetadataDetails;
import com.ms.cse.harvestor.dwh.model.DatabaseServer;

public class HarvestorSqwApplication {

	static {
		try {
			Configurations config = new Configurations();

		} catch (Exception e) {
			System.err.println("There was an error getting the connection: " + e.getMessage());
		}

	}

	public static void run(ExecutionContext context) throws Exception {
		 context.getLogger().info("HarvestorSqwApplication App Started");
		System.out.println("HarvestorSqwApplication App Started");
		try {

			HashMap<String, DatabaseServer> databaseServer = new HashMap<String, DatabaseServer>();
			MasterMetadataDetails masterMetadataDetails = new MasterMetadataDetails();
			masterMetadataDetails.getDetails(context);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
