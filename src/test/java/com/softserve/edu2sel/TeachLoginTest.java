package com.softserve.edu2sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TeachLoginTest {

    private final Long ONE_SECOND_DELAY = 1000L;
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private WebDriver driver;

    private void presentationSleep() {
        presentationSleep(1);
    }

    private void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeAll
    public void setup() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        //
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
        //
        System.out.println("@BeforeAll executed");
    }

    @AfterAll
    public void tear() {
        if (driver != null) {
            driver.quit(); // close tab and quit server
            //driver.close(); // close tab
        }
        //
        System.out.println("@AfterAll executed");
    }

    @BeforeEach
    public void setupThis() throws InterruptedException {
        //driver.get("http://speak-ukrainian.eastus2.cloudapp.azure.com/dev/");
        driver.get("https://demo.opencart.ua/");
        Thread.sleep(2000); // For Presentation
        //
        System.out.println("\t@BeforeEach executed");
    }

    @AfterEach
    public void tearThis() throws InterruptedException {
        Thread.sleep(8000); // For Presentation
        //
        System.out.println("\t@AfterEach executed");
    }


    @Test
    public void checkRefresh() throws Exception {
        //
        System.out.println("1. isVisible Login Link = "
                + driver.findElement(By.cssSelector("div#top-links a[href*='route=account/login']")).isDisplayed()); // false
        presentationSleep(); // For Presentation ONLY
        //
        driver.findElement(By.cssSelector("nav#top a[href*='route=account/account']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        System.out.println("2. isVisible Login Link = "
                + driver.findElement(By.cssSelector("div#top-links a[href*='route=account/login']")).isDisplayed()); // true
        presentationSleep(); // For Presentation ONLY
        //
        driver.findElement(By.cssSelector("div#top-links a[href*='route=account/login']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // /*-
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("hahaha");
        //
        String content = driver.findElement(By.id("input-email")).getAttribute("value");
        System.out.println("***content email = " + content);
        presentationSleep(2); // For Presentation ONLY
        //
        // Refresh some webelements
        driver.navigate().refresh();
        presentationSleep(); // For Presentation ONLY
        //
        driver.findElement(By.id("input-email")).sendKeys("bebebe");
        presentationSleep(); // For Presentation ONLY
        // */
        /*-
        WebElement email = driver.findElement(By.id("input-email"));
        //
        email.click();
        email.clear();
        email.sendKeys("hahaha");
        String content = email.getAttribute("value");
        System.out.println("content email = " + content);
        presentationSleep(); // For Presentation ONLY
        //
        // Refresh some webelements
        driver.navigate().refresh();
        presentationSleep(); // For Presentation ONLY
        email.sendKeys("bebebe"); // Runtime Error
        presentationSleep(); // For Presentation ONLY
        */
        //
        // driver.findElement(By.id("input-email")).sendKeys("password");
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("password");
        content = driver.findElement(By.id("input-password")).getAttribute("value");
        System.out.println("content password = " + content);
        presentationSleep(2); // For Presentation ONLY
        //
    }
}  