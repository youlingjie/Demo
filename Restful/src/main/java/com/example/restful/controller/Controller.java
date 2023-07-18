package com.example.restful.controller;

import com.example.restful.entity.User;
import com.sun.xml.internal.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("restful")
@Slf4j
public class Controller {


    //    required：是否包含该参数，默认为true，表示该请求路径中必须包含该参数，如果不包含就报错。
    //    defaultValue：默认参数值，如果设置了该值，required=true将失效，自动为false,如果没有传该参数，就使用默认值




    //    @PathVariable注解用以映射URL绑定的占位符   将占位符参数绑定对应的方法入参
    //    语法:@PathVariable(对应占位符参数名)
    /**
     * 路径传参测试1
     * value={}中以,分隔对应不同的url映射
     * http://localhost:8080/restful/path/张三/20/9999.0    http://localhost:8080/restful/path/张三/9999.0
     * 占位符参数名和方法参数名一致时可以简写为 @PathVariable
     */

    @RequestMapping(value = {"/path/{name}/{age}/{money}", "/path/{name}/{money}"})
    public String path1(@PathVariable String name,
                        @PathVariable (required = false) Integer age,
                        @PathVariable Double money) {
        User user = new User();
        user.setName(name);
        user.setMoney(money);
        user.setAge(age);
        return String.valueOf(user);
    }


    /**
     * 路径传参测试2
     * http://localhost:8080/restful/path/20.0
     * 占位符参数名和方法参数名不一致时 使用@PathVariable("占位符参数名") 进行与方法参数的映射
     */
    @RequestMapping("/path/{age}")
    public String path2(@PathVariable("age") Double money) {
        User user = new User();
        user.setMoney(money);
        return String.valueOf(user);
    }








    /**
     * 对应参数接收表单传参
     * http://localhost:8080/restful/form1?name=张三&age=20&money=9999
     * 方法参数必须与前端参数名字一种
     */
    @RequestMapping("/form1")
    public String form1(String name, Integer age, Double money) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setMoney(money);
        return String.valueOf(user);
    }




    /**
     * 注解接收表单传参
     * http://localhost:8080/restful/form2?name=张三&age=20&money=9999
     * 语法：@RequestParam(value=”参数名”,required=”true/false”,defaultValue=””)
     * 通过@RequestParam("name")对方法参数进行绑定 方法参数名字可以前端参数名字不一致
     */
    @RequestMapping("/form2")
    public String form2(@RequestParam("name") String a, @RequestParam("age")Integer b, @RequestParam("money")Double c) {
        User user = new User();
        user.setName(a);
        user.setAge(b);
        user.setMoney(c);
        return String.valueOf(user);
    }

    /**
     * 实体类接收表单传参
     * http://localhost:8080/restful/form3?name=张三&age=20&money=9999
     * 请求中的参数名与实体中的属性名一致即可自动映射到实体属性中
     */
    @RequestMapping("/form3")
    public String from3(User user) {
        return String.valueOf(user);
    }


    /**
     * 接收json字符串
     * @RequestBody接收请求体中的JSON字符串参数直接映射实体类对象
     * 实体类中的属性名称必须与JOSN字符串串中的参数key名称完全一致,不同命名参数无法正确接收
     * http://localhost:8080/restful/json
     * {
     *     "name":"张三",
     *     "age":"20",
     *     "money":"9999"
     * }
     */
    @RequestMapping("/json")
    public String json(@RequestBody User user) {
        return String.valueOf(user);
    }


    /**
     *传统的接收参数方式,可以接收url params 传参,支持post from类型传参,不支持JSON传参
     */
    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setAge(Integer.valueOf(request.getParameter("age")));
        user.setMoney(Double.parseDouble(request.getParameter("money")));
        return String.valueOf(user);
    }


    /**
     * 接收文件
     *
     */
    @RequestMapping("/file")
    public void multipartFile(@RequestParam MultipartFile multipartFile){
        log.info("{}",multipartFile);
    }

    //Todo 时间

}

