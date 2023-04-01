import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import com.github.javafaker.Faker;
import java.util.concurrent.ThreadLocalRandom;

import static utils.RandomUtils.getRandomInt;

public class HW_3_Faker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();



    @Test
    void fillFormTest() {
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = faker.options().option("Female", "Male", "Other"),
                phoneNumber = 8 + faker.phoneNumber().subscriberNumber(9),
                dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
                monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June",
                        "July", "August", "September", "October", "November", "December"),
                yearOfBirth = String.valueOf(getRandomInt(1960, 2000)),
                subject = faker.options().option("Maths", "Arts", "Economics", "Physics", "English", "History", "Social Studies", "Accounting", "Civics"),
                hobby = faker.options().option("Sports", "Reading", "Music"),
                picture = "src/test/resources/pictures/HW3.png",
                address = faker.address().streetAddress(),
                state = "Uttar Pradesh",
                city = faker.options().option("Agra", "Lucknow", "Merrut");

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