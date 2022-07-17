package top.testeru.wait;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description: 显示等待判断条件
 *     new WebDriverWait(driver, Duration.ofSeconds(20),Duration.ofSeconds(2)).until(
 *                 //等待条件
 *         );
 * @Version 1.0
 * @create: 2022/7/14 11:12
 */
public class ExpectedConditions_01_Test extends BaseTest{
    By hot = AppiumBy.xpath("//*[@text=\"热门\"]");
    //首页的轮循图片
    By image = AppiumBy.id("tv.danmaku.bili:id/image");
    //热门的排行榜
    By icon = AppiumBy.id("tv.danmaku.bili:id/item_icon");



    /**
     * 页面的 DOM 上是否存在元素，该元素不一定肉眼可见
     */
    @Test
    public void waitEleLocatedTest(){
        webDriverWait.until(
                //等待条件:检查页面的 DOM 上是否存在元素，该元素不一定肉眼可见
                ExpectedConditions.presenceOfElementLocated(hot)
        );
        driver.findElement(hot).click();
    }



    /**
     * 页面的 DOM 上是否存在元素，该元素肉眼可见
     */
    @Test
    public void waitEleViLocatedTest(){
        webDriverWait.until(
                //等待条件:检查页面的 DOM 上是否存在元素，该元素肉眼可见
                //返回 true，元素存在于 DOM 中
                ExpectedConditions.visibilityOfElementLocated(hot)
        );
        driver.findElement(hot).click();
    }
    /**
     * 页面的 DOM 上是否存在元素，该元素肉眼可见
     * 返回 true，因为元素不存在于 DOM 中
     */
    @Test
    public void waitEleInviLocatedTest(){
        webDriverWait.until(
                //等待条件:检查页面的 DOM 上是否存在元素，该元素肉眼可见
                //返回 true，因为元素不存在于 DOM 中
                ExpectedConditions.invisibilityOfElementLocated(image)
        );
        driver.findElement(hot).click();
    }
    /**
     * 元素是否可点击
     */
    @Test
    public void waitEleToBeClickTest(){
        webDriverWait.until(
                //等待条件:元素是否可点击 元素不只在当前dom树里面可见，对应的click属性值也要加载出来
                ExpectedConditions.elementToBeClickable(hot)
        );
        //如果是为了点击操作，则可等待该元素可点击的时候再操作
        driver.findElement(hot).click();
    }

    /**
     * 相反
     */
    @Test
    public void waitNotTest(){
        driver.findElement(hot).click();
        webDriverWait.until(
                //包不要导错 ExpectedConditions的not
                not(
                    //点击热门后，页面没有image元素
                    ExpectedConditions.presenceOfElementLocated(hot)
                )
        );
        driver.findElement(icon).click();

    }

}
