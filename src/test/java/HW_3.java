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
        String firstName = "M",
                lastName = "L",
                email = "H_W_3@gmail.com",
                gender = "Male",
                phoneNumber = "8005553535",
                dayOfBirth = "01",
                monthOfBirth = "January",
                yearOfBirth = "2000",
                subject = "History",
                hobby = "Sports",
                picture = "src/test/resources/pictures/HW3.png",
                address = "Current Address",
                state = "Uttar Pradesh",
                city = "Agra";

        registrationPage.openPage()
                .closeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setPicture(picture)
                .setCurrentAddress(address)
                .clickState()
                .setStateCity(state)
                .clickCity()
                .setCity(city)
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName +" "+ lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", dayOfBirth +" "+ monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", "HW3.png")
                .verifyResult("Address", address)
                .verifyResult("State and City", state +" "+ city);
    }
}