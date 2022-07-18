package top.testeru.po;

import org.junit.Test;
import top.testeru.page.BiliApp;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description:
 * @Version 1.0
 * @create: 2022/7/18 17:51
 */
public class BiliBiliPOTest {
    @Test
    public void testSearch() {
        //获取的观看人数的结果
        String num = new BiliApp().toMainPage().toSearch().toSearchResultPage().result();
        assertThat(Double.valueOf(num), is(closeTo(100 * 1.3, 100 * 0.3)));
    }
}
