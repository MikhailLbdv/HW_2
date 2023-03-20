import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HW_3 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()"); // убираем баннер
        executeJavaScript("$('#fixedban').remove()");


        // напоминалка id=#, class=.
        $("#firstName").setValue("M");
        $("#lastName").setValue("L");
        $("#userEmail").setValue("H_W_3@gmail.com");
// альтернатиынй         $("#genterWrapper").$(byText("Male")).click();
        $("#gender-radio-1").sendKeys(" ");
        $("#userNumber").setValue("8005553535");
// альтернатиынй        $("#dateOfBirthInput").setValue("");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("2000")).click();
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__month").$(byText("1")).click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbies-checkbox-1").parent().$(byText("Sports")).click();
        $("#hobbies-checkbox-2").parent().$(byText("Reading")).click();
        $("#hobbies-checkbox-3").parent().$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/pictures/HW3.png"));
// альтернатиынй       $("#uploadPicture").uploadFromClasspath("pictures/HW3.png");
        $("#currentAddress").setValue("Current Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").sendKeys(Keys.ENTER);     // ?? click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("M L"));
        $(".table-responsive").shouldHave(text("H_W_3@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8005553535"));
        $(".table-responsive").shouldHave(text("01 January,2000"));
        $(".table-responsive").shouldHave(text("History"));
        $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("HW3.png"));
        $(".table-responsive").shouldHave(text("Current Address"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();
    }
}