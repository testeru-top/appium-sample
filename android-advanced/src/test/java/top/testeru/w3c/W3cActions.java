package top.testeru.w3c;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.util.Arrays;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;
/**
 * @program: appium-sample
 * @author: testeru.top
 * @description: w3c手势操作
 * @Version 1.0
 * @create: 2022/7/14 16:49
 */
//        Dimension dimension = driver.manage().window().getSize();
//        Point start = new Point((int)(dimension.width*0.5), (int)(dimension.height*0.9));
//        Point end = new Point((int)(dimension.width*0.2), (int)(dimension.height*0.1));
//        W3cActions.doSwipe(driver, start, end, 1000);  //with duration 1s
//
public class W3cActions {
    /**
     * PointerInput：指针输入源是与指针类型输入设备相关联 的输入源
     * Kind：指点设备的类型。这可以是“mouse”「鼠标」、“pen”「笔」或“touch”「手指」
     * name：指点设备的名字
     */
    private final static PointerInput FINGER = new PointerInput(TOUCH, "finger");

    /** 一系列动作pointerDown，然后是pointerMove，然后是 pointerUp
     * createPointerMove：指针应移动到的屏幕位置，无论是处于活动（按下）还是非活动状态。
     */

//给定 InputSource 的一系列动作对象，用于 W3C 动作命令。在规范中，一个动作由一系列序列组成，每个 InputSource 一个。其中每一个都由交互组成，每个序列中的第一项同时执行，然后是第二项，依此类推，直到所有序列中的所有交互都已执行。
    public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
        //FINGER 设备; 1 初始长度
        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(FINGER.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY()))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }

    public static void doTap(AppiumDriver driver, Point point, int duration) {
        Sequence tap = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), point.getX(), point.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(FINGER, ofMillis(duration)))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }

}
