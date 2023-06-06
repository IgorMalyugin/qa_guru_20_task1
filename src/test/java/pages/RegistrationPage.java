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
            gender = $("#genterWrapper"),
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
        return this;
    }

    public RegistrationPage closeBaner(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String values) {
        firstName.setValue(values);

        return this;
    }

    public RegistrationPage setLastName(String values) {
        lastName.setValue(values);

        return this;
    }

    public RegistrationPage setUserEmail(String values) {
        userEmail.setValue(values);

        return this;
    }

    public RegistrationPage setGender(String value) {
        gender
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
    }



}
