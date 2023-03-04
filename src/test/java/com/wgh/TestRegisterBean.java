package com.wgh;

import com.wgh.config.SpringConfig;
import com.wgh.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassNam TestRegisterBean
 * @Author zuijiaoshangyang
 * @Date 2023/3/4 23:01
 **/
public class TestRegisterBean {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object user = context.getBean("user");
        System.out.println(user);
    }
}
