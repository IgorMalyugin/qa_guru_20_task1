package come;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static utils.RandomUtils.*;


public class RegistrationTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void registrationTest() {
        Faker faker = new Faker(new Locale("en"));
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
                city = getRandomCity(state);



        registrationPage
                .openPages()
                .closeBaner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setUploadPicture("src/test/resources/img/image.png")
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();
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


    }
}
