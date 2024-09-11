package rest_intro;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class complexJsonparse {
    public static void main(String[] args) {
       JsonPath js = reusableMethods.ResponseToJson(reusableMethods.coursePrice());
       int coursesCount = js.getInt("courses.size");
       System.out.println(coursesCount);

      int purchaseAmount =  js.getInt("dashboard.purchaseAmount");
      System.out.println(purchaseAmount);

        String firstcourseName =  js.get("courses[0].title");
        System.out.println(firstcourseName);
        String courseNameexpected = "RPA";
        int sumTotal =0;
        int k =0;

        for (int i = 0; i < coursesCount; i++) {
            String courseName =  js.get("courses["+i+"].title");
            System.out.println(courseName);
            if(courseName.equals(courseNameexpected)){
                k=i;
            }
            int courseCopies =  js.getInt("courses["+i+"].copies");
            System.out.println(courseCopies);
            int coursePrice =  js.getInt("courses["+i+"].price");
            System.out.println(coursePrice);

            sumTotal = sumTotal+(coursePrice*courseCopies);

        }
        System.out.println(sumTotal);
        Assert.assertEquals(sumTotal,purchaseAmount);
        System.out.println(k);


        int RPA_Price = js.getInt("courses["+k+"].price");
        System.out.println(RPA_Price);
    }
}
