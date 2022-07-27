package top.testeru;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.app.SupportsAutoGrantPermissionsOption;
import io.appium.java_client.ios.options.wda.SupportsWaitForIdleTimeoutOption;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description:
 * @Version 1.0
 * @create: 2022/7/26 14:44
 */
public class BaseTest {
    public static final Logger logger = getLogger(lookup().lookupClass());


    public static AndroidDriver driver;
    public static WebDriverWait webDriverWait;
    @BeforeAll
    public static void beforeAll(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //平台名称 安卓系统就是Android 苹果手机就是iOS
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //使用的driver uiautomator2
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //设备的系统版本
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.0");
        //启动的app的包名
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.xueqiu.android");
        //启动的app的页面
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".view.WelcomeActivityAlias");
        //设备名称
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "盖盖");
        //设备的UDID；adb devices -l 获取，多设备的时候要指定，若不指定默认选择列表的第一个设备
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        //app不重置
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        //运行失败的时候打印page source到appium-log
        desiredCapabilities.setCapability(MobileCapabilityType.PRINT_PAGE_SOURCE_ON_FIND_FAILURE, true);
        //在假设客户端退出并结束会话之前，Appium 将等待来自客户端的新命令多长时间（以秒为单位） http请求等待响应最长5分钟
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300000);
        //默认权限通过
        desiredCapabilities.setCapability(SupportsAutoGrantPermissionsOption.AUTO_GRANT_PERMISSIONS_OPTION, true);

        desiredCapabilities.setCapability(SupportsWaitForIdleTimeoutOption.WAIT_FOR_IDLE_TIMEOUT_OPTION, 0);
//        desiredCapabilities.setCapability(AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, true);
//完善的自动发现方案
        desiredCapabilities.setCapability("chromedriverExecutableDir", "/Users/gaigai/Documents/hogwarts/chromedriver/2.20");
        desiredCapabilities.setCapability("chromedriverChromeMappingFile", "/Users/gaigai/Documents/hogwarts/mapping.json");
        desiredCapabilities.setCapability("showChromedriverLog", true);


//        1.启动app--创建driver
        long startTime = System.currentTimeMillis();

        try {
            driver = new AndroidDriver(
                    new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        //隐式等待 设置一次，全局生效
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));

//        webDriverWait.until(webDriver -> webDriver.getPageSource().contains("今日市场"));
        long endTime = System.currentTimeMillis();
        logger.info("app启动时间为：{}",(endTime-startTime)/1000);


    }
}
