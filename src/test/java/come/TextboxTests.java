package come;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextboxTests {


    @BeforeAll
    static void beforeTest() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void succssesTest() {
        open("/automation-practice-form");


        $("#firstName").setValue("Артем");
        $("#lastName").setValue("Куликов");
        $("#userEmail").setValue("art@mail.ru");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("9032044455");

        $("#dateOfBirthInput").click();
        $("[class*='month-select']").selectOptionByValue("6");
        $("[class*='year-select']").selectOptionByValue("2002");
        $("[class*='day--014']").click();

        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/image.png"));

        $("#currentAddress").setValue("Москва");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("noida").pressEnter();


        $("#submit").click();


        $(byText("Thanks for submitting the form")).shouldHave(Condition.visible);
        $(".table-responsive").shouldHave(text("Артем Куликов"));
        $(".table-responsive").shouldHave(text("art@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9032044455"));
        $(".table-responsive").shouldHave(text("14 July,2002"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("image.png"));
        $(".table-responsive").shouldHave(text("Москва"));
        $(".table-responsive").shouldHave(text("NCR noida"));

    }
}
