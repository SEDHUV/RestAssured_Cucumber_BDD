package rest_intro;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth;

public class LibraryAPI {

//String isbn = "dt564738";
//String aisle = "sedhuhaema";
    @Test(dataProvider="getdata")
    public void Addbook(String isbn, String aisle) throws InterruptedException {
        RestAssured.baseURI = "http://216.10.245.166";
     String response =   given().header("Content-Type",
                "application/json").body(reusableMethods.AddBook(isbn,aisle)).when().post("Library/Addbook.php")

                .then().assertThat().statusCode(200).extract().response().asString();

     JsonPath js = reusableMethods.ResponseToJson(response);
        String id = js.get("ID");
     System.out.println(id);
     System.out.println(response);
        RestAssured.baseURI = "http://216.10.245.166";

        String response1 =   given().log().all().header("Content-Type",
                        "application/json").body(reusableMethods.deleteBook(id)).when().post("/Library/DeleteBook.php")
                .then().extract().response().asString();

        System.out.println(response1);
    }


    @DataProvider
    public Object[][] getdata(){


        return new Object[][] {{"t6gr","dgdvgsvgh"},{"gyde7","vwuvwuc88"}};
    }
}
