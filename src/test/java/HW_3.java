import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HW_3 extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .closeBanner()
                .setFirstName()
                .setLastName()
                .setUserEmail()
                .setGender()
                .setUserNumber()
                .clickDateOfBirth()
                .setBirthDate("01", "January", "2000")
                .setSubjects()
                .setHobbies()
                .setPicture()
                .setCurrentAddress()
                .clickState()
                .setStateCity()
                .clickCity()
                .setCity()
                .clickSubmit();

        registrationPage.checkExampleModal()
                .checkStudentName()
                .checkStudentEmail()
                .checkGender()
                .checkMobile()
                .checkDateOfBirth()
                .checkSubjects()
                .checkHobbies()
                .checkPicture()
                .checkAddress()
                .checkStateAndCCity()
                .clickCloseLargeModal();
    }
}