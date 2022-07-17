package top.testeru.wait;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description: 显示等待判断条件
 * @Version 1.0
 * @create: 2022/7/14 11:12
 */
public class UtilLambda_01_Test extends BaseTest{
    By hot = AppiumBy.xpath("//*[@text=\"热门\"]");
    //首页的轮循图片
    By image = AppiumBy.id("tv.danmaku.bili:id/image");
    //热门的排行榜
    By icon = AppiumBy.id("tv.danmaku.bili:id/item_icon");



    //Function方法
    @Test
    public void waitFindEleTest(){
        Function<WebDriver, Object> function = new Function<>() {
            @Override
            public Object apply(WebDriver webDriver) {
                return webDriver.findElement(icon);
            }

        };
        FluentWait<WebDriver> withMessage = webDriverWait.withMessage("查找失败");

        withMessage.until(function);
        driver.findElement(hot).click();
    }
    //Lambda方法-元素查找
    @Test
    public void waitFindEleWithLambdaTest(){
        webDriverWait.withMessage("lambda查找失败").until(
                webDriver -> webDriver.findElement(hot)
        );
        driver.findElement(hot).click();
    }

    //Lambda方法-页面文本判断
    @Test
    public void waitPageSourceTest(){
        webDriverWait.until(
                webDriver -> webDriver.getPageSource().contains("热门")
        );
        driver.findElement(hot).click();
    }
    //Lambda方法-多逻辑操作
    @Test
    public void waitLambdaTest(){
        webDriverWait.until(
                webDriver -> {
                    //可以写多个业务逻辑操作
                    webDriver.findElement(hot).click();
                    return webDriver.getPageSource().contains("tv.danmaku.bili:id/item_icon");
                }
        );
        driver.findElement(icon).click();
    }

}
