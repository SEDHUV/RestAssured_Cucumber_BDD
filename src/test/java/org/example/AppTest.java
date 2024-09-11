package org.example;

public class AppTest {


    public static void main(String[] args) {

        String name = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AQlEd8yteKf0lUZ3xdUspWTg890Qw_SdR1z3QNJ3pZBaoNUtsPJVWfY0lU9H2xFk3Jld5g&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
          String split = name.split("code=")[1];
          String finalresponse =split.split("&scope")[0].trim();
          System.out.println(finalresponse);

    }
}