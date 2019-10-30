from azure.storage.blob import BlockBlobService

#################### Insert Information ######################

ACCOUNT_NAME = "storage8e0c3b4b"
ACCOUNT_KEY = "iulF8EzP5hTQAqG4IuuByzUCSKKeajmwfC6i4PveCLunTsRZzZ84LiRisOcQaCejdb9cQ8AjuF2s2Zs6/kOssg=="
CONTAINER_NAME = "kiril-wgbs-test"

##############################################################

try:
    blob_service = BlockBlobService(account_name=ACCOUNT_NAME, account_key=ACCOUNT_KEY)

    blob_service.create_blob_from_path(CONTAINER_NAME, "example_sales_folder/testdata.csv", "./adls_files/testdata.csv")
    blob_service.create_blob_from_path(CONTAINER_NAME, "dbo.exampletable.txt", "./adls_files/dbo.exampletable.txt")   

except Exception as error:
    print("Error:", error)

