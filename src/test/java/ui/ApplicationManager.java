package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    public WebDriver driver;

    protected void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
    }

    protected void stop() {
        driver.quit();
    }
}
