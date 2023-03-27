package pages;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Keys;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage  {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private SelenideElement
            setFirstNameInput = $("#firstName"),
            setLastNameInput = $("#lastName"),
            setUserEmailInput = $("#userEmail"),
            dateOfBirthInput = $("#dateOfBirthInput");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage closeBanner(){
        executeJavaScript("$('footer').remove()"); // убираем баннер
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
     public RegistrationPage setFirstName(){
         setFirstNameInput.setValue("M");
         return this;
     }
    public RegistrationPage setLastName(){
        setLastNameInput.setValue("L");
        return this;
    }
    public RegistrationPage setUserEmail(){
        setUserEmailInput.setValue("H_W_3@gmail.com");
        return this;
    }
    public RegistrationPage setGender(){
        $("#gender-radio-1").sendKeys(" ");
        return this;
    }
    public RegistrationPage setUserNumber(){
        $("#userNumber").setValue("8005553535");
        return this;
    }
    public RegistrationPage clickDateOfBirth(){
        $("#dateOfBirthInput").click();
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);;
        return this;
    }
    public RegistrationPage setSubjects(){
        $("#subjectsInput").setValue("History").pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(){
        $("#hobbies-checkbox-1").parent().$(byText("Sports")).click();
        return this;
    }
    public RegistrationPage setPicture(){
        $("#uploadPicture").uploadFile(new File("src/test/resources/pictures/HW3.png"));
        return this;
    }
    public RegistrationPage setCurrentAddress(){
        $("#currentAddress").setValue("Current Address");
        return this;
    }
    public RegistrationPage clickState(){
        $("#state").click();
        return this;
    }
    public RegistrationPage setStateCity(){
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        return this;
    }
    public RegistrationPage clickCity(){
        $("#city").click();
        return this;
    }
    public RegistrationPage setCity(){
        $("#stateCity-wrapper").$(byText("Agra")).click();
        return this;
    }
    public RegistrationPage clickSubmit(){
        $("#submit").sendKeys(Keys.ENTER);
        return this;
    }
    public RegistrationPage checkExampleModal(){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }
    public RegistrationPage checkStudentName(){
        $(".table-responsive").shouldHave(text("M L"));
        return this;
    }
    public RegistrationPage checkStudentEmail(){
        $(".table-responsive").shouldHave(text("H_W_3@gmail.com"));
        return this;
    }
    public RegistrationPage checkGender(){
        $(".table-responsive").shouldHave(text("Male"));
        return this;
    }
    public RegistrationPage checkMobile(){
        $(".table-responsive").shouldHave(text("8005553535"));
        return this;
    }
    public RegistrationPage checkDateOfBirth(){
        $(".table-responsive").shouldHave(text("01 January,2000"));
        return this;
    }
    public RegistrationPage checkSubjects(){
        $(".table-responsive").shouldHave(text("History"));
        return this;
    }
    public RegistrationPage checkHobbies(){
        $(".table-responsive").shouldHave(text("Sports"));
        return this;
    }
    public RegistrationPage checkPicture(){
        $(".table-responsive").shouldHave(text("HW3.png"));
        return this;
    }
    public RegistrationPage checkAddress(){
        $(".table-responsive").shouldHave(text("Current Address"));
        return this;
    }
    public RegistrationPage checkStateAndCCity(){
        $(".table-responsive").shouldHave(text("Uttar Pradesh Agra"));
        return this;
    }
    public RegistrationPage clickCloseLargeModal(){
        $("#closeLargeModal").click();
        return this;
    }
}
