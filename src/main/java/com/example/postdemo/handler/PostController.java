package com.example.postdemo.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.postdemo.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//将该类纳入spring容器
public class PostController {
    private String result;

    @ResponseBody//json
    @RequestMapping(value="/testPost")//接收请求
    public String testPost(User user){
        System.out.println("111111");
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(username+"&&"+password);
        JSONObject jsonObject = new JSONObject();

        if ("lilei".equals(username)&&"123".equals(password)) {
            System.out.println("成功");
            jsonObject.put("msg","loginsuccess");
            result = jsonObject.toJSONString();
        }else{
            System.out.println("失败");
            jsonObject.put("msg","loginfail");
            result = jsonObject.toJSONString();
        }
        return result;
    }
}
