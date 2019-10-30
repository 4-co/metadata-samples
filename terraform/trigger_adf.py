import os
from azure.common.credentials import ServicePrincipalCredentials
from azure.mgmt.datafactory import DataFactoryManagementClient
 
credentials = ServicePrincipalCredentials(client_id=os.environ['ARM_CLIENT_ID'],
                                          secret=os.environ['ARM_CLIENT_SECRET'],
                                          tenant=os.environ['ARM_TENANT_ID'])
adf_client = DataFactoryManagementClient(credentials, os.environ['ARM_SUBSCRIPTION_ID'])
 
run_response = adf_client.pipelines.create_run(
    os.environ['DATAFACTORY_RG_NAME'],
    os.environ['DATAFACTORY_NAME'],
    'DataCopyWithLineage',
    parameters={})