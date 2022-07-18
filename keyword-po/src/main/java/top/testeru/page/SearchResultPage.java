package top.testeru.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import top.testeru.key.KeyWords;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description: 搜索结果页面
 * @Version 1.0
 * @create: 2022/7/18 17:47
 */
public class SearchResultPage extends BiliApp {

    public SearchResultPage(AndroidDriver driver) {
        super(driver);
    }

    public String result(){
        //点击tab切换
        //获取结果列表的观看人数值
        //返回结果

//        5.切换tab【直播】
        driver.findElements(AppiumBy.id("tv.danmaku.bili:id/tab_title")).get(2).click();

//        6.找到第一个的播放人数
        String num = driver.findElement(AppiumBy.id("tv.danmaku.bili:id/watched_text")).getText();

        return num;
    }
}
