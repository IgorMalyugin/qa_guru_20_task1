package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            genter = $("#genterWrapper"),
            number = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjects = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            buttonSubmit = $("#submit"),
            tableResponsive = $(".table-responsive");


    public RegistrationPage openPages() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()"); // удаляем банер
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String values) {
        firstName.setValue(values);

        return this;
    }

    public RegistrationPage setlastName(String values) {
        lastName.setValue(values);

        return this;
    }

    public RegistrationPage setuserEmail(String values) {
        userEmail.setValue(values);

        return this;
    }

    public RegistrationPage setgenter(String value) {
        genter
                .$(byText(value))
                .click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        number.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year){
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String  value){
        subjects.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUploadPicture(String value){
        picture.uploadFile(new File(value));

        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        address.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value){
        state.click();
        state.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value){
        city.click();
        city.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submit(){
        buttonSubmit.click();

        return this;
    }

    public void check(String key, String value){
        tableResponsive.$(byText(key)).sibling(0).shouldHave(text(value));
//        tableResponsive.$(byText("Student Name")).sibling(0).shouldHave(text("Alex Egorov"));
    }



}
