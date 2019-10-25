package com.ms.cse.harvester.dwh;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/HttpTrigger-Java". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpTrigger-Java&code={your function key}
     * 2. curl "{your host}/api/HttpTrigger-Java?name=HTTP%20Query&code={your function key}"
     * Function Key is not needed when running locally, it is used to invoke function deployed to Azure.
     * More details: https://aka.ms/functions_authorization_keys
     */
	@FunctionName("harvestor-dwh")
	public void keepAlive(
	  @TimerTrigger(name = "harvesterDwhTrigger", schedule = "0 */5 * * * *") String timerInfo,
	      ExecutionContext context
	 ) {
        context.getLogger().info("Inside Java Timer trigger processing harvester sql request.");
        try {
			HarvesterSqwApplication.run(context);
			context.getLogger().info("*********End of HarvesterSqwApplication************");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }
}
