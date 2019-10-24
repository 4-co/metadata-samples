import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import sun.misc.BASE64Encoder;



public class apitestJSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//postFunc();
		fnwithUP();
	}
	
		 public static void getFun()
		 {
try {
	
				URL url = new URL("http://localhost:8080/RESTfulExample/json/product/get");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");


				

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			  }
		 }
		 
		 public static void postFunc()
		 {

			 try {

					URL url = new URL("http://admin:admin@40.127.72.92:21000/api/atlas/v2/ty");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Type", "application/json");

					String input = "{\r\n" + 
							"    \"entity\": {\r\n" + 
							"      \"typeName\": \"azure_sql_column\",\r\n" + 
							"      \"guid\":  \"4b0646ce-30a4-4002-8c1d-df45c2cfaa0e\",\r\n" + 
							"      \"createdBy\": \"Team_Awesome\",\r\n" + 
							"      \"attributes\": {\r\n" + 
							"        \"qualifiedName\": \"asset/categoryid\",\r\n" + 
							"        \"name\": \"CategoryID\",\r\n" + 
							"        \"data_type\":\"string\",\r\n" + 
							"        \"DataUpdateTimeStamp\":1570082649860,\r\n" + 
							"        \"FailedCount\":2000,\r\n" + 
							"        \"TotalCount\":10000000,\r\n" + 
							"        \"DQRules\":[\r\n" + 
							"            {\"guid\":\"fdd9443a-34f6-426d-a7c0-2d36921cdaf1\",\"typeName\":\"DQ_Rule\" ,\"uniqueAttributes\":{}},\r\n" + 
							"            {\"guid\":\"faf0e4b4-218a-464b-87e6-05f4d2ddae0d\",\"typeName\":\"DQ_Rule\",\"uniqueAttributes\":{}}\r\n" + 
							"            ]\r\n" + 
							"      \r\n" + 
							"              \r\n" + 
							"      }\r\n" + 
							"    }\r\n" + 
							"  }\r\n" + 
							"  \r\n" + 
							"";

					OutputStream os = conn.getOutputStream();
					os.write(input.getBytes());
					os.flush();
					/*System.out.println(HttpURLConnection.HTTP_CREATED);

					if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
						throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode()+conn.getResponseMessage());
					}*/

					BufferedReader br = new BufferedReader(new InputStreamReader(
							(conn.getInputStream())));

					String output;
					System.out.println("Output from Server .... \n");
					while ((output = br.readLine()) != null) {
						System.out.println(output);
					}

					conn.disconnect();

				  } catch (MalformedURLException e) {

					e.printStackTrace();

				  } catch (IOException e) {

					e.printStackTrace();

				 }
		 }
		 
		 public static void fnwithUP()
		 {


			 try {

					URL url = new URL("http://40.127.72.92:21000/api/atlas/v2/types/typedefs");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Type", "application/json");

					 BASE64Encoder enc = new sun.misc.BASE64Encoder();
				      String userpassword = "admin" + ":" + "admin";
				      String encodedAuthorization = enc.encode( userpassword.getBytes() );
				      conn.setRequestProperty("Authorization", "Basic "+
				            encodedAuthorization);
					
					
					
					String input = "{\r\n" + 
							"  \"enumDefs\": [],\r\n" + 
							"  \"structDefs\": [],\r\n" + 
							"  \"classificationDefs\": [],\r\n" + 
							"  \"entityDefs\": [\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_entity\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"Referenceable\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"name\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": true,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_attribute\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_entity\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"type\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": true,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"typeRef\",\r\n" + 
							"          \"typeName\": \"spark_data_type\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_dataset_attribute\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_attribute\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"dataset\",\r\n" + 
							"          \"typeName\": \"spark_dataset\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"constraints\": [\r\n" + 
							"            {\r\n" + 
							"              \"type\": \"inverseRef\",\r\n" + 
							"              \"params\": {\r\n" + 
							"                \"attribute\": \"attributes\"\r\n" + 
							"              }\r\n" + 
							"            }\r\n" + 
							"          ],\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": true,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ],\r\n" + 
							"      \"options\": {\r\n" + 
							"        \"schemaAttributes\": \"[\\\"name\\\", \\\"type\\\"]\"\r\n" + 
							"      }\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_job\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"Process\", \"spark_entity\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"id\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": true,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": true\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"operations\",\r\n" + 
							"          \"typeName\": \"array<spark_operation>\",\r\n" + 
							"          \"cardinality\": \"LIST\",\r\n" + 
							"          \"constraints\": [],\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"datasets\",\r\n" + 
							"          \"typeName\": \"array<spark_dataset>\",\r\n" + 
							"          \"cardinality\": \"LIST\",\r\n" + 
							"          \"constraints\": [],\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"inputDatasets\",\r\n" + 
							"          \"typeName\": \"array<spark_endpoint_dataset>\",\r\n" + 
							"          \"cardinality\": \"LIST\",\r\n" + 
							"          \"constraints\": [],\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": true,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"outputDatasets\",\r\n" + 
							"          \"typeName\": \"array<spark_endpoint_dataset>\",\r\n" + 
							"          \"cardinality\": \"LIST\",\r\n" + 
							"          \"constraints\": [],\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": true,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_operation\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"Process\", \"spark_entity\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": []\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_generic_operation\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"Process\", \"spark_operation\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"rawString\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": true,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_join_operation\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"Process\", \"spark_operation\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"joinType\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"condition\",\r\n" + 
							"          \"typeName\": \"spark_expression\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": true,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_filter_operation\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"Process\",\"spark_operation\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"condition\",\r\n" + 
							"          \"typeName\": \"spark_expression\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_project_operation\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"Process\",\"spark_operation\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"transformations\",\r\n" + 
							"          \"typeName\": \"array<spark_expression>\",\r\n" + 
							"          \"cardinality\": \"LIST\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_alias_operation\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"Process\",\"spark_operation\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"alias\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_sort_order\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_entity\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"expression\",\r\n" + 
							"          \"typeName\": \"spark_expression\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"direction\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"nullOrder\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_sort_operation\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"Process\",\"spark_operation\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"orders\",\r\n" + 
							"          \"typeName\": \"array<spark_sort_order>\",\r\n" + 
							"          \"cardinality\": \"LIST\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_aggregate_operation\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"Process\",\"spark_operation\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"groupings\",\r\n" + 
							"          \"typeName\": \"array<spark_expression>\",\r\n" + 
							"          \"cardinality\": \"LIST\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"aggregations\",\r\n" + 
							"          \"typeName\": \"array<spark_expression>\",\r\n" + 
							"          \"cardinality\": \"LIST\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_write_operation\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"Process\",\"spark_operation\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"appendMode\",\r\n" + 
							"          \"typeName\": \"boolean\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_dataset\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"DataSet\", \"spark_entity\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"attributes\",\r\n" + 
							"          \"typeName\": \"array<spark_attribute>\",\r\n" + 
							"          \"cardinality\": \"LIST\",\r\n" + 
							"          \"constraints\": [\r\n" + 
							"            {\r\n" + 
							"              \"type\": \"ownedRef\"\r\n" + 
							"            }\r\n" + 
							"          ],\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": true,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ],\r\n" + 
							"      \"options\": {\r\n" + 
							"        \"schemaElementsAttribute\": \"attributes\"\r\n" + 
							"      }\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_endpoint_dataset\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_dataset\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"endpoint\",\r\n" + 
							"          \"typeName\": \"Referenceable\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"endpointType\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"direction\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"format\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": true,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ],\r\n" + 
							"      \"options\": {\r\n" + 
							"        \"schemaElementsAttribute\": \"attributes\"\r\n" + 
							"      }\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_data_type\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_entity\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"nullable\",\r\n" + 
							"          \"typeName\": \"boolean\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_simple_data_type\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_data_type\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": []\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_struct_data_type\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_data_type\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"fields\",\r\n" + 
							"          \"typeName\": \"array<spark_struct_field>\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"constraints\": [\r\n" + 
							"            {\r\n" + 
							"              \"type\": \"ownedRef\"\r\n" + 
							"            }\r\n" + 
							"          ],\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": true,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ],\r\n" + 
							"      \"options\": {\r\n" + 
							"        \"schemaElementsAttribute\": \"fields\"\r\n" + 
							"      }\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_struct_field\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_attribute\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"parentType\",\r\n" + 
							"          \"typeName\": \"spark_struct_data_type\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"constraints\": [\r\n" + 
							"            {\r\n" + 
							"              \"type\": \"inverseRef\",\r\n" + 
							"              \"params\": {\r\n" + 
							"                \"attribute\": \"fields\"\r\n" + 
							"              }\r\n" + 
							"            }\r\n" + 
							"          ],\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": true,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ],\r\n" + 
							"      \"options\": {\r\n" + 
							"        \"schemaAttributes\": \"[\\\"name\\\", \\\"type\\\"]\"\r\n" + 
							"      }\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_array_data_type\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_data_type\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"elementType\",\r\n" + 
							"          \"typeName\": \"spark_data_type\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": true,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_expression\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_entity\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"dataType\",\r\n" + 
							"          \"typeName\": \"spark_data_type\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"expressionType\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"text\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"children\",\r\n" + 
							"          \"typeName\": \"array<spark_expression>\",\r\n" + 
							"          \"cardinality\": \"LIST\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": true,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_alias_expression\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_expression\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"alias\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_binary_expression\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_expression\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"symbol\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_attribute_reference_expression\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_expression\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"attributeId\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": true,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"attributeName\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": false,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    },\r\n" + 
							"    {\r\n" + 
							"      \"name\": \"spark_udf_expression\",\r\n" + 
							"      \"superTypes\": [\r\n" + 
							"        \"spark_expression\"\r\n" + 
							"      ],\r\n" + 
							"      \"typeVersion\": \"1.0\",\r\n" + 
							"      \"attributeDefs\": [\r\n" + 
							"        {\r\n" + 
							"          \"name\": \"functionName\",\r\n" + 
							"          \"typeName\": \"string\",\r\n" + 
							"          \"cardinality\": \"SINGLE\",\r\n" + 
							"          \"isIndexable\": false,\r\n" + 
							"          \"isOptional\": true,\r\n" + 
							"          \"isUnique\": false\r\n" + 
							"        }\r\n" + 
							"      ]\r\n" + 
							"    }\r\n" + 
							"  ]\r\n" + 
							"}";

					OutputStream os = conn.getOutputStream();
					os.write(input.getBytes());
					os.flush();
					/*System.out.println(HttpURLConnection.HTTP_CREATED);

					if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
						throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode()+conn.getResponseMessage());
					}*/
					System.out.println(conn.getResponseCode());
					System.out.println(conn.getResponseMessage());
					
					BufferedReader br = new BufferedReader(new InputStreamReader(
							(conn.getInputStream())));

					String output;
					System.out.println("Output from Server .... \n");
					while ((output = br.readLine()) != null) {
						System.out.println(output);
					}

					conn.disconnect();

				  } catch (MalformedURLException e) {

					e.printStackTrace();

				  } catch (IOException e) {

					e.printStackTrace();

				 }
			 
			 

		 }
	

}
