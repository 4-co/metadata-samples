# coding=utf-8
# --------------------------------------------------------------------------
# Code generated by Microsoft (R) AutoRest Code Generator.
# Changes may cause incorrect behavior and will be lost if the code is
# regenerated.
# --------------------------------------------------------------------------

from msrest.serialization import Model


class RequestDescription(Model):
    """RequestDescription.

    :param pattern:
    :type pattern: str
    :param input_parameters:
    :type input_parameters: list[~swagger.models.InputParameters]
    :param input_format:
    :type input_format: str
    :param description:
    :type description: str
    """

    _attribute_map = {
        'pattern': {'key': 'pattern', 'type': 'str'},
        'input_parameters': {'key': 'input_parameters', 'type': '[InputParameters]'},
        'input_format': {'key': 'input_format', 'type': 'str'},
        'description': {'key': 'description', 'type': 'str'},
    }

    def __init__(self, *, pattern: str=None, input_parameters=None, input_format: str=None, description: str=None, **kwargs) -> None:
        super(RequestDescription, self).__init__(**kwargs)
        self.pattern = pattern
        self.input_parameters = input_parameters
        self.input_format = input_format
        self.description = description
