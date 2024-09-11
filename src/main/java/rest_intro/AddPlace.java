package rest_intro;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddPlace {

    reusableMethods payload = new reusableMethods();


    public static void main(String[] args) {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI="https://rahulshettyacademy.com";
       String response = given().log().all().queryParam("key","qaclick123").header("Content-Type",
                "application/json").body(reusableMethods.body()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
        JsonPath js = new JsonPath(response);
       String placeId = js.get("place_id");
       System.out.println(response);
       System.out.println(placeId);

       String newAddress = "7walk, USA";

       given().log().all().queryParam("key","qaclick123").header("Content-Type",
               "application/json")
               .body("{\n" +
                       "\"place_id\":\""+placeId+"\",\n" +
                       "\"address\":\""+newAddress+"\",\n" +
                       "\"key\":\"qaclick123\"\n" +
                       "}\n")
               .when().put("maps/api/place/update/json")
               .then().assertThat().statusCode(200)
               .body("msg",equalTo("Address successfully updated"));

      String updatedinfo = given().queryParam("key","qaclick123").queryParam("place_id",placeId).when().get("maps/api/place/get/json")
             .then().assertThat().log().all().statusCode(200).extract().response().asString();
//               .body("address",equalTo("7walk, USA"));
       JsonPath value = reusableMethods.ResponseToJson(updatedinfo);
       String val = value.get("address");
       System.out.println(val);
        Assert.assertEquals(val,newAddress);


    }


}
