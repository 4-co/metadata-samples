**Sql data warehouse harvester need below environment variables :**

* *SqlServerName* : uri for SQL server. If you are using multiple SQL Servers, please use ~ as separator
* *SQLDBUserName* : User Name for SQL server. If you are using multiple SQL Servers, please use ~ as separator
* *SQLPassword* : Password for SQL server. If you are using multiple SQL Servers, please use ~ as separator
* *SQLResourceGroup* : Password for SQL server. If you are using multiple SQL Servers, please use ~ as separator
* *QnsServiceUri* : full URI of QNS service(Including code) 

* *JSONGeneratorUri* : full URI of JSON Generator service(Including code)

* *AtlasBulkEntitiyUri* : full URI of Atlas entity bulk service


**Below is the command to deploy code as Azure-function:**
mvn azure-functions:deploy
