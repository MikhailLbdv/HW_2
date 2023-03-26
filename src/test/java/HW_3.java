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

    @Test
    void fillFormTest() {

        new RegistrationPage().openPage();
//        .setBirthDate("30", "July", "2008");

        new RegistrationPage().setFirstName();
        new RegistrationPage().setLastName();
        new RegistrationPage().setUserEmail();
        new RegistrationPage().setGender();
        new RegistrationPage().setUserNumber();
        new RegistrationPage().clickDateOfBirth();
        new RegistrationPage().setBirthDate("01", "January", "2000");
        new RegistrationPage().setSubjects();
        new RegistrationPage().setHobbies();
        new RegistrationPage().setPicture();
        new RegistrationPage().setCurrentAddress();
        new RegistrationPage().clickState();
        new RegistrationPage().setStateCity();
        new RegistrationPage().clickCity();
        new RegistrationPage().setCity();
        new RegistrationPage().clickSubmit();

        new RegistrationPage().checkExampleModal();
        new RegistrationPage().checkStudentName();
        new RegistrationPage().checkStudentEmail();
        new RegistrationPage().checkGender();
        new RegistrationPage().checkMobile();
        new RegistrationPage().checkDateOfBirth();
        new RegistrationPage().checkSubjects();
        new RegistrationPage().checkHobbies();
        new RegistrationPage().checkPicture();
        new RegistrationPage().checkAddress();
        new RegistrationPage().checkStateAndCCity();
        new RegistrationPage().clickCloseLargeModal();
    }
}