package stepDefinition;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import pojo.APIResponse;
import pojo.Location;
import pojo.Network;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * 
 * @author swetabhadani
 *
 */
public class TestCityBikes {

	@Given("^The User has CityBike URL$")
	public void cityBikes_uri() throws Throwable {
		RestAssured.baseURI = "http://api.citybik.es/v2";

	}

	@When("^User requests to check the networks of city bike, gets a success with status code 200$")
	public void user_requests_for_citybikes() {

		int statusCode = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).get("/networks")
				.getStatusCode();

		Assert.assertEquals(200, statusCode);

	}

	@When("^User verifys the country of the city Frankfurt, he gets Germany\\(DE\\) and their corresponding latitude and longitude$")
	public void user_verifies_country_for_a_given_city() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		String response = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).get("/networks")
				.then().extract().response().asString();

		APIResponse apiresponse = mapper.readValue(response, APIResponse.class);
		//System.out.println(apiresponse.getNetworks().size());

		List<Network> networkList = apiresponse.getNetworks();
		String country = "ABC";
		double latitude = 0;
		double longitude = 0;
		for (int i = 0; i < networkList.size(); i++) {
			Location location = networkList.get(i).getLocation();
			if (location.getCity().equals(("Frankfurt"))) {
				country = location.getCountry();
				latitude = location.getLatitude();
				longitude = location.getLongitude();

			}

		}
		Assert.assertEquals("DE", country);
		System.out.println("The city Frankfurt is in " + country);
		System.out.println("Latitude= " + latitude + "\n Longitude= " + longitude);
	}
				
	@When("^User makes a request with incorrect URI gets a response code of 404$")
	public void user_hits_incorrect_uri() {

		int clientErrorStatusCode = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
				.get("/network").getStatusCode();

		Assert.assertEquals(404, clientErrorStatusCode);
	}

}
