# Install odbc drivers first. This code is for Ubuntu 18.04

# sudo curl https://packages.microsoft.com/keys/microsoft.asc | apt-key add -
# sudo curl https://packages.microsoft.com/config/ubuntu/18.04/prod.list > /etc/apt/sources.list.d/mssql-release.list
# sudo apt-get update
# sudo ACCEPT_EULA=Y apt-get install msodbcsql17
# # optional: for bcp and sqlcmd
# sudo ACCEPT_EULA=Y apt-get install mssql-tools unixodbc-dev
# echo 'export PATH="$PATH:/opt/mssql-tools/bin"' >> ~/.bash_profile
# echo 'export PATH="$PATH:/opt/mssql-tools/bin"' >> ~/.bashrc
# source ~/.bashrc

pip install -r requirements.txt

export base_storage_account_name=$(terraform output -state ../terraform.tfstate base_storage_account_name)
export adls_primary_access_key=$(terraform output -state ../terraform.tfstate adls_primary_access_key)
export adls_container_name=$(terraform output -state ../terraform.tfstate adls_container_name)
export base_sql_server_name=$(terraform output -state ../terraform.tfstate base_sql_server_name)
export base_sql_database_name=$(terraform output -state ../terraform.tfstate base_sql_database_name)
export base_sql_datawarehouse_name=$(terraform output -state ../terraform.tfstate base_sql_datawarehouse_name)
export sql_username=$(terraform output -state ../terraform.tfstate sql_username)
export sql_password=$(terraform output -state ../terraform.tfstate sql_password)

python adls.py
python sql_server.py
