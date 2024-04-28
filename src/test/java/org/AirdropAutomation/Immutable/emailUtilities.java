package org.AirdropAutomation.Immutable;

import io.restassured.path.json.JsonPath;

import java.util.Random;
import java.util.random.RandomGenerator;

import static io.restassured.RestAssured.*;

public class emailUtilities {

    public static void randomEmailGen(){

        StringBuffer address = new StringBuffer();

        for (int i = 0; i < 25; i++) {
            Random r = new Random();
            char c = (char)(r.nextInt(26) + 'a');
            address.append(c);
        }
        address.append("@fthcapital.com");

        email.address=address.toString();
    }

    public static void createAccount(){

        String requestBody = "{\n" +
                "  \"address\": \""+email.address+"\",\n" +
                "  \"password\": \"Krishna@123\"\n" +
                "}";


        String responseBodyString = given().contentType("application/ld+json").body(requestBody).
                when().post("https://api.mail.tm/accounts").then().extract().response().getBody().asString();

        JsonPath jsonPath = new JsonPath(responseBodyString);
        email.id = jsonPath.getString("id");
        email.address = jsonPath.getString("address");
        System.out.println("Generated Email "+email.address);
    }


    public static void createToken(){
        String requestBody = "{\n" +
                "  \"address\": \""+email.address+"\",\n" +
                "  \"password\": \"Krishna@123\"\n" +
                "}";

        String responseBodyString = given().contentType("application/json").body(requestBody).
                when().post("https://api.mail.tm/token").then().extract().response().getBody().asString();

        JsonPath jsonPath = new JsonPath(responseBodyString);

        email.token=jsonPath.getString("token");
        System.out.println("Generated Token "+email.token);
    }

    public static void readOtpAndDelete(){
        String responseBodyString = given().header("accept", "application/ld+json").header("Authorization", "Bearer "+email.token).
                when().get("https://api.mail.tm/messages?page=1").then().extract().response().getBody().asString();

        JsonPath jsonPath = new JsonPath(responseBodyString);


        String subject =jsonPath.getString("'hydra:member'[0].subject");

        String[] subArray = subject.split(" ");

        email.otp=subArray[2];
    }

}
