package e2e;

import api.RegistrationApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.LoginPage;
import ui.pages.ProfilePage;

public class RegistrationsNewUserTest extends TestBase {
    RegistrationApi registrationApi;
    LoginPage loginPage;
    Response response;
    ProfilePage profilePage;


    @Test
    public void registerNewUserAndLoginViaUITest() {
        String password = "yA*UeeuA2pU3";
        registrationApi = new RegistrationApi();
        response = registrationApi.registerUser(201, password);
        String userName = response.jsonPath().getString("username");
//        String password = registrationApi.randomDataBodyForRegisterUser().getPassword();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillLoginForm(userName, password);
        loginPage.clickLoginButton();

        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoading();
        profilePage.checkUserName(userName);


    }

    @Test
    public void newUserNotRegisterViaApiAndLoginViaUITest() {
        String invalidPassword = "123123";
        registrationApi = new RegistrationApi();
        response = registrationApi.registerUser(400, invalidPassword);
        String errMessage = response.jsonPath().getString("message");
        String userName = registrationApi.randomDataBodyForRegisterUser(invalidPassword).getUserName();
        String expectedErrorMessage = "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.";
        Assert.assertEquals(errMessage, expectedErrorMessage, "Error message is not correct");

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillLoginForm(userName, invalidPassword);
        loginPage.clickLoginButton();
        loginPage.waitForLoading();
    }

}
