package rest_intro;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JiraAPI {
    public static void main(String[] args) {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI="https://sedhubme17.atlassian.net";
       String response =  given().header("Content-Type",
                "application/json").header("Authorization","Basic c2VkaHVibWUxN0BnbWFpbC5jb206QVRBVFQzeEZmR0YwOENZS2FlZnlSN3pKUG1iRkVmY3lvY2w3Y1AtQkJZZmNDWk9rWlBIU2Nnd1lhX3Zfa0g1YkVOYVNUTWN3OFI4ZUNpckR5YXNWT29mNkVyMVVkVXZmTDBTZGtQdVNyUjljMXZaYmZhXzduakdHeGVqNGlaS0FNS1lINFpjaTYxcFdNWE1CblE0d25Sb1ktdnNsNTlkS2FaS0xkWEpaMVVqR3p2NDB1UThpRENJPTRFRjYxNTA2")
                .log().all().body("{\n" +
                        "    \"fields\": {\n" +
                        "       \"project\":\n" +
                        "       {\n" +
                        "          \"key\": \"SCRUM\"\n" +
                        "       },\n" +
                        "       \"summary\": \"sedhu QA architect\",\n" +
                        "       \"issuetype\": {\n" +
                        "          \"name\": \"Bug\"\n" +
                        "       }\n" +
                        "   }\n" +
                        "}") .post("rest/api/3/issue").then().log().all().assertThat().statusCode(201).extract().response().asString();

       JsonPath js =  reusableMethods.ResponseToJson(response);
       String issueID = js.get("id");
       System.out.println(issueID);

       given().pathParam("key",issueID).header("X-Atlassian-Token","no-check")
.header("Authorization","Basic c2VkaHVibWUxN0BnbWFpbC5jb206QVRBVFQzeEZmR0YwOENZS2FlZnlSN3pKUG1iRkVmY3lvY2w3Y1AtQkJZZmNDWk9rWlBIU2Nnd1lhX3Zfa0g1YkVOYVNUTWN3OFI4ZUNpckR5YXNWT29mNkVyMVVkVXZmTDBTZGtQdVNyUjljMXZaYmZhXzduakdHeGVqNGlaS0FNS1lINFpjaTYxcFdNWE1CblE0d25Sb1ktdnNsNTlkS2FaS0xkWEpaMVVqR3p2NDB1UThpRENJPTRFRjYxNTA2")
               .multiPart("file",new File("C:\\Users\\SEDHU\\Downloads\\image_750x_63d2265416e91.jpg")).log().all()
               .post("rest/api/3/issue/{key}/attachments").then().assertThat().statusCode(200);
    }
}
