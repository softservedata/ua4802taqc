package com.softserve.edu6po.tests;

import com.softserve.edu6po.pages.HomeUbsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

class RunnerExtension implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Boolean testResult = context.getExecutionException().isPresent();
        System.out.println("\t\t\t\tException.isPresent() = " + testResult); //false - SUCCESS, true - FAILED
        System.out.println("\t\t\t\tTest context.getDisplayName(): "+ context.getDisplayName());
        //
        UbsTestRunner.isTestSuccessful = !testResult;
    }
}

@ExtendWith(RunnerExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class UbsTestRunner {
    //
    protected static Boolean isTestSuccessful = false;
    private final String LOCALSTORAGE_REMOVE = "window.localStorage.removeItem('%s');";
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";

    private static final String BASE_URL = "https://www.greencity.cx.ua/#/ubs";
    private static final long IMPLICITLY_WAIT_SECONDS = 4L; //10L;
    private static final long ONE_SECOND_DELAY = 1000;
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebDriver driver;

    public static void presentationSleep() {
        presentationSleep(1);
    }

    public static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void takeScreenShot() {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./" + currentTime + "_screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void takePageSource() {
        //String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        //
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_TEMPLATE);
        String currentTime = localDate.format(formatter);
        //
        String pageSource = driver.getPageSource();
        byte[] strToBytes = pageSource.getBytes();
        Path path = Paths.get("./" + currentTime + "_" + "_source.html.txt");
        try {
            Files.write(path, strToBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
        //
        System.out.println("@BeforeAll executed");
    }

    @AfterAll
    public void tear() {
        if (driver != null) {
            driver.quit(); // close()
        }
        //
        System.out.println("@AfterAll executed");
    }

    @BeforeEach
    public void setupThis() {
        //driver.get(BASE_URL);
        //presentationSleep(); // For Presentation ONLY
        //
        System.out.println("\t@BeforeEach executed");
    }

    @AfterEach
    public void tearThis(TestInfo testInfo) {
        presentationSleep(4); // For Presentation ONLY
        //
        if (!isTestSuccessful) {
            logger.error("Test_Display_Name = " + testInfo.getDisplayName() + " failed");
            logger.error("Test_Name = " + testInfo.getTestMethod() + " failed");
            //
            System.out.println("\t\t\tgetTestMethod = " + testInfo.getTestMethod());
            System.out.println("\t\t\tgetDisplayName = " + testInfo.getDisplayName());
            takeScreenShot();
            takePageSource();
        }
        //
        System.out.println("\t@AfterEach executed");
        // TODO
        // Close Session
        driver.manage().deleteAllCookies();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(String.format(LOCALSTORAGE_REMOVE, "accessToken"));
        javascriptExecutor.executeScript(String.format(LOCALSTORAGE_REMOVE, "refreshToken"));
        // Delete VIEWSTATE, URL
    }

    protected HomeUbsPage loadUbsApplication() {
        driver.get(BASE_URL);
        presentationSleep(1);
        return new HomeUbsPage(driver);
    }
}
