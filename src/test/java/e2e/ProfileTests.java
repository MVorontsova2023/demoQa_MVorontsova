package e2e;

import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.ProfilePage;

import java.util.ArrayList;
import java.util.List;

public class ProfileTests extends TestBase {
    ProfilePage profilePage;

    @Test
    public void checkSelectSearchBox() {
        profilePage = new ProfilePage(app.driver);
        profilePage.goToProfilePage();
        profilePage.goToLogin();
        profilePage.selectSearchBox("Git");
    }

    @Test
    public void checkSelectTableHead() {
        List<String> values = new ArrayList<>();
        values.add("Image");
        values.add("Title");
        values.add("Author");
        values.add("Publisher");
        values.add("Action");

        profilePage = new ProfilePage(app.driver);
        profilePage.goToProfilePage();
        profilePage.goToLogin();
        profilePage.selectTableHead(values);
    }

    @Test
    public void checkSelectTableTrGroupsDivs() {
        profilePage = new ProfilePage(app.driver);
        profilePage.goToProfilePage();
        profilePage.goToLogin();
        profilePage.selectTableTrGroupsDivs();
    }

    @Test
    public void checkSelectPaging() {
        profilePage = new ProfilePage(app.driver);
        profilePage.goToProfilePage();
        profilePage.goToLogin();
        profilePage.selectPaging();
    }

    @Test
    public void checkSelectLastButtons() {
        profilePage = new ProfilePage(app.driver);
        profilePage.goToProfilePage();
        profilePage.goToLogin();
        profilePage.selectLastButtons();
    }

}
