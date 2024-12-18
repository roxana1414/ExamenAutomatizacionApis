Feature: PetStore API

  @examen
  Scenario Outline: Crear Order

    Given la url es "https://petstore.swagger.io/v2"
    When creo un orden con la siguiente información <info>
    Then valido el codigo de respuesa sea <status>
    And valido el idOrder es <idOrder>
    And valido el petId es <idPet>
    And valido el status es <statusOrder>
    Examples:
      | info                                                                                                                           | status | idOrder | idPet | statusOrder |
      | "{\"id\":8,\"petId\":8,\"quantity\":1,\"shipDate\":\"2024-12-18T00:22:08.042Z\",\"status\":\"espera\",\"complete\":true}"      | 200    | 8       | 8     | espera      |
      | "{\"id\":99,\"petId\":65,\"quantity\":1,\"shipDate\":\"2024-12-18T00:22:08.042Z\",\"status\":\"entregado\",\"complete\":true}" | 200    | 99      | 65    | entregado   |
      | "{\"id\":14,\"petId\":25,\"quantity\":1,\"shipDate\":\"2024-12-18T00:22:08.042Z\",\"status\":\"espera\",\"complete\":true}"    | 200    | 14      | 25    | espera      |

  @examen
  Scenario Outline: Obtener Order
    Given la url para obtener un order es "https://petstore.swagger.io/v2"
    When consulta el order con el id <idOrder>
    Then valido el codigo de respuesa de obtener order es <status>
    And valido el idOrder del order Obtenido es <idOrderResponse>
    And valido el petId del order Obtenido es <idPetResponse>
    And valido el status del order Obtenido es <statusOrderResponse>
    Examples:
      | idOrder | status | idOrderResponse | idPetResponse | statusOrderResponse |
      | 8       | 200    | 8               | 8             | espera              |
      | 99      | 200    | 99              | 65            | entregado           |
      | 14      | 200    | 14              | 25            | espera              |
