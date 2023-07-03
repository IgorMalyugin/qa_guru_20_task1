package come;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


import static io.qameta.allure.Allure.step;
import static utils.RandomUtils.*;


public class RegistrationTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Tag("simple")
    @Owner("Малюгин И А")
    @DisplayName("Автотест на регистрацию")
    @Test
    void registrationTest() {
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                currentAddress = faker.address().fullAddress(),
                gender = getRandomGender(),
                userNumber = faker.phoneNumber().subscriberNumber(10),
                day = String.format("%02d", faker.number().numberBetween(1, 28)),
                month = getRandomMonth(),
                year = String.valueOf(getRandomInt(1900, 2100)),
                subjects = getRandomSubject(),
                hobbies = getRandomHobbies(),
                state = getRandomState(),
                city = getRandomCity(state),
                file = "src/test/resources/img/image.png";

        step("Fill form", () -> {
            registrationPage
                    .openPages()
                    .closeBanner()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setBirthDay(day, month, year)
                    .setSubjects(subjects)
                    .setHobbies(hobbies)
                    .setUploadPicture(file)
                    .setCurrentAddress(currentAddress)
                    .setState(state)
                    .setCity(city)
                    .submit();
        });

        step("Check form", () -> {
            registrationPage.check("Student Name", firstName + " " + lastName);
            registrationPage.check("Student Email", userEmail);
            registrationPage.check("Gender", gender);
            registrationPage.check("Mobile", userNumber);
            registrationPage.check("Date of Birth", day + " " + month + "," + year);
            registrationPage.check("Subjects", subjects);
            registrationPage.check("Hobbies", hobbies);
            registrationPage.check("Picture", "image.png");
            registrationPage.check("Address", currentAddress);
            registrationPage.check("State and City", state + " " + city);
        });


    }
}
