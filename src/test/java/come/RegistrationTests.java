package come;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void registrationTest() {


        registrationPage
                .openPages()
                .closeBaner()
                .setFirstName("Артем")
                .setLastName("Куликов")
                .setUserEmail("art@mail.ru")
                .setGender("Male")
                .setUserNumber("9032044455").setBirthDay("30", "June", "1900")
                .setSubjects("English")
                .setHobbies("Sports")
                .setUploadPicture("src/test/resources/img/image.png")
                .setCurrentAddress("Москва")
                .setState("NCR")
                .setCity("Delhi")
                .submit();
        registrationPage.check("Student Name", "Артем Куликов");
        registrationPage.check("Student Email", "art@mail.ru");
        registrationPage.check("Gender", "Male");
        registrationPage.check("Mobile", "9032044455");
        registrationPage.check("Date of Birth", "30 June,1900");
        registrationPage.check("Subjects", "English");
        registrationPage.check("Hobbies", "Sports");
        registrationPage.check("Picture", "image.png");
        registrationPage.check("Address", "Москва");
        registrationPage.check("State and City", "NCR Delhi");


    }
}
