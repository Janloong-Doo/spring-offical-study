package com.janloong.controller;

import com.janloong.dao.UserDao;
import com.janloong.domain.User;
import com.janloong.service.LoongService1;
import com.janloong.service.impl.LoongServiceImpl2;
import com.janloong.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * des: standaloneSetup方式 模拟测试环境
 *
 * @author Janloong
 * @create 2017-09-12 14:50
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
//@WebAppConfiguration //测试环境使用，用来表示测试环境使用的ApplicationContext将是WebApplicationContext类型的；value指定web应用的根
public class LoongTest1 {

    @Mock
    private LoongService1 loongService1;
    @Mock
    private LoongServiceImpl2 loongService2;
    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private LoongControoler1 loongControoler1;


    @Autowired
    private UserDao userDao;


    private MockMvc mockMvc;

    //@Autowired
    //private WebApplicationContext configuration;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(loongControoler1).build();//独立测试环境
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(configuration).build();//web测试环境

    }

    //普通controller 注入测试
    @Test
    public void test1() throws Exception {
        //模拟请求接口
        MvcResult mvcResult = this.mockMvc.perform(get("/test1")) // 执行一个requestbuilder请求
                .andDo(print())   //添加结果处理器
                .andExpect(status().isOk())  // 添加结果验证规则
                .andReturn(); //获取响应信息
        System.out.println("------------------");
        System.out.println(mvcResult.getResponse().getContentAsString());
        System.out.println("------------------");
    }

    //路径参数controller配置
    @Test
    public void test2() throws Exception {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("name", "666");
        MvcResult mvcResult = this.mockMvc.perform(post("/test2/" + map.get("name"))
                //.params(map) // 请求参数
                .contentType(MediaType.APPLICATION_JSON) //内容类型
        ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    //无实现层的service依赖controller注入
    @Test
    public void test3() throws Exception {
        String s = "my name is Janloong Doo，this is service method test";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", s);

        when(loongService1.test2(s))
                .thenCallRealMethod();
        //.thenReturn("success");

        this.mockMvc.perform(post("/test3")
                .params(map)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    //有实现层的service依赖controller注入 (需要注入实际实现层对象)
    @Test
    public void test4() throws Exception {
        String s = "My Name Is Janloong Doo";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", s);
        when(loongService2.test1(s))
                .thenCallRealMethod();
        //.thenReturn(s);

        this.mockMvc.perform(post("/test4")
                .params(map)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void test5() throws Exception {
        String id = "123";
        String name = "janloong";
        String age = "24";
        String address = "china NO.1";
        User user = new User();
        user.setCardId(id);
        user.setName(name);
        user.setAge(age);
        user.setAddress(address);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("id", "123");
        map.add("name", "janloong");
        map.add("age", "24");
        map.add("address", "china NO.1");

        userDao.update(user);
        //userDao.insert(user);

        when(userService.insert(user)).thenCallRealMethod();

        String contentAsString = this.mockMvc.perform(post("/test6")
                .params(map)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String s = new String(contentAsString.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("返回结果为 : " + s);

    }

    @Test
    public void test6() throws Exception {
        String id = "124";
        String name = "janloong";
        String age = "24";
        String address = "china NO.1";
        User user = new User();
        user.setCardId(id);
        user.setName(name);
        user.setAge(age);
        user.setAddress(address);
        int insert = userDao.insert(user);
        System.out.println("修改的数据为 : "+ insert);

    }

    //自定义注册对象的方法以及返回值
    @Test
    public void testx() throws Exception {
        String s = "My Name Is Janloong Doo ,this is text the answer";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", s);

        Answer<String> answer = new Answer<String>() {
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                //Object o = invocationOnMock.callRealMethod();//调用真实方法
                Object[] arguments = invocationOnMock.getArguments();//mock 方法调用的参数
                //Method method = invocationOnMock.getMethod();//mock 调用的方法对象

                //自动义方法
                String s = arguments[0] + "  and this is custom method";
                return s;
            }
        };
        when(loongService2.test1(s))
                .thenAnswer(answer);

        this.mockMvc.perform(post("/test4")
                .params(map)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    //verify校验
    @Test
    public void testy() {
        /*
        test1
         */
        //User user = new User();
        //user.setLoginName("admin");
        //// 第一次调用findUserByLoginName返回user 第二次调用返回null
        //when(mockUserDao.findUserByLoginName(anyString())).thenReturn(user).thenReturn(null);
        //try {
        //    // 测试如果重名会抛出异常
        //    userService.save(user);
        //    // 如果没有抛出异常测试不通过
        //    failBecauseExceptionWasNotThrown(RuntimeException.class);
        //} catch (ServiceException se) {
        //}
        //verify(mockUserDao).findUserByLoginName("admin");
        //
        //// userService.save(user);
        //user.setPassword("123456");
        //String userId = userService.save(user);
        //// 断言返回结果
        //assertThat(userId).isNotEmpty().hasSize(32);
        //
        //verify(mockUserDao, times(2)).findUserByLoginName(anyString());
        //verify(mockUserDao).save(any(User.class));

        /*
        test2
         */
        //User user = new User();
        //user.setLoginName("admin");
        //user.setPassword("123456");
        //userService.save(user);
        //
        //// 通过ArgumentCaptor(参数捕获器) 对传入参数进行验证
        //ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        //verify(mockUserDao).save(argument.capture());
        //assertThat("admin").isEqualTo(argument.getValue().getLoginName());
        //
        //// stub 调用save方法时抛出异常
        //doThrow(new ServiceException("测试抛出异常")).when(mockUserDao).save(any(User.class));
        //try {
        //    userService.save(user);
        //    failBecauseExceptionWasNotThrown(RuntimeException.class);
        //} catch (ServiceException se) {
        //}
    }

}
