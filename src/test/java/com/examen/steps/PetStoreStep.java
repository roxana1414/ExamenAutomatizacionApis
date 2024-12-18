package com.examen.steps;

import com.examen.model.Order;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class PetStoreStep {

    Response response;
    private String URL_BASE;
    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void crearOrder(String informacion) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .body(informacion)
                .log().all()
                .post("/store/order")
                .then()
                .log().all()
                .extract().response();
    }

    public void validarStatus(int statusCode) {
        Assert.assertEquals("Validacion de Respuesta", statusCode, response.statusCode());
    }


    public void validarIdOrder(int idOrder) {
        Order order = response.jsonPath().getObject("", Order.class);
        Assert.assertEquals("Validacion de idOrder", idOrder, order.getId());
    }

    public void validarPetId(int idPet) {

        Order order = response.jsonPath().getObject("", Order.class);
        Assert.assertEquals("Validacion de petId", idPet, order.getPetId());
    }

    public void validarStatusOrder(String statusOrder) {
        Order order = response.jsonPath().getObject("", Order.class);
        Assert.assertEquals("Validacion de status order", statusOrder, order.getStatus());
    }
}
