package top.testeru.webview;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import top.testeru.BaseTest;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description:
 * @Version 1.0
 * @create: 2022/7/26 14:51
 */
public class WebView_1_Test extends BaseTest {
    @Test
    public void getContenct(){
        //雪球首页是否有webview页面
//        logger.info("雪球首页：{}",driver.getContextHandles());//[NATIVE_APP]
//        driver.findElement(AppiumBy.xpath("//*[@text=\"股票\"]")).click();
//        logger.info("股票页面：{}",driver.getContextHandles());//[NATIVE_APP]
//        driver.findElement(AppiumBy.xpath("//*[@text=\"招商银行\"]")).click();
//        logger.info("股票页面：{}",driver.getContextHandles());//[NATIVE_APP]
//        driver.findElement(AppiumBy.id("com.xueqiu.android:id/banner_image")).click();
//
//       webDriverWait.until(webDriver -> {
//
//           Set<String> contextHandles = driver.getContextHandles();
//           logger.info("页面：{}",contextHandles);//[NATIVE_APP]
//           return contextHandles.contains("WEBVIEW");
//       });


        driver.findElement(By.xpath("//*[@text=\"交易\"]")).click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        System.out.println(contextNames.toArray());
        System.out.println(contextNames.toArray()[1]);
        System.out.println(contextNames.toArray()[1].toString());
        driver.context("WEBVIEW_com.xueqiu.android"); // set context to WEBVIEW_1


        System.out.println(driver.getContext());
        driver.findElement(By.xpath("//*[@class=\"old_trade_home_onsale_2Hw\"]")).click();



    }

}
