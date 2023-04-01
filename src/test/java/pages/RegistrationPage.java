package pages;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Keys;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage  {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            setFirstNameInput = $("#firstName"),
            setLastNameInput = $("#lastName"),
            setUserEmailInput = $("#userEmail"),
            setGenderInput = $("#genterWrapper"),
            setUserNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            setSubjectsInput = $("#subjectsInput"),
            setHobbiesInput = $("#hobbiesWrapper"),
            setPictureInput = $("#uploadPicture"),
            setCurrentAddressInput = $("#currentAddress"),
            clickStateInput = $("#state"),
            setStateCityInput = $("#stateCity-wrapper"),
            clickCityInput = $("#city"),
            setCityInput = $("#stateCity-wrapper"),
            clickSubmitInput = $("#submit");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage closeBanner(){
        executeJavaScript("$('footer').remove()"); // убираем баннер
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value){
        setFirstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value){
        setLastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setUserEmail(String value){
        setUserEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value){
        setGenderInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value){
        setUserNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);;
        return this;
    }
    public RegistrationPage setSubjects(String value){
        setSubjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value){
        setHobbiesInput.parent().$(byText(value)).click();
        return this;
    }
    public RegistrationPage setPicture(String value){
        setPictureInput.uploadFile(new File(value));
        return this;
    }
    public RegistrationPage setCurrentAddress(String value){
        setCurrentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage clickState(){
        clickStateInput.click();
        return this;
    }
    public RegistrationPage setStateCity(String value){
        setStateCityInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage clickCity(){
        clickCityInput.click();
        return this;
    }
    public RegistrationPage setCity(String value){
        setCityInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage clickSubmit(){
        clickSubmitInput.sendKeys(Keys.ENTER);
        return this;
    }
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}