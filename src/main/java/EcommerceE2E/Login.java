package EcommerceE2E;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static io.restassured.RestAssured.given;

public class Login {
    public static void main(String[] args) {
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification res = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
       reqPOJOClass reqPOJOClass = new reqPOJOClass();
       reqPOJOClass.setUserEmail("sedhuhaema@gmail.com");
       reqPOJOClass.setUserPassword("Sedhu@14");

        RequestSpecification r = given().log().all().spec(res).body(reqPOJOClass);
       ResPOJOClass re = r.when().post("api/ecom/auth/login").then().log().all().extract().as(ResPOJOClass.class);
         // System.out.println(re.getUserId());
          String token = re.getToken();
          String userId = re.getUserId();

          //ADDToCart
        RequestSpecification productAddspec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization",token).build();
       RequestSpecification addP =  given().spec(productAddspec).param("productName","sivanidhi").param("productAddedBy",userId)
                .param("productCategory","fashion").param("productSubCategory","shirts")
                .param("productPrice","750").param("productDescription","Addias Originals")
                .param("productFor","women").multiPart("productImage",new File("C:\\Users\\SEDHU\\Downloads\\WhatsApp Image 2024-08-06 at 12.28.39 AM.jpeg"));
               AddproductPOJO addproductPOJO =  addP.when().post("api/ecom/product/add-product").then().extract().as(AddproductPOJO.class);
              String productID = addproductPOJO.getProductId();
                System.out.println(addproductPOJO.getMessage());

          //create order

        RequestSpecification createOrder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization",token).setContentType(ContentType.JSON).build();
        orderDetail od = new orderDetail();
        od.setCountry("India");
        od.setProductOrderedId(productID);
        List<orderDetail> od1 = new ArrayList<orderDetail>();
        od1.add(od);
        orders orders1 = new orders();
        orders1.setOrderdetails(od1);

        RequestSpecification rs = given().log().all().spec(createOrder).body(orders1);
       createOrderPOJO response = rs.when().post("api/ecom/order/create-order").then().log().all().extract().as(createOrderPOJO.class);
       List<String> resp = response.getOrders();
        String orderId = null;
        for (int i = 0; i < resp.size(); i++) {
            orderId = resp.get(i);
            System.out.println(orderId);
        }


        //verify Order details
        RequestSpecification ViewOrder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization",token).setContentType(ContentType.JSON).build();
RequestSpecification viewOrder = given().log().all().spec(ViewOrder).queryParam("id",orderId);
viewOrderPOJO VO = viewOrder.when().get("api/ecom/order/get-orders-details").then().extract().as(viewOrderPOJO.class);
String productId = VO.getData().get_id();
        Assert.assertEquals(orderId,productId);

        //delete product
        RequestSpecification deleteProDReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization",token).setContentType(ContentType.JSON).build();
       RequestSpecification deleteProDRe = given().log().all().spec(deleteProDReq).pathParam("productId",productID);
       String ProductResponse = deleteProDRe.when().delete("https://rahulshettyacademy.com/api/ecom/product/delete-product/{productId}").then().extract().response().asString();
   JsonPath js3 = new JsonPath(ProductResponse);
   String del = js3.getString("message");
   Assert.assertTrue(del.equals("Product Deleted Successfully"));


    //deleteOrder
    RequestSpecification deleteorderReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization",token).setContentType(ContentType.JSON).build();
    RequestSpecification deleteorderRe = given().log().all().spec(deleteorderReq).pathParam("orderId",orderId);
    String deleteOrderResponse = deleteorderRe.when().delete("api/ecom/order/delete-order/{orderId}").then().extract().response().asString();
    JsonPath js4 = new JsonPath(deleteOrderResponse);
    String del1 = js4.getString("message");
    System.out.println(del1);
   Assert.assertTrue(del1.equals("Orders Deleted Successfully"));
    }
}

