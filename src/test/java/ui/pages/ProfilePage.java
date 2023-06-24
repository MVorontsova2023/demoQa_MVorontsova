package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ui.wait.Wait;

import java.util.List;

public class ProfilePage extends PageBase {
    Wait wait;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[contains(@href,'/login')]")
    WebElement loginLink;

    @FindBy(xpath = "//input[@placeholder='UserName']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "searchBox")
    WebElement searchBox;

    @FindBy(id = "userName-value")
    WebElement username;

    @FindBy(xpath = "//button[text()='Log out']")
    WebElement logoutButton;

    @FindBy(xpath = "//div[@class='rt-table']")
    WebElement tableBooks;

    @FindBy(css = "[class='rt-tr']")
    WebElement tableHead;

    @FindAll({@FindBy(css = "[class='rt-resizable-header-content']")})
    List<WebElement> headerContentsDivs;

    @FindBy(css = "[class='rt-tbody']")
    WebElement tableBodyDiv;

    @FindAll({@FindBy(css = "[class='rt-tr-group']")})
    List<WebElement> tableTrGroupsDivs;

    @FindBy(css = "[class='-pageJump']")
    WebElement pageJumpDiv;

    @FindBy(css = "[class='-totalPages']")
    WebElement totalPagesSpan;

    @FindBy(xpath = "//button[text()='Previous']")
    WebElement previousButton;

    @FindBy(xpath = "//button[text()='Next']")
    WebElement nextButton;

    @FindBy(xpath = "//button[text()='Go To Book Store']")
    WebElement goToBookStoreButton;

    @FindBy(xpath = "//button[text()='Delete Account']")
    WebElement deleteButton;

    @FindAll({@FindBy(xpath = "//button[text()='Delete All Books']")})
    List<WebElement> deleteAllButton;

    public void goToProfilePage() {
        driver.get("https://demoqa.com/profile");
    }

    public void goToLogin() {

        try {
            click(loginLink);

            // fillField(usernameField, "mvorontsova");
            // fillField(passwordField, "Pn!jE37Na$Ft*uX");
            // click(loginButton);
            // wait = new Wait(driver);
            // wait.forVisibility(searchBox);
        } catch (Exception e) {
            //  Block of code to handle errors
        }
    }

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(username);

    }

    public void checkUserName(String expectedUserName) {
        checkItemText(username, expectedUserName, "Username is not correct");
    }

    public void selectSearchBox(String inputValue) {
        click(searchBox);
        searchBox.sendKeys(inputValue);
        pressKey(searchBox, Keys.ENTER);

    }

    public void selectTableHead(List<String> values) { // List<String> values
        click(tableHead);
        List<WebElement> elements = driver.findElements(By.className("rt-resizable-header-content"));
        for (int i = 0; i < values.size(); i++) {
            WebElement el = elements.get(i);
            String ss = el.getText();
            String sValue = values.get(i);
            Assert.assertEquals(ss, sValue, "Error in Table Head ");
        }
    }

    public void selectTableTrGroupsDivs() {
        click(tableBodyDiv);
        for (int i = 0; i < 2; i++) { //tableTrGroupsDivs.size()
            WebElement el = tableTrGroupsDivs.get(i);
            List<WebElement> cells = el.findElements(By.className("rt-td"));

            WebElement elImg = cells.get(0);
            WebElement img = elImg.findElement(By.xpath("//img[@alt='image']"));

            WebElement elLink = cells.get(1);
            WebElement link = elLink.findElement(By.xpath("//a[contains(@href,'profile?book')]"));

            WebElement elDelete = cells.get(4);
            WebElement delete = elDelete.findElement(By.xpath("//span[@title='Delete']"));

            Assert.assertNotNull(img, "Img is absent");
            Assert.assertNotNull(link, "Link is absent");
            Assert.assertNotNull(delete, "Link is absent");
        }
    }

    public void selectPaging() {
        int pageCount = Integer.parseInt(totalPagesSpan.getText());
        WebElement elCurrentPageNumber = pageJumpDiv.findElement(By.xpath("//input[@type='number']"));
        int currentPageNumber = Integer.parseInt(elCurrentPageNumber.getAttribute("value"));
        Boolean isLessOrEqual = (currentPageNumber <= pageCount);
        Assert.assertTrue(isLessOrEqual, "currentPageNumber is not less or equal to pageCount");
        Assert.assertNotNull(previousButton, "PreviousButton is absent");
        Assert.assertNotNull(nextButton, "NextButton is absent");
        Assert.assertNotNull(deleteAllButton, "DeleteButton is absent");

    }

    public void selectLastButton() {
        Assert.assertNotNull(goToBookStoreButton, "PreviousButton is absent");
        Assert.assertNotNull(deleteButton, "NextButton is absent");
        WebElement el = deleteAllButton.get(0);
        Assert.assertNotNull(el, "DeleteButton is absent");
    }
}
