
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;
import static javax.management.Query.value;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaHomeWork {

    @BeforeAll
    static void setupSelenideEnv() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue("Artyom");
        $("#lastName").setValue("Churkin");
        $("#currentAddress").setValue("Svobody 78");
        $("#userEmail").setValue("a.churkin@informer.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("8920117131");
        $("#dateOfBirthInput").scrollTo().click();
        $(".react-datepicker__month-select").selectOption("December");//только если объект имеет тэг select и тэг option
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day.react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("img/123.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Artyom Churkin"));
        $(".table-responsive").shouldHave(text("a.churkin@informer.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8920117131"));
        $(".table-responsive").shouldHave(text("03 December,1989"));
        $(".table-responsive").shouldHave(text("Physics"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("123.png"));
        $(".table-responsive").shouldHave(text("Svobody 78"));
        $(".table-responsive").shouldHave(text("Rajasthan Jaipur"));
        $("#closeLargeModal").click();

    }


    private WebElementCondition value(String s) {

        return null;
    }
}