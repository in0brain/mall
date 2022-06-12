此次工程注意点：
    在用pom.xml导入时，要看maven-repo里面有什么，不然会导致太多错误信息在日志里面，删的很辛苦
    Mapper.xml和Mapper最好放在一起，不然难找
    同时应该在pom.xml中，<bulid>...</build>中添加：
        <resources>
              <resource>
                <directory>src/main/java</directory>
                <includes>
                  <include>**/*.properties</include>
                  <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
              </resource>
        </resources>
    注：**代表任意目录，*代表任意文件

编程思路：
用户登录部分：
    1.数据库创建对应的用户表 user1(MySQL)
    2.前台
        登录页面 login.jsp
            用户登录 JS校验
                登录表单验证
                1.给登录表单绑定点击事件
                2.获取用户名和密码的值
                3.判断姓名是否为空
                    如果为空，弹窗，并且return
                4.判断密码是否为空
                    如果为空，弹窗，并且return
                5.手动提交表单
        首页 index.jsp
    3.后台实现
        登录功能
        1.接收客户端传来的数据（接收参数：用户名和密码）
        2.参数的非空判断
            1）为空，设置状态，设置提示信息，设置回显信息，
            将消息存在request作用域中，请求跳转发送到登录页面
            return
            2）不为空，在数据库中查找
        3.通过用户姓名查询用户对象
        4.判断用户对象是否为空
            1）为空，通过消息模型对象返回结果
            2）不为空
                ① 在数据库查询
                ② 跳转首页（请求转发/重定向）跳转到首页后，用户信息设置到session作用域中
主页部分：
    1.数据库存储商品信息 product（ id，名称，价格，种类，描述信息，图片）
      数据库 customer 存product id和user name的绑定
    2.前台实现
        1）读取数据库中的数据，按种类分类，用瀑布流实现商品的排列
           左端的变为类别，点击后刷新页面变成该类的东西
        2）每个商品绑定点击事件，通过ID传参到商品页面
           商品左上角的 收藏按键 会随着user的权限变为admin而修改成 删除按键，add to cast也会消失
        3）管理键（右下角的灯），判断在不在admin里面，在admin中就刷新页面变为管理员，再次点击又变回user


个人页面：
    1.可以申请管理员
