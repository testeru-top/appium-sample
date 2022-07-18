/*
 * @Author: 霍格沃兹测试开发学社-盖盖
 * @Desc: '更多测试开发技术探讨，请访问：https://ceshiren.com/t/topic/15860'
 */
package top.testeru.sample;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;


/**
 * @program: appium-sample
 * @author: testeru.top
 * @description: bilibili测试用例
 * @Version 1.0
 * @create: 2022/7/18 15:04
 */
public class BiliBiliTest {
    //1、启动
    AndroidDriver driver;

    @Test
    public void testSearch() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //平台名称 安卓系统就是Android 苹果手机就是iOS
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //使用的driver uiautomator2
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //设备的系统版本
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0.0");
        //启动的app的包名
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "tv.danmaku.bili");
        //启动的app的页面
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivityV2");
        //设备名称
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "盖盖");
        //设备的UDID；adb devices -l 获取，多设备的时候要指定，若不指定默认选择列表的第一个设备
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "8c5f5f92");
        //app不重置
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//        1.启动app
        driver = new AndroidDriver(
                new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        //隐式等待 设置一次，全局生效
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(2));


        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        2.点击搜索按钮
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"搜索栏，按钮\"]")).click();

//        3.搜索框输入：考研
        By searchText = AppiumBy.id("tv.danmaku.bili:id/search_src_text");
        webDriverWait.withMessage("lambda查找失败").until(
                webDriver -> webDriver.findElement(searchText)
        );
        driver.findElement(searchText).clear();
        driver.findElement(searchText).sendKeys("考研");

//        4.选择：考研英语/第一个搜索结果
        driver.findElement(AppiumBy.id("tv.danmaku.bili:id/title")).click();

//        5.切换tab【直播】
        driver.findElements(AppiumBy.id("tv.danmaku.bili:id/tab_title")).get(2).click();

//        6.找到第一个的播放人数
        String num = driver.findElement(AppiumBy.id("tv.danmaku.bili:id/watched_text")).getText();

//        7.判断人数在100上下30%浮动
        assertThat(Double.valueOf(num), is(closeTo(100 * 1.3, 100 * 0.3)));

    }


}
