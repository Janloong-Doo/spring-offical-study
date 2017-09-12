package com.janloong.controller;

import com.janloong.service.LoongService1;
import com.janloong.service.LoongService2;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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
public class LoongTest1 {

    @Mock
    private LoongService1 loongService1;
    @Mock
    private LoongService2 loongService2;

    @InjectMocks
    private LoongControoler1 loongControoler1;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(loongControoler1).build();
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
        String s = "my name is Janloong Doo";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", s);

        when(loongService1.test2(s))
                //.thenCallRealMethod()
                .thenReturn("success");

        this.mockMvc.perform(post("/test3")
                .params(map)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    //有实现层的service依赖controller注入
    @Test
    public void test4() throws Exception {
        String s = "My Name Is Janloong Doo";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", s);
        when(loongService2.test1(s))
                //.thenCallRealMethod()
                .thenReturn(s);

        this.mockMvc.perform(post("/test4")
                .params(map)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}
