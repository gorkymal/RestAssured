package ReqresIn;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ReqresTest {

    @Test
    public void checkAvatarIdtest() {
        Specifications.requestSpec();
        Specifications.responseSpec200();
        //Specifications.responseError400();

        List<UserData> list = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .extract().jsonPath().getList("data", UserData.class);

        list.stream()
                .filter(x -> x.getFirst_name().length() >= 7)
                .forEach(y -> Assert.assertTrue(y.getAvatar().endsWith(".jpg")));
    }

    @Test
    public void successRegister() {
        Specifications.requestSpec();
        Specifications.responseSpec200();

        //Expected results
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("https://reqres.in/api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);


        Assert.assertEquals(String.valueOf(id), successReg.getId());
        //Assert.assertEquals(token, successReg.getToken());
    }

    @Test
    public void getUsers() {
        Specifications.requestSpec();
        Specifications.responseSpec200();

        List<UserData> list = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .extract().jsonPath().getList("data", UserData.class);

        list.stream()
                .filter(x -> x.getFirst_name().length() <= 5)
                .forEach(y -> Assert.assertTrue(y.getEmail().endsWith("@reqres.in")));
    }

    @Test
    public void firstNameTest() {
        Specifications.requestSpec();
        Specifications.responseSpec200();

        UserData user = given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .extract().jsonPath().getObject("data", UserData.class);


        Assert.assertTrue(user.getFirst_name().equals("Janet") && user.getLast_name().equals("Weaver"));
    }

    @Test
    public void notFoundUser() {
        Specifications.requestSpec();

        Response user = given()
                .when()
                .get(Specifications.baseURI + "/api/users/23");

        Assert.assertTrue(user.statusCode() == 404);
    }

    @Test
    public void createUser() {
        Specifications.requestSpec();
        Specifications.responseSpec201();

        String userName = "Sasha";
        String userJob = "Kuku";

        Register newUser = new Register(userName, userJob);

        SuccessReg successReg = given()
                .when()
                .body(newUser)
                .post(Specifications.baseURI + "/api/users")
                .then()
                .extract().as(SuccessReg.class);

        Assert.assertTrue(successReg.getName().equals(userName));
        Assert.assertTrue(successReg.getJob().equals(userJob));

    }

    @Test
    public void authTest() {
        RestAssured.given()
                .when()

    }
}



