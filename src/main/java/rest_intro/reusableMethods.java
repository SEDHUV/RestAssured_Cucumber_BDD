package rest_intro;

import io.restassured.path.json.JsonPath;

public  class reusableMethods {

     public static String body(){
String body = "{\n" +
        "  \"location\": {\n" +
        "    \"lat\": -38.383494,\n" +
        "    \"lng\": 33.427362\n" +
        "  },\n" +
        "  \"accuracy\": 50,\n" +
        "  \"name\": \"sedhu house\",\n" +
        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
        "  \"address\": \"29, side layout, cohen 09\",\n" +
        "  \"types\": [\n" +
        "    \"shoe park\",\n" +
        "    \"shop\"\n" +
        "  ],\n" +
        "  \"website\": \"http://rahulshettyacademy.com\",\n" +
        "  \"language\": \"French-IN\"\n" +
        "}\n";
return body;

    }

    public static JsonPath ResponseToJson(String response){
         JsonPath js = new JsonPath(response);
         return js;
     }

     public static String coursePrice(){
         return "{\n" +
                 "\n" +
                 "\"dashboard\": {\n" +
                 "\n" +
                 "\"purchaseAmount\": 940,\n" +
                 "\n" +
                 "\"website\": \"rahulshettyacademy.com\"\n" +
                 "\n" +
                 "},\n" +
                 "\n" +
                 "\"courses\": [\n" +
                 "\n" +
                 "{\n" +
                 "\n" +
                 "\"title\": \"Selenium Python\",\n" +
                 "\n" +
                 "\"price\": 50,\n" +
                 "\n" +
                 "\"copies\": 6\n" +
                 "\n" +
                 "},\n" +
                 "\n" +
                 "{\n" +
                 "\n" +
                 "\"title\": \"Cypress\",\n" +
                 "\n" +
                 "\"price\": 40,\n" +
                 "\n" +
                 "\"copies\": 4\n" +
                 "\n" +
                 "},\n" +
                 "\n" +
                 "{\n" +
                 "\n" +
                 "\"title\": \"RPA\",\n" +
                 "\n" +
                 "\"price\": 45,\n" +
                 "\n" +
                 "\"copies\": 10\n" +
                 "\n" +
                 "},\n" +
                 "  \n" +
                 "{\n" +
                 "\n" +
                 "\"title\": \"Protractor\",\n" +
                 "\n" +
                 "\"price\": 3,\n" +
                 "\n" +
                 "\"copies\": 10\n" +
                 "\n" +
                 "}\n" +
                 "]\n" +
                 "\n" +
                 "}";



     }

     public static String AddBook(String isbn, String aisle){

         return "{\n" +
                 "\n" +
                 "\"name\":\"Learn Appium Automation with Java\",\n" +
                 "\"isbn\":\""+isbn+"\",\n" +
                 "\"aisle\":\""+aisle+"\",\n" +
                 "\"author\":\"John foe\"\n" +
                 "}\n";
     }
    public static String deleteBook(String id){

        return "{\n" +
                " \n" +
                "\"ID\" : \""+id+"\"\n" +
                " \n" +
                "} \n";
    }

}
