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
import com.ms.cse.harvestor.dwh.service.rest.AtlasEntiityBulkRestService;
import com.ms.cse.harvestor.dwh.service.rest.JSONGeneratorRestService;
import com.ms.cse.harvestor.dwh.service.rest.QnsRestService;
import com.ms.cse.harvestor.dwh.templates.JSONGeneratorTemplate;
import com.ms.cse.harvestor.dwh.templates.QnsTemplate;

public class AtlasEntityBulkServicesController {
public void processAllEntities( String inputJSON)
{
	System.out.println("AtlasEntityBulkServicesController - > processAllEntities - >"); 
	AtlasEntiityBulkRestService atlasEntiityBulkRestService= new AtlasEntiityBulkRestService();
	String json = atlasEntiityBulkRestService.postFunc(inputJSON);
    System.out.println("AtlasEntityBulkServicesController - > processAllEntities - > Final Result from Atlas Entity Bulk is ");
    System.out.println(json);
    }


}
