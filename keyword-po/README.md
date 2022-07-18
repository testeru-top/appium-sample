# app-po
1.用公共方法来表示某个页面
2.尽量不要暴露页面的内部
3.一般页面内不要断言
4.方法返回其他页面的对象
5.不需要表示整个页面
6.同一个行为的不同结果构建不同方法
## bilibiliTest

### 直接编写测试用例
1.启动app
2.点击搜索按钮
3.搜索框输入：考研
4.选择：考研英语/第一个搜索结果
5.切换tab【直播】
6.找到第一个的播放人数
7.判断人数在100上下10%浮动


### 编写PO
#### 创建每个页面类
1、首页
2、搜索页
3、搜索结果页

- 空的调用链路
```java
public class BiliBiliPOTest {
    @Test
    public void testSearch() throws MalformedURLException {
        //获取的观看人数的结果
        String num = new MainPage().toSearch().toSearchResultPage().result();
        assertThat(Double.valueOf(num), is(closeTo(100 * 1.3, 100 * 0.3)));
    }
}
```
#### 编写每个页面的业务逻辑
- 每个页面都需要使用 AndroidDriver 进行业务逻辑编写
- AndroidDriver 必须在每个页面使用的是同一个
  - 单例模式
- 