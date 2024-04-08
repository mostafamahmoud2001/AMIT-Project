package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D02_loginStepDef {

    @Given("user go to login page")
    public void userGoToLoginPage(){

    }
    @When("^user login with \"valid\" (.*) and (.*)$")
    public void loginWithEmailAndPassword(String email , String password){

    }
    @And("user press on login button")
    public void pressLoginButton(){

    }
    @Then("user login to the system successfully")
    public void userLoginToSystem(){

    }

}
