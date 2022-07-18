package top.testeru.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import top.testeru.key.KeyWords;

import static java.lang.Thread.sleep;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description:
 * @Version 1.0
 * @create: 2022/7/18 17:47
 */
public class MainPage extends BiliApp {
    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    //启动app进入mainpage




    public SearchPage toSearch(){
        //1.点击搜索按钮跳转到搜索页面
        driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@content-desc=\"搜索栏，按钮\"]")).click();

        return new SearchPage(driver);
    }
}
