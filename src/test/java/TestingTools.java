import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestingTools {

    public static void waitFullLoading(){

        Wait<WebDriver> wait = new WebDriverWait(WebDriverRunner.getWebDriver(),5);
        wait.until(driver -> {
            String exec = String
                    .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"));
            return (exec.equals("complete"));

        });

    }

}
