package testCases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ListOfMethods {

	@Test(description = "to demostarte the get method")
	public void getGenericMethod(String url) {
		Response res = given().when().get(url);
		System.out.println("Response is " + res.asString());
		System.out.println(res.path("data.email").toString());
		assertEquals(res.getStatusCode(), 200);

	}

	@Test(description = "Another Method")
	public void getMethod1() {
		Response res = given().when().get("https://reqres.in/api/unknown");
		System.out.println("Response is " + res.asString());
		assertEquals(res.getStatusCode(), 200);

	}

	@Test(description = "Method With Query Parameter")
	public void getMethod2() {

		Response res = given().queryParam("page", "2").when().get("https://reqres.in/api/users");

		System.out.println("Response is " + res.asString());
		assertEquals(res.getStatusCode(), 200);

	}
	
	@Test(description = "post Method")
	public void postMethod() {

		Response res=given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
				
				.header("Content-Type","application/json")	 
				.when().post("https://reqres.in/api/users");
		
		System.out.println(res.asString());

	}
	
	@Test(description = "post Method with json file")
	public void postMethodWithJsonFile() throws IOException {
		
		FileInputStream file =new FileInputStream(new File(System.getProperty("user.dir")+"//data/data.json"));

		Response res = given().body(IOUtils.toString(file))
				
				.header("Content-Type","application/json")	 
				.when().post("https://reqres.in/api/users");
		
		System.out.println(res.asString());

	}
	
	@Test(description = "put Method")
	public void putMethod() {

		Response res=given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}")
				
				.header("Content-Type","application/json")	 
				.when().put("https://reqres.in/api/users/2");
		
		System.out.println(res.asString());

	}
	
	@Test(description = "Put Method with json file")
	public void putMethodWithJsonFile() throws IOException {
		
		FileInputStream file =new FileInputStream(new File(System.getProperty("user.dir")+"//data/dataPut.json"));

		Response res = given().body(IOUtils.toString(file))
				
				.header("Content-Type","application/json")	 
				.when().put("https://reqres.in/api/users/2");
		
		System.out.println(res.asString());

	}
	
	@Test(description = "Patch Method")
	public void patchMethod() {

		Response res=given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}")
				
				.header("Content-Type","application/json")	 
				.when().patch("https://reqres.in/api/users/2");
		
		System.out.println(res.asString());

	}
	
	@Test(description = "Patch Method with json file")
	public void patchMethodWithJsonFile() throws IOException {
		
		FileInputStream file =new FileInputStream(new File(System.getProperty("user.dir")+"//data/dataPatch.json"));

		Response res = given().body(IOUtils.toString(file))
				
				.header("Content-Type","application/json")	 
				.when().patch("https://reqres.in/api/users/2");
		
		System.out.println(res.asString());

	}
	
	@Test(description = "Delete Method")
	public void deleteMethod() {

		Response res = given().when().delete("https://reqres.in/api/users/2");
		System.out.println("Response is " + res.asString());
		assertEquals(res.getStatusCode(), 204);

	}
	

}
