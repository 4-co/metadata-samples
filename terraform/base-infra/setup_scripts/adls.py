import os
from azure.storage.blob import BlockBlobService

#################### Insert Information ######################

ACCOUNT_NAME = os.environ['base_storage_account_name']
ACCOUNT_KEY = os.environ['adls_primary_access_key']
CONTAINER_NAME = os.environ['adls_container_name']

##############################################################

try:
    blob_service = BlockBlobService(account_name=ACCOUNT_NAME, account_key=ACCOUNT_KEY)

    blob_service.create_blob_from_path(CONTAINER_NAME, "example_sales_folder/testdata.csv", "./adls_files/testdata.csv")
    blob_service.create_blob_from_path(CONTAINER_NAME, "dbo.exampletable.txt", "./adls_files/dbo.exampletable.txt")   

except Exception as error:
    print("Error:", error)
