package e2e;

import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.FramePages;
import ui.pages.SelectPage;

import java.util.ArrayList;
import java.util.List;

public class SelectAllTests extends TestBase {

    SelectPage selectPage;

    FramePages framePages;

    @Test
    public void checkSelectValue() throws InterruptedException {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.selectValueDropdown("Group 1, option 2");

    }

    @Test
    public void checkOldSelectMenu() {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.selectOldDropdown("Red");
    }

    @Test
    public void checkMultiSelectMenu() {
        List<String> values = new ArrayList<>();
        values.add("volvo");
        values.add("saab");
        values.add("audi");
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.standardMultiSelect(values);
    }

    @Test
    public void checkMultiSelectDropAndDown() {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
//        selectPage.cleanInput();
    }

    @Test
    public void checkMultiSelectDD() {

        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.multiSelectDD("Green");
        selectPage.multiSelectDD("Black");
        selectPage.cleanInput();
    }

    @Test
    public void checkSelectValueSecondInput() throws InterruptedException {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.selectOneDropdown("Prof.");

    }
}