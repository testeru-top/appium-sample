package top.testeru.key;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description:
 * @Version 1.0
 * @create: 2022/7/18 18:49
 */
public class KeyWords {
    public static final Logger logger = getLogger(lookup().lookupClass());

    public AndroidDriver driver;

    public KeyWords() {
    }

//    BlackWrapper
    public KeyWords(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By by){
        WebElement element = driver.findElement(by);
        screen(by.toString());//截图
        return element;
    }

    private void screen(String message) {
        //路径1/路径2  路径1/\路径2
        //生成时间戳
        long nowTime = System.currentTimeMillis();
        //进行截图操作
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //在硬盘中创建一个文件，将截图复制过去
        //当前项目下的jpg文件夹内 时间戳.jpg
        Path jpgPath = Paths.get("jpg", nowTime + ".jpg");
        File file = jpgPath.toFile();
        try {
            //apache common io
            FileUtils.copyFile(screenshot, file);
            //添加到报告中
            Allure.addAttachment(message, "image/jpg", new FileInputStream(jpgPath.toFile()), ".jpg");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<WebElement> finds(By by){
        logger.info("find element : {} ", by);
        return driver.findElements(by);
    }
    public void click(By by){
        logger.info("click element : {} ", by);
        find(by).click();
    }
    public void click(By by, int index){
        logger.info("click elements : {} , index is : {}", by, index);
        finds(by).get(index).click();
    }
    public String getText(By by){
        String text = find(by).getText();
        logger.info("element : {}  , text : {}", by, text);
        return text;
    }

    public void sendKeys(By by, String text){
        find(by).clear();
        find(by).sendKeys(text);
        logger.info("element : {}  , send : {}", by, text);
    }
    /**
     * 无控件上下文的action
     */
    public void back() {
        driver.navigate().back();
        logger.info("page back");
    }
    public void quite() {
        driver.quit();
        logger.info("app quite");
    }
    public WebDriverWait waitWithUtil(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return webDriverWait;
    }
}
