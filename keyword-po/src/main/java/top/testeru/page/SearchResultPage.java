package top.testeru.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

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

    @Step("获取搜索结果的观看直播的人数")
    public String result(){
        logger.info("获取搜索结果的观看直播的人数");
        //点击tab切换
        //获取结果列表的观看人数值
        //返回结果

//        5.切换tab【直播】
        click(AppiumBy.id("tv.danmaku.bili:id/tab_title"), 2);
//        6.找到第一个的播放人数
        String num = getText(AppiumBy.id("tv.danmaku.bili:id/watched_text"));
        return num;
    }

    public BiliApp toBiliApp() {
        click(AppiumBy.xpath("//*[@text=\"取消\"]"));
        waitWithUtil().until(webDriver -> webDriver.getPageSource().contains("游戏中心,按钮"));
        return new BiliApp(driver);
    }
}
