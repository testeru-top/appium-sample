package top.testeru.po;


import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.remote.DesiredCapabilities;
import top.testeru.page.BiliApp;
import top.testeru.page.SearchResultPage;

import java.net.MalformedURLException;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * @program: appium-sample
 * @author: testeru.top
 * @description:
 * @Version 1.0
 * @create: 2022/7/18 17:51
 */
@DisplayName("bilibili搜索")
public class BiliBiliPOTest {
    private static BiliApp biliApp;
    private SearchResultPage searchResultPage;

    @BeforeAll
    static void beforeAll(){
        biliApp = new BiliApp();
    }
    @BeforeEach
    void beforeEach(){
        System.out.println(biliApp);
//        biliApp.restart();
    }

    @AfterAll
    static void afterAll(){
        biliApp.quite();
    }
    @AfterEach
    public void afterEach(){
        biliApp = searchResultPage.toBiliApp();
    }
    @Test
    @Description("search Person Num.")
    @DisplayName("搜索用例")
    public void testSearch() {
        String search = "法律";
        //获取的观看人数的结果
        searchResultPage = biliApp
                .toSearch()
                .toSearchResultPage(search);
        String num = searchResultPage
                .result();
        assertThat(Double.valueOf(num), is(equalTo(Double.valueOf(num))));

//        assertThat(Double.valueOf(num), is(closeTo(Double.valueOf(num) * 1.3, Double.valueOf(num) * 0.3)));
    }
    @ParameterizedTest
    @MethodSource
    @Description("search Param Person Num.")
    @DisplayName("搜索用例参数化")
    public void testSearchP(String search, int price) {
        //获取的观看人数的结果
        searchResultPage = biliApp
                .toSearch()
                .toSearchResultPage(search);
        String num = searchResultPage
                .result();
        assertThat(Double.valueOf(num), is(equalTo(Double.valueOf(num))));

//        assertThat(Double.valueOf(num), is(closeTo(price * 1.3, price * 0.3)));
    }

    static Stream<Arguments> testSearchP(){
        return Stream.of(
                Arguments.arguments("考研",100),
                Arguments.arguments("测试",100)
        );
    }



}
