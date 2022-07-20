package top.testeru.key;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description:
 * @Version 1.0
 * @create: 2022/7/18 18:49
 */
public class OldKeyWords {
    public AndroidDriver driver;
    By currentBy;

    WebElement currentElement;

    List<WebElement> currentElements;
    public OldKeyWords(AndroidDriver driver) {
        this.driver = driver;
    }

    public OldKeyWords() {
    }

    private By getBy(String selector){
        if (selector.startsWith("//")) {
            //xpath定位
            System.out.println("xpath定位");
            currentBy = AppiumBy.xpath(selector);
        } else if (selector.startsWith("new UiSelector()")) {
            //原生定位
            currentBy = AppiumBy.androidUIAutomator(selector);
        } else if (selector.startsWith("*") | selector.startsWith("#")) {
            //css定位 id-->#    AccessibilityId-->*
            currentBy = AppiumBy.cssSelector(selector);
        } else if (selector.startsWith("tv.danmaku.bili")) {
            //id定位 包名开头
            System.out.println("id定位");
            currentBy = AppiumBy.id(selector);
        }
        return currentBy;
    }
    private By getBy(String selector, String strategy){
        if (strategy.equals("id")) {
            currentBy = AppiumBy.id(selector);
        }else if(strategy.equals("css")) {
            currentBy = AppiumBy.cssSelector(selector);
        }else if(strategy.equals("class")) {
            currentBy = AppiumBy.className(selector);
        }
        return currentBy;
    }

//
    public List<WebElement> finds(By by)  {
        currentElements = driver.findElements(by);
        return currentElements;
    }

    public List<WebElement> finds(String selector) {
        return finds(getBy(selector));
    }
    public List<WebElement> finds(String selector, String strategy) {
        return finds(getBy(selector,strategy));
    }
    //直接查找元素
    public OldKeyWords find(By by)  {
        currentElement = driver.findElement(by);
        return this;
    }

    /**
     * xpath
     * css：id-->#    AccessibilityId-->*
     * id带包名
     * @param selector
     * @return
     */
    public OldKeyWords find(String selector) {
        return find(getBy(selector));
    }
    public OldKeyWords find(String selector, String strategy) {
        return find(getBy(selector,strategy));
    }

    public void click() throws Exception {
        try {
            currentElement.click();
        } catch (Exception e) {
            handleExceptions();
            click();
        }
    }

    public void click(By by) {
        try {
            find(by).click();
        } catch (Exception e) {
            handleExceptions();
            click(by);
        }
    }
    public void click(String selector)  {
        find(selector);
        try {
            click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void click(String selector, int index)  {
        currentElement = finds(selector).get(index);
        try {
            click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void click(String selector, String strategy) {
        find(selector, strategy);
        try {
            click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void click(String selector, String strategy, int index) {
        currentElement = finds(selector, strategy).get(index);
        try {
            click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


//    sendKeys
    public void sendKeys(String text) {
        currentElement.clear();
        currentElement.sendKeys(text);
    }

    public void sendKeys(By by, String text) {
        find(by);
        currentElement.clear();
        currentElement.sendKeys(text);
    }
    public void sendKeys(String selector, String text)  {
        find(selector);
        currentElement.clear();
        currentElement.sendKeys(text);

    }
    public void sendKeys(String selector, String strategy, String text) {
        find(selector, strategy);
        currentElement.clear();
        currentElement.sendKeys(text);
    }

    /**
     * 无控件上下文的action
     */
    public void back() {
        driver.navigate().back();
    }



//    getText
    public String getText(By by) {
        find(by);
        return currentElement.getText();

    }
    public String getText(String selector) {
        find(selector);
        return currentElement.getText();
    }

    public String getAttribute(String name) {
        return currentElement.getAttribute(name);
    }
    public void handleExceptions() {
        String source = driver.getPageSource();
        if(source.contains("tv.danmaku.bili:id/btn_close")){
            click("tv.danmaku.bili:id/btn_close");
        }
    }

}
