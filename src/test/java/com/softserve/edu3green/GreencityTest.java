package com.softserve.edu3green;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GreencityTest {

    private static final String BASE_URL = "https://www.greencity.cx.ua/#/ubs";
    private static final long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final long ONE_SECOND_DELAY = 1000;
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
        //WebDriverManager.firefoxdriver().setup();
        //
        // https://peter.sh/experiments/chromium-command-line-switches/
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--headless");
        //driver = new ChromeDriver(options);
        //
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1295, 687));
        //
        System.out.println("@BeforeAll executed");
    }

    @AfterAll
    public void tear() {
        if (driver != null) {
            driver.quit(); // close()
        }
        System.out.println("@AfterAll executed");
    }

    @BeforeEach
    public void setupThis() {
        driver.get(BASE_URL);
        presentationSleep(2); // For Presentation ONLY
        //
        System.out.println("\t@BeforeEach executed");
    }

    @AfterEach
    public void tearThis() {
        presentationSleep(4); // For Presentation ONLY
        System.out.println("\t@AfterEach executed");
        // TODO
        // Close Session
    }

    @Test
    public void checkLoginHadrCode() {
        // Check Language
        WebElement language = driver.findElement(By.cssSelector("li.lang-option>span"));
        System.out.println("\t\t\tlanguage.getText() = " + language.getText());
        if (language.getText().toLowerCase().contains("u")) {
            language.click();
            driver.findElement(By.cssSelector("li.lang-option.ng-star-inserted>span")).click();
        }
        presentationSleep(); // For Presentation ONLY
        // Open Login form
        driver.findElement(By.cssSelector("img.ubs-header-sing-in-img.ng-star-inserted")).click();
        presentationSleep(); // For Presentation ONLY
        // Type email
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("exqcndksfmcgtmtmdt@enotj.com");
        presentationSleep(); // For Presentation ONLY
        // Type Password
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Qwerty_1");
        presentationSleep(); // For Presentation ONLY
        // Click login button
        driver.findElement(By.cssSelector("button.ubsStyle")).click();
        presentationSleep(2); // For Presentation ONLY
        // Get userName
        WebElement userName = driver.findElement(By.cssSelector("li.body-2.ubs-user-name"));
        Assertions.assertEquals("Qwerty1", userName.getText());
        presentationSleep(2); // For Presentation ONLY
        // logout
        userName.click();
        presentationSleep(2); // For Presentation ONLY
        //
        driver.findElement(By.cssSelector("li[aria-label='sign-out']>a")).click();
        presentationSleep(2); // For Presentation ONLY
        // Check sign up button
        WebElement signup = driver.findElement(By.cssSelector("div.ubs-header_sign-up-btn>span"));
        Assertions.assertTrue(signup.getText().toLowerCase().trim().contains("sign up"));
        presentationSleep(); // For Presentation ONLY
    }
}
