# coding=utf-8
# --------------------------------------------------------------------------
# Code generated by Microsoft (R) AutoRest Code Generator.
# Changes may cause incorrect behavior and will be lost if the code is
# regenerated.
# --------------------------------------------------------------------------

from msrest.serialization import Model


class AzureCosmosdbDatabase(Model):
    """AzureCosmosdbDatabase.

    :param cosmosdb_uri:
    :type cosmosdb_uri: str
    :param cosmosdb_database:
    :type cosmosdb_database: str
    """

    _attribute_map = {
        'cosmosdb_uri': {'key': 'cosmosdb_uri', 'type': 'str'},
        'cosmosdb_database': {'key': 'cosmosdb_database', 'type': 'str'},
    }

    def __init__(self, **kwargs):
        super(AzureCosmosdbDatabase, self).__init__(**kwargs)
        self.cosmosdb_uri = kwargs.get('cosmosdb_uri', None)
        self.cosmosdb_database = kwargs.get('cosmosdb_database', None)
