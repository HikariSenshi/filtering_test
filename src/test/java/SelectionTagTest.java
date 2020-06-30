import com.codeborne.selenide.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelectionTagTest {

    @BeforeTest
    public void setUpDriver(){

        Configuration.fastSetValue = true;
        Configuration.browser = "chrome";
        System.setProperty("selenide.browser", "chrome");
        open("https://demo.realworld.io/#/");
        TestingTools.waitFullLoading();

    }

    @Test(description = "Selecting random tag")
    public void selectAnyTag(){

        SelenideElement someTag = $(".tag-list a.tag-default");
        someTag.should(Condition.exist).shouldBe(Condition.visible).shouldHave(Condition.cssValue("background-color","rgba(129, 138, 145, 1)"));
        someTag.click();

        someTag.shouldBe(Condition.focused);
        String tagText = someTag.getText();

        $(".outline-active .nav-link.active").shouldHave(Condition.text(tagText));
        $$(".article-preview .tag-list").forEach(preview -> preview.shouldHave(Condition.text(tagText)));

    }

    @Test(description = "Tag should be removed while reloading the page")
    public void reloadPage(){

        SelenideElement someTag = $(".tag-list a.tag-default");
        someTag.click();
        String tagText = someTag.getText();
        Selenide.refresh();

        $(".outline-active").$(Selectors.withText(tagText)).shouldNot(Condition.exist);
        someTag.shouldNotBe(Condition.focused);

    }

    @Test(description = "Tag should be removed while selecting global feed")
    public void removeTag(){

        SelenideElement someTag = $(".tag-list a.tag-default");
        someTag.click();
        String tagText = someTag.getText();

        $(Selectors.withText("Global Feed")).click();
        $(".outline-active").$(Selectors.withText(tagText)).shouldNot(Condition.exist);
        someTag.shouldNotBe(Condition.focused);

    }
}
