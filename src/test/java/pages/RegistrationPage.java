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
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput");

    public void openPage(){
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()"); // убираем баннер
        executeJavaScript("$('#fixedban').remove()");
    }
     public void setFirstName(){
         $("#firstName").setValue("M");
     }
    public void setLastName(){
        $("#lastName").setValue("L");
    }
    public void setUserEmail(){
        $("#userEmail").setValue("H_W_3@gmail.com");
    }
    public void setGender(){
        $("#gender-radio-1").sendKeys(" ");
    }
    public void setUserNumber(){
        $("#userNumber").setValue("8005553535");
    }
    public void clickDateOfBirth(){
        $("#dateOfBirthInput").click();
    }
    public void setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);;
    }
    public void setSubjects(){
        $("#subjectsInput").setValue("History").pressEnter();
    }
    public void setHobbies(){
        $("#hobbies-checkbox-1").parent().$(byText("Sports")).click();
    }
    public void setPicture(){
        $("#uploadPicture").uploadFile(new File("src/test/resources/pictures/HW3.png"));
    }
    public void setCurrentAddress(){
        $("#currentAddress").setValue("Current Address");
    }
    public void clickState(){
        $("#state").click();
    }
    public void setStateCity(){
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
    }
    public void clickCity(){
        $("#city").click();
    }
    public void setCity(){
        $("#stateCity-wrapper").$(byText("Agra")).click();
    }
    public void clickSubmit(){
        $("#submit").sendKeys(Keys.ENTER);
    }
    public void checkExampleModal(){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
    public void checkStudentName(){
        $(".table-responsive").shouldHave(text("M L"));
    }
    public void checkStudentEmail(){
        $(".table-responsive").shouldHave(text("H_W_3@gmail.com"));
    }
    public void checkGender(){
        $(".table-responsive").shouldHave(text("Male"));
    }
    public void checkMobile(){
        $(".table-responsive").shouldHave(text("8005553535"));
    }
    public void checkDateOfBirth(){
        $(".table-responsive").shouldHave(text("01 January,2000"));
    }
    public void checkSubjects(){
        $(".table-responsive").shouldHave(text("History"));
    }
    public void checkHobbies(){
        $(".table-responsive").shouldHave(text("Sports"));
    }
    public void checkPicture(){
        $(".table-responsive").shouldHave(text("HW3.png"));
    }
    public void checkAddress(){
        $(".table-responsive").shouldHave(text("Current Address"));
    }
    public void checkStateAndCCity(){
        $(".table-responsive").shouldHave(text("Uttar Pradesh Agra"));
    }
    public void clickCloseLargeModal(){
        $("#closeLargeModal").click();
    }
}
