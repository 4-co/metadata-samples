package com.ms.cse.harvestor.dwh.conf;

import java.util.HashMap;

public class Constants {
	/**
     * The constant environment variable that we look to for the server name of sql server
     */
	
	public static String[] SQLSERVERNAME ;

	/**
      * The constant environment variable that we look to for the database name of sql server
     */
	
   // public static  String[] SQLDBNAME ;

    /**
      * The constant environment variable that we look to for the User Name of sql server
     */

    public static  String[] SQLDBUSERNAME ;

    /**
     * The constant environment variable that we look to for the PASSWORD of sql server
    */

    public static  String[] SQLDBPASSWORD;
    public static  String[] SQLDBRESOURCEGROUP;
    
    public static  String QNSSERIVCE;
    public static  String JSONGENERATORSERIVCE;
    public static  String ATLASENTITYBULKSERIVCE;
    public static HashMap<String, String> TYPENAMES = new HashMap<String, String>();


}
