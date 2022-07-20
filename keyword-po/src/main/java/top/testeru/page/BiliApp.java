package top.testeru.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.DesiredCapabilities;
import top.testeru.key.KeyWords;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.MobileCommand.LAUNCH_APP;
import static java.lang.Thread.sleep;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description:
 * @Version 1.0
 * @create: 2022/7/18 17:44
 */
public class BiliApp extends KeyWords {
    public BiliApp() {
        System.out.println("创建对象");
        if(driver==null){
            start();
        }
    }

    public BiliApp(AndroidDriver driver) {
        super(driver);
    }

    @Step("app启动")
    public BiliApp start(){
        logger.info("开始启动app");
        if(driver == null) {
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
            try {
                driver = new AndroidDriver(
                        new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            //隐式等待 设置一次，全局生效
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return this;
    }

    @Step("点击搜索按钮跳转到搜索页面")
    public SearchPage toSearch(){
        logger.info("点击搜索按钮跳转到搜索页面");
        //1.点击搜索按钮跳转到搜索页面
//        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"搜索栏，按钮\"]")).click();
        click(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"搜索栏，按钮\"]"));
        return new SearchPage(driver);
    }


    public void restart() {
        driver.launchApp();
//        execute(LAUNCH_APP);
    }
}
