package top.testeru.webview;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import top.testeru.Base2Test;
import top.testeru.BaseTest;

import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description:
 * @Version 1.0
 * @create: 2022/7/26 14:51
 */
public class WebView_2_Test extends Base2Test {
    @Test
    public void getContenct(){


        driver.findElement(By.xpath("//*[@text=\"Dual Webview Demo\"]")).click();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(driver.getPageSource());

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }


        System.out.println("----开始切换---");
        System.out.println(driver.findElements(By.className("android.webkit.WebView")));
//答案在于 Chromedriver 的工作原理。 Appium 使用 Chromedriver 进行 Chrome 自动化，
// Chromedriver 通过将它们视为单独的窗口来处理单个 Android 应用程序中的多个 webview。
// 这意味着我们可以使用内置的 Webdriver 窗口命令访问它们，如下所示：
        driver.context(contextNames.toArray()[1].toString()); // set context to WEBVIEW_1
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.forEach(s -> System.out.println(s));
        driver.switchTo().window(windowHandles.toArray()[0].toString());



        System.out.println(driver.getContext());
        System.out.println(driver.getPageSource());
//        List<WebElement> elements = driver.findElements(By.className("android.widget.TextView"));
//        elements.forEach(
//                webElement -> System.out.println("app:"+webElement.getText())
//        );
        List<WebElement> elements = driver.findElements(By.xpath("//h2"));

        elements.forEach(
                webElement -> System.out.println("web:"+webElement.getText())
        );

    }

}
