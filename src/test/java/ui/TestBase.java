package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setApp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }
}
