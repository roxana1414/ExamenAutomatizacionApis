package com.examen.glue;

import com.examen.steps.PetStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetStoreStepDef {
    @Steps
    PetStoreStep order;

    @Given("la url es {string}")
    public void laUrlEs(String url) {
        order.definirURL(url);
    }
    @When("creo un orden con la siguiente información {string}")
    public void creoUnOrdenConLaSiguienteInformacion(String informacion) {
        order.crearOrder(informacion);
    }

    @Then("valido el codigo de respuesa sea {}")
    public void validoElCodigoDeRespuesaSea(int status) {
        order.validarStatus(status);
    }

    @And("valido el idOrder es {}")
    public void validarIdOrder(int idOrder) {
        order.validarIdOrder(idOrder);
    }

    @And("valido el petId es {}")
    public void validarPetId(int idPet) {
        order.validarPetId(idPet);
    }

    @And("valido el status es {}")
    public void validoElStatusEs(String statusOrder) {
        order.validarStatusOrder(statusOrder);
    }

}
