package com.testng;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.response.Response;
public class CurrencyAPI {
	@Test
	public void restAPIcurrencyTest() {
		Response response = given().get(
				"http://apilayer.net/api/live?access_key=af229148f763c8a67b208dd5984f3cd9&currencies = EUR,GBP,CAD,PLN&source = USD&format = 1");
		System.out.println(response.asString());
		response.then().statusCode(200);
		response.then().contentType("application/json");
		response.then().body("success", equalTo(true));
		System.out.println(response.asString());
		response.then().body("terms",equalTo("https://currencylayer.com/terms"));
	}
}