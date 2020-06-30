import com.codeborne.selenide.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class FilteringNewEntriesTest {

    private static String generatedName = "Test" + Math.random()*100000;

    @BeforeSuite
    public void setUpDriver(){

        Configuration.fastSetValue = true;
        Configuration.browser = "chrome";
        System.setProperty("selenide.browser", "chrome");
        open("https://demo.realworld.io/#/");
        TestingTools.waitFullLoading();

    }

    @BeforeTest
    public void createNewArticle(){

        open("https://demo.realworld.io/#/login");
        $("[type=\"email\"]").setValue("hikaritest@gmail.com");
        $("[type=\"password\"]").setValue("testtest").pressEnter();


        $("[ui-sref=\"app.editor\"]").click();
        $("[placeholder=\"Article Title\"]").setValue(generatedName);
        $("[placeholder=\"What's this article about?\"]").setValue(""+Math.random()*100000);
        $("[placeholder=\"Write your article (in markdown)\"]").setValue(""+Math.random()*100000);
        $("[placeholder=\"Enter tags\"]").setValue("tags");
        $(Selectors.withText("Publish Article")).click();

    }

    @Test(description = "Last article with appropriate tag should be shown by filter")
    public void checkNewArticle(){

        open("https://demo.realworld.io/#/");

        $(Selectors.withText("tags")).click();
        $(".article-preview h1").shouldHave(Condition.exactText(generatedName));

    }
}
