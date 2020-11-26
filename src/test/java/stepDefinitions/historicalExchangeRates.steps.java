package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import managers.FileReaderManager;

public class HistoricalExchangeRates {

	private Response response;
	private RequestSpecification request;
	private ValidatableResponse json;
	private FileReaderManager fileReaderManager = FileReaderManager.getInstance();



	@When("^rates API has the historical exchange rates$")
	public void rates_API_has_the_historical_exchange_rates(DataTable table) throws Throwable {
		//Table data passed from the feature steps
		List<List<String>> data = table.raw();

	}

	@When("^user request to get the historical rates with {BaseCurrency}, {currencyCode} and {Date}$")
	public void user_request_to_get_the_historical_rates_with_BaseCurrency_currencyCode_and_Date(BaseCurrency:) throws Throwable {

		//Getting the base URL for end-point
		List<List<String>> data = table.raw();

        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("id", data.get(1).get(0));

		RestAssured.baseURI = fileReaderManager.getConfigReader().getBaseUrl();
		request = RestAssured.given();
		// Making GET request with the passed data from the feature file
		response = request.queryParam("BaseCurrency", data.get(1).get(0)).queryParam("currencyCode", data.get(1).get(1)).get("/"+ data.get(1).get(2));
	}


	@And("^user get resonse as {BaseCurrency}, {currencyCode} and {date}$")
	public void user_get_resonse_as_BaseCurrency_currencyCode_and_date(DataTable table, String BaseCurrency, String currencyCode) throws Throwable {

		List<List<String>> data = table.raw();

		String responseBody = response.body().asString();

		//Assertion for response data
		assertEquals(responseBody.contains(data.get(1).get(0)), true);
		assertEquals(responseBody.contains(data.get(1).get(1)), true);

	}

	@Then("^validate the Content Type as \"([^\"]*)\"$")
	public void validate_the_Content_Type_as(String contentType) throws Throwable {
		//Assertion for Content type
	    assertEquals(response.contentType().contains(contentType), true);
	}



	@When("^user request to get the historical rates with {BaseCurrency}, {currencyCode} and invalid {Date}$")
	public void user_request_to_get_the_historical_rates_with_BaseCurrency_currencyCode_and_invalid_date(() throws Throwable {

		RestAssured.baseURI = fileReaderManager.getConfigReader().getBaseUrl();
		request = RestAssured.given();

		//Making Invalid request with invalid date format
		response = request.get("/1-1-1");//Invalid date format
    }


}
