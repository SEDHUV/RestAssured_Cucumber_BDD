package POJOClasses_Oath_setter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GoogleMainClass {

    public static void main(String[] args) {

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        SetterClass sc = new SetterClass();
        sc.setAccuracy(50);
        sc.setAddress("29, side layout, cohen 09");
        sc.setPhone_number("4567865342");
        sc.setLanguage("french");
        sc.setName("Haema");
        sc.setWebsite("https://rahulshettyacademy.com");
        List<String> myList = new ArrayList<String>();
        myList.add("sedhu");
        myList.add("haema");
        sc.setTypes(myList);
        location loc = new location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        sc.setLocation(loc);

       Response response = given().log().all().queryParam("key","qaclick123").body(sc).when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();
       System.out.println(response.asString());
    }
}
