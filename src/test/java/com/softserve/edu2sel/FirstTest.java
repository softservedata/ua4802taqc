package com.softserve.edu2sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTest {
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private WebDriver driver;

    @BeforeAll
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        driver.manage().window().maximize();
    }

    @AfterAll
    public void tear() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkMac() throws InterruptedException {
        driver.get("https://www.bing.com/");
        Thread.sleep(1000); // For Presentation
        //
        driver.findElement(By.name("q")).sendKeys("mac");
        Thread.sleep(1000); // For Presentation
        //
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(1000); // For Presentation
        //
        driver.findElement(By.xpath("//a[text()='Mac - Apple']")).click();
        Thread.sleep(1000); // For Presentation
        //
        // switch to another window
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(1000); // For Presentation
        //
        String apple = driver.getCurrentUrl();
        Thread.sleep(1000); // For Presentation
        //
        Assertions.assertEquals("https://www.apple.com/mac/", apple);
    }

}
