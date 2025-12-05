
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class demoqaHomeWork {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        $("#firstName").setValue("Artyom");
        $("#lastName").setValue("Churkin");
        $("#userEmail").setValue("a.churkin@informer.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("89201171319");
        $("#dateOfBirthInput").scrollTo().click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day.react-datepicker__day--003").click();
        $("#dateOfBirthInput").shouldHave(value("03 Dec 1988"));

        //$("#subjectsInput").scrollTo().setValue("Physics").pressEnter();
        //$(".subjects-auto-complete__multi-value__label")
                //.shouldHave(text("Physics"));
        $(".subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi").click();
        $(".subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi").setValue("Ph").pressEnter();

        $("label[for='hobbies-checkbox-3']").click();





        sleep(5000L);



    }
}