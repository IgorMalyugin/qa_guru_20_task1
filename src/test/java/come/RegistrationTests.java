package come;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends BaseTest {


    @Test
    void registrationTest() {


        registrationPage
                .openPages()
                .setFirstName("Артем")
                .setlastName("Куликов")
                .setuserEmail("art@mail.ru")
                .setgenter("Male")
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









//Проверка
//        $(("#example-modal-sizes-title-lg")).shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text("Артем Куликов"), text("art@mail.ru"));
//        $(".table-responsive").shouldHave(text("Male"));
//        $(".table-responsive").shouldHave(text("9032044455"));
//        $(".table-responsive").shouldHave(text("30 June,1900"));
//        $(".table-responsive").shouldHave(text("English"));
//        $(".table-responsive").shouldHave(text("Sports"));
//        $(".table-responsive").shouldHave(text("image.png"));
//        $(".table-responsive").shouldHave(text("Москва"));
//        $(".table-responsive").shouldHave(text("NCR Delhi"));


    }
}
