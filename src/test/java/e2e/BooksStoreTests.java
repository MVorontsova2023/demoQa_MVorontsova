package e2e;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.BookStorePage;
import ui.pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class BooksStoreTests extends TestBase {
    BookStorePage bookStorePage;

    @Test
    public void checkSelectSearchBox() {
        bookStorePage = new BookStorePage(app.driver);
        bookStorePage.goToBookStorePage();
        bookStorePage.selectSearchBox("Git");
    }

    @Test
    public void checkClickLoginButton() {
        bookStorePage = new BookStorePage(app.driver);
        bookStorePage.clickLoginButton();

        LoginPage loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        String url = app.driver.getCurrentUrl();
        Assert.assertEquals(url, "https://demoqa.com/login", "Error url for login page ");
    }

    @Test
    public void checkSelectTableHead() {
        List<String> values = new ArrayList<>();
        values.add("Image");
        values.add("Title");
        values.add("Author");
        values.add("Publisher");

        bookStorePage = new BookStorePage(app.driver);
        bookStorePage.goToBookStorePage();
        bookStorePage.selectTableHead(values);
    }

    @Test
    public void checkSelectTableTrGroupsDivs() {
        bookStorePage = new BookStorePage(app.driver);
        bookStorePage.goToBookStorePage();
        bookStorePage.selectTableTrGroupsDivs();
    }

    @Test
    public void checkSelectPaging() {
        bookStorePage = new BookStorePage(app.driver);
        bookStorePage.goToBookStorePage();
        bookStorePage.selectPaging();
    }
}
