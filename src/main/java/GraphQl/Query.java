package GraphQl;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class Query {

    public static void main(String[] args) {
        RestAssured.useRelaxedHTTPSValidation();
        //query
       String response =  given().log().all().header("content-type","application/json")
                .body("{\"query\":\"query{\\n  character(characterId:8775){\\n    id\\n    name\\n    type\\n    status\\n    \\n    \\n  }\\n}\",\"variables\":null}\n")
                .when().post("https://rahulshettyacademy.com/gq/graphql").then().extract().response().asString();

       System.out.println(response);
        JsonPath js = new JsonPath(response);
        String characterName = js.get("data.character.name");
        System.out.println(characterName);
//mutation
        String response1 =  given().log().all().header("content-type","application/json")
                .body("{\"query\":\"mutation{\\n  \\ncreateCharacter(character:{name:\\\"sedhu\\\",type:\\\"actor\\\",status:\\\"alivewithhaema\\\",species:\\\"human\\\",gender:\\\"male\\\",image:\\\"png\\\",\\noriginId:13241,locationId:13241}){\\n  id\\n  \\n}\\n}\",\"variables\":null}")
                .when().post("https://rahulshettyacademy.com/gq/graphql").then().extract().response().asString();

        System.out.println(response1);
        JsonPath js1 = new JsonPath(response1);
       int characterId =  js1.get("data.createCharacter.id");
        System.out.println( characterId);
    }
}
