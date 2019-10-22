# coding=utf-8
# --------------------------------------------------------------------------
# Code generated by Microsoft (R) AutoRest Code Generator.
# Changes may cause incorrect behavior and will be lost if the code is
# regenerated.
# --------------------------------------------------------------------------

from msrest.serialization import Model


class Response(Model):
    """Response.

    :param entities:
    :type entities: list[~swagger.models.Entities]
    """

    _attribute_map = {
        'entities': {'key': 'entities', 'type': '[Entities]'},
    }

    def __init__(self, **kwargs):
        super(Response, self).__init__(**kwargs)
        self.entities = kwargs.get('entities', None)