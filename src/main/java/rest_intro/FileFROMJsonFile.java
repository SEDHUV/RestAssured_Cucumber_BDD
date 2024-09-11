package rest_intro;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class FileFROMJsonFile {

    @Test
    public void AddbookFilefromjson() throws InterruptedException, IOException {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().header("Content-Type",
                        "application/json").body(new String(Files.readAllBytes(Paths.get("C:\\Users\\SEDHU\\Downloads\\add.json")))).when().post("Library/Addbook.php")

                .then().assertThat().statusCode(200).extract().response().asString();

        JsonPath js = reusableMethods.ResponseToJson(response);
        String id = js.get("ID");
        System.out.println(id);
        System.out.println(response);
    }
}