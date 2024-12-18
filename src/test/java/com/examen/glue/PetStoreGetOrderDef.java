package com.examen.glue;

import com.examen.steps.PetStoreGetOrderStep;
import com.examen.steps.PetStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetStoreGetOrderDef {
    @Steps
    PetStoreGetOrderStep getOrder;

    @Given("la url para obtener un order es {string}")
    public void laUrlEs(String url) {
        getOrder.definirURL(url);
    }

    @When("consulta el order con el id {}")
    public void consultarOrder(String idOrder) {
        getOrder.consultarOrder(idOrder);
    }

    @Then("valido el codigo de respuesa de obtener order es {}")
    public void validarStatusResponse(int statusResponse) {
        getOrder.validarStatusResponse(statusResponse);
    }

    @And("valido el idOrder del order Obtenido es {}")
    public void validarIdOrder(int idOrder) {
        getOrder.validarIdOrder(idOrder);
    }

    @And("valido el petId del order Obtenido es {}")
    public void validarPetId(int idPet) {
        getOrder.validarPetId(idPet);
    }

    @And("valido el status del order Obtenido es {}")
    public void validarStatusOrder(String statusOrder) {
        getOrder.validarStatusOrder(statusOrder);
    }
}
