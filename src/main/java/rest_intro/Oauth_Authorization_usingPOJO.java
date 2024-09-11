package rest_intro;

import POJOClasses_Oath_getter.Pojoclass;
import POJOClasses_Oath_getter.WebAutomation;
import POJOClasses_Oath_getter.api;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Oauth_Authorization_usingPOJO {
    public static void main(String[] args) {
        RestAssured.useRelaxedHTTPSValidation();
        String[] expected = {"Selenium Webdriver Java","Cypress","Protractor"};
                String response =

                        given().formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

                                .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

                                .formParams("grant_type", "client_credentials")

                                .formParams("scope", "trust")

                                .when().log().all()

                                .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

                System.out.println(response);

                JsonPath jsonPath = new JsonPath(response);

                String accessToken = jsonPath.getString("access_token");

                System.out.println(accessToken);

                Pojoclass pc =    given()

                        .queryParams("access_token", accessToken)

                        .when()

                        .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")

                        .as(Pojoclass.class);//Deserialization


                System.out.println(pc.getInstructor());
                System.out.println(pc.getLinkedIn());
             List<api> api =  pc.getCourses().getApi();
        List<WebAutomation> Wa =  pc.getCourses().getWebAutomation();
             int sum =0;
//        for (api ap:api
//             ) { System.out.println(ap.getCourseTitle());
//
//        }
        for (int i = 0; i < api.size(); i++) {
           if(api.get(i).getCourseTitle().contains("SoapUI"))
                System.out.println(api.get(i).getCourseTitle());
         int price = Integer.parseInt(api.get(i).getPrice());
         sum= sum + price;}
        //another method
        ArrayList<String> actual = new ArrayList<String>();
        for (WebAutomation wb:
             Wa) {

        actual.add( wb.getCourseTitle());}
        System.out.println(actual.get(0));
        System.out.println(sum);
        Assert.assertEquals(90,sum);
        Assert.assertEquals(actual, Arrays.asList(expected));
        }}

