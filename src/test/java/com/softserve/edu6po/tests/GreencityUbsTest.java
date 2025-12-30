package com.softserve.edu6po.tests;

import com.softserve.edu6po.pages.HomeGreencityPage;
import com.softserve.edu6po.pages.HomeUbsPage;
import com.softserve.edu6po.pages.UnsuccessfulSigninPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GreencityUbsTest {
    private static final String BASE_URL = "https://www.greencity.cx.ua/#/ubs";
    private static final long IMPLICITLY_WAIT_SECONDS = 4L; //10L;
    private static final long ONE_SECOND_DELAY = 1000;
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
    public void tearThis() {
        presentationSleep(4); // For Presentation ONLY
        //
        System.out.println("\t@AfterEach executed");
        // TODO
        // Close Session
    }

    private HomeUbsPage loadUbsApplication() {
        driver.get(BASE_URL);
        presentationSleep(1);
        return new HomeUbsPage(driver);
    }

    @Test
    public void smokeTest() {
        HomeGreencityPage homeGreencityPage = loadUbsApplication()
                .switchToEnglishLanguage()
                .switchToUkrainianLanguage()
                .gotoHomeGreencityPage()
                .gotoEcoNewsPage()
                .gotoEventsPage()
                .gotoAboutusPage()
                .switchToEnglishLanguage()
                .switchToUkrainianLanguage()
                .gotoHomeGreencityPage()
                .switchToEnglishLanguage();
        Assertions.assertTrue(homeGreencityPage.isEnglishEnable());
    }

    private static Stream<Arguments> greencityValidUsers() {
        return Stream.of(
                Arguments.of("exqcndksfmcgtmtmdt@enotj.com", "Qwerty_1", "Qwerty1")
        );
    }

    @ParameterizedTest(name = "[{index}] email={0}, password={1}, username={2}")
    @MethodSource("greencityValidUsers")
    public void checkSuccessfulLoginParameters(String email, String password, String username) {
        HomeUbsPage homeUbsPage = loadUbsApplication()
                .gotoSigninPage()
                .loginUbs(email, password);
        Assertions.assertEquals(username, homeUbsPage.getUsernameLabelText());
        //
        homeUbsPage = homeUbsPage
                .gotoSignoutUbs()
                .switchToEnglishLanguage();
        Assertions.assertEquals("sign up", homeUbsPage.getSingnupText().toLowerCase());
    }

    private static Stream<Arguments> greencityInvalidUsers() {
        return Stream.of(
                Arguments.of("hahaha@enotj.com", "Qwerty_1", "Qwerty1")
        );
    }

    @ParameterizedTest(name = "[{index}] email={0}, password={1}, username={2}")
    @MethodSource("greencityInvalidUsers")
    public void checkUnsuccessfulLoginParameters(String email, String password, String username) {
        UnsuccessfulSigninPage unsuccessfulSigninPage = loadUbsApplication()
                .switchToEnglishLanguage()
                .gotoSigninPage()
                .invalidLogin(email, password);
        Assertions.assertEquals(UnsuccessfulSigninPage.BAD_EMAIL_PASSWORD,
                unsuccessfulSigninPage.getAlertErrorLabelText());
    }
}
