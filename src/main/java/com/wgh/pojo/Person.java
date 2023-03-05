package com.wgh.pojo;

import com.wgh.annotation.MyComponent;

/**
 * @ClassNam Person
 * @Author zuijiaoshangyang
 * @Date 2023/3/5 12:01
 **/
@MyComponent("person")
public class Person {
    public Person() {
        System.out.println("无参构造实例化Person ...");
    }
}
