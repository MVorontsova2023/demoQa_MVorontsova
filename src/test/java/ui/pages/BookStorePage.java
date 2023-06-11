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

public class BookStorePage extends PageBase {
    Wait wait;

    public BookStorePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(css = "[class='rt-table']")
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

    public void goToBookStorePage() {
        driver.get("https://demoqa.com/books");
    }

    public void selectSearchBox(String inputValue) {
        click(searchBox);
        searchBox.sendKeys(inputValue);
        pressKey(searchBox, Keys.ENTER);
    }

    public void clickLoginButton() {
        click(loginButton);
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
        for (int i = 0; i < tableTrGroupsDivs.size(); i++) {
            WebElement el = tableTrGroupsDivs.get(i);
            List<WebElement> cells = el.findElements(By.className("rt-td"));

            WebElement elImg = cells.get(0);
            WebElement img = elImg.findElement(By.xpath("//img[@alt='image']"));

            WebElement elLink = cells.get(1);
            WebElement link = elLink.findElement(By.xpath("//a[contains(@href,'books')]"));

            Assert.assertNotNull(img, "Img is absent");
            Assert.assertNotNull(link, "Link is absent");
        }
    }

    public void selectPaging() {
        int pageCount = Integer.parseInt(totalPagesSpan.getText());
        WebElement elCurrentPageNumber = pageJumpDiv.findElement(By.xpath("//input[@type='number']"));
        int currentPageNumber = Integer.parseInt(elCurrentPageNumber.getAttribute("value"));
        Boolean isLessOrEqual = (currentPageNumber <= pageCount);
        Assert.assertTrue(isLessOrEqual, "currentPageNumber is not less or equal to pageCount");
    }

}
