package OAuth2;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class RestAssuredTest {

    public static void main(String[] args) {
        RestAssured.useRelaxedHTTPSValidation();
//        ChromeOptions options= new ChromeOptions();
//        options.setAcceptInsecureCerts(true);
//        options.addArguments("--no-sandbox");
//        options.addArguments("--allow-http-screen-capture");
//        options.addArguments("--disable-impl-side-painting");
//        options.addArguments("--disable-setuid-sandbox");
//        options.addArguments("--disable-seccomp-filter-sandbox");
//        WebDriver driver = new EdgeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
//        driver.findElement(By.id("identifierId")).sendKeys("sedhubme17@gmail.com");
//        driver.findElement(By.xpath("(//span[@jsname='V67aGc'])[2]")).click();
        //google stopped automation sites to automate authorization on web so directly copying code and pasting here
        //example
        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AQlEd8yteKf0lUZ3xdUspWTg890Qw_SdR1z3QNJ3pZBaoNUtsPJVWfY0lU9H2xFk3Jld5g&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
        String split = url.split("code=")[1];
        String finalresponse =split.split("&scope")[0].trim();
        System.out.println(finalresponse);


        String accesstokenresponse = given().log().all().urlEncodingEnabled(false).queryParam("code",finalresponse)
                .queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
                .queryParam("grant_type","authorization_code")
                .when().post("https://www.googleapis.com/oauth2/v4/token").asString();

        JsonPath js = new JsonPath(accesstokenresponse);
        String accessToken = js.get("access_token");

        String response = given().queryParam("access_token",accessToken).when().get("https://rahulshettyacademy.com/getCourse.php")
                .asString();

        System.out.println(response);
    }
}
