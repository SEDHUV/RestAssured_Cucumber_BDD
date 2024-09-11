package Req_Res_specificBuilders;

import POJOClasses_Oath_setter.SetterClass;
import POJOClasses_Oath_setter.location;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GoogleReqRes {

    public static void main(String[] args) {

        RestAssured.useRelaxedHTTPSValidation();
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
        RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();
        ResponseSpecification res1 = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
       RequestSpecification res = given().log().all().spec(req).body(sc);
       Response r  = res.when().post("/maps/api/place/add/json")
                .then().spec(res1).extract().response();
       System.out.println(r.asString());
    }
}