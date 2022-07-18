package top.testeru.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import top.testeru.key.KeyWords;

import java.time.Duration;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description: 搜索页面
 * @Version 1.0
 * @create: 2022/7/18 17:47
 */
public class SearchPage extends BiliApp {


    public SearchPage(AndroidDriver driver) {
        super(driver);
    }
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofSeconds(2));

    public SearchResultPage toSearchResultPage(){

        //搜索页面输入搜索的内容
        //点击第一个搜索联想内容，跳转到搜索结果页
//        3.搜索框输入：考研
        By searchText = AppiumBy.id("tv.danmaku.bili:id/search_src_text");
        webDriverWait.withMessage("lambda查找失败").until(
                webDriver -> webDriver.findElement(searchText)
        );
        driver.findElement(searchText).clear();
        driver.findElement(searchText).sendKeys("考研");

//        4.选择：考研英语/第一个搜索结果
        driver.findElement(AppiumBy.id("tv.danmaku.bili:id/title")).click();

        return new SearchResultPage(driver);
    }
}
