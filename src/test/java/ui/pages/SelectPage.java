package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ui.wait.Wait;

import java.util.List;

public class SelectPage extends PageBase {
    Wait wait;

    public SelectPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "withOptGroup")
    WebElement selectValueDropdown;

    @FindBy(id = "react-select-2-input")
    WebElement selectOptionInput;

    @FindBy(id = "selectOne")
    WebElement selectOneDropdown;

    @FindBy(id = "react-select-3-input")
    WebElement selectTitleInput;

    @FindBy(id = "oldSelectMenu")
    WebElement selectOldDropdown;

    @FindBy(id = "cars")
    WebElement standardMultiSelect;

    @FindBy(css = "(//[class=' css-2b097c-container'])[3]")
    WebElement multiSelectDropDown;

    @FindBy(id = "react-select-4-input")
    WebElement multiSelectDropDownInput;

    @FindBy(css = "[class=' css-yk16xz-control']")
    WebElement thirdInput;

    @FindBy(xpath = "//*[text()='Select...']")
    WebElement selectdotdotdotDD;

    @FindAll({@FindBy(css = "[class=' css-2b097c-container']")})
    List<WebElement> colorDDCheckBox;

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]")
    WebElement select3dotDD;


    public void goToSelectPage() {
        driver.get("https://demoqa.com/select-menu");
    }

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(selectValueDropdown);
        wait.forVisibility(selectOptionInput);
        wait.forVisibility(selectOneDropdown);
        wait.forVisibility(selectOldDropdown);
    }

    public void selectValueDropdown(String inputValue) {
        click(selectValueDropdown);
//        selectValueDropdown.sendKeys(inputValue);
//        pressKey(selectOptionInput, Keys.ENTER);
    }

    public void selectOneDropdown(String inputValue) {
        click(selectOneDropdown);
        selectTitleInput.sendKeys(inputValue);
        pressKey(selectTitleInput, Keys.ENTER);
    }

    public void selectOldDropdown(String text) {
        Select select = new Select(selectOldDropdown);
        select.selectByVisibleText(text);
    }

    public void standardMultiSelect(List<String> values) {
        Select select = new Select(standardMultiSelect);
        for (String value : values) {
            select.selectByValue(value);
        }
    }

    public void multiSelectDD(String inputValue) {
        click(select3dotDD);
        driver.findElement(By.id("react-select-4-input")).sendKeys(inputValue);
        pressKey(multiSelectDropDownInput, Keys.ENTER);

    }

    public void cleanInput() {
        driver.findElement(By.xpath("(//*[@class='css-19bqh2r'])[3]")).click();
    }
}