package top.testeru.capability;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description: 基础的启动参数
 * 获取包名：
 * 获取启动页面：
 * @Version 1.0
 * @create: 2022/7/14 10:53
 */
public class CapabilitiesBasic_01_Test {
    //1、启动
    AndroidDriver driver;
    @Test
    public void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //平台名称 安卓系统就是Android 苹果手机就是iOS
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //使用的driver uiautomator2
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //设备的系统版本
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.0");
        //启动的app的包名
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "tv.danmaku.bili");
        //启动的app的页面
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivityV2");

        driver = new AndroidDriver(
                new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        //隐式等待 设置一次，全局生效
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}