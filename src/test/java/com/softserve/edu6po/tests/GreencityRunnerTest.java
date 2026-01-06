package com.softserve.edu6po.tests;

import com.softserve.edu6po.data.Languages;
import com.softserve.edu6po.data.User;
import com.softserve.edu6po.data.UserRepository;
import com.softserve.edu6po.pages.HomeGreencityPage;
import com.softserve.edu6po.pages.HomeUbsPage;
import com.softserve.edu6po.pages.UnsuccessfulSigninPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GreencityRunnerTest extends UbsTestRunner {

    @Test
    public void smokeTest() {
        logger.info("Start smokeTest()");
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

    /*
    private static Stream<Arguments> greencityValidUsers() {
        return Stream.of(
                Arguments.of(new User("exqcndksfmcgtmtmdt@enotj.com", "Qwerty_1", "Qwerty1"))
        );
    }
    */

    private static Stream<Arguments> greencityValidUsers() {
        return Stream.of(
                Arguments.of(UserRepository.getDefault(), Languages.UA)
        );
    }

    @ParameterizedTest(name = "[{index}] email={0}, password={1}, username={2}")
    @MethodSource("greencityValidUsers")
    //public void checkSuccessfulLoginParameters(String email, String password, String username) {
    public void checkSuccessfulLoginParameters(User validUser, Languages languages) {
        logger.info("Start checkSuccessfulLoginParameters( " + validUser + ", " + languages + " )");
        HomeUbsPage homeUbsPage = loadUbsApplication()
                .gotoSigninPage()
                .loginUbs(validUser);
        Assertions.assertEquals(validUser.getUsername(), homeUbsPage.getUsernameLabelText());
        //
        homeUbsPage = homeUbsPage
                .gotoSignoutUbs()
                .switchLanguage(languages);
        Assertions.assertEquals(languages.getSignupText(), homeUbsPage.getSingnupText().toLowerCase());
    }

    /*
    private static Stream<Arguments> greencityInvalidUsers() {
        return Stream.of(
                Arguments.of(new User("hahaha@enotj.com", "Qwerty_1", "Qwerty1"))
        );
    }
    */

    private static Stream<Arguments> greencityInvalidUsers() {
        return Stream.of(
                Arguments.of(UserRepository.getInvalid())
        );
    }

    @ParameterizedTest(name = "[{index}] email={0}, password={1}, username={2}")
    @MethodSource("greencityInvalidUsers")
    //public void checkUnsuccessfulLoginParameters(String email, String password, String username) {
    public void checkUnsuccessfulLoginParameters(User invalidUser) {
        logger.info("Start checkUnsuccessfulLoginParameters( " + invalidUser + " )");
        UnsuccessfulSigninPage unsuccessfulSigninPage = loadUbsApplication()
                .switchToEnglishLanguage()
                .gotoSigninPage()
                .invalidLogin(invalidUser);
        Assertions.assertEquals(UnsuccessfulSigninPage.BAD_EMAIL_PASSWORD,
                unsuccessfulSigninPage.getAlertErrorLabelText());
    }
}
