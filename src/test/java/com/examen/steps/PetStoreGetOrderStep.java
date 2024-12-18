package com.examen.steps;

import com.examen.model.Order;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class PetStoreGetOrderStep {
    Response response;
    private String URL_BASE;
    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void consultarOrder(String idOrder) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .log().all()
                .get("/store/order/"+idOrder)
                .then()
                .log().all()
                .extract().response();
    }

    public void validarStatusResponse(int statusResponse) {
        Assert.assertEquals("Validacion de Respuesta", statusResponse, response.statusCode());
    }

    public void validarIdOrder(int idOrder) {
        Order order = response.jsonPath().getObject("", Order.class);
        Assert.assertEquals("Validacion de idOrder", idOrder, order.getId());
    }

    public void validarPetId(int idPet) {
        Order order = response.jsonPath().getObject("", Order.class);
        Assert.assertEquals("Validacion de idOrder", idPet, order.getPetId());
    }

    public void validarStatusOrder(String statusOrder) {
        Order order = response.jsonPath().getObject("", Order.class);
        Assert.assertEquals("Validacion de statusOrder", statusOrder, order.getStatus());
    }
}
