package com.wgh.register;

import com.wgh.pojo.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @ClassNam MyPostProcessor
 * @Author zuijiaoshangyang
 * @Date 2023/3/4 22:52
 *
 *       通过配置BeanDefinition信息来动态注册Bean (BeanFactory后置处理器)
 **/
@SuppressWarnings("ALL")
@Component
public class MyPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //获取BeanDefinition 设置Bean信息
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName("com.wgh.pojo.User");
        //TODO 这样设置则通过getBean(""user")获取的实例是Person
        //beanDefinition.setBeanClassName("com.wgh.pojo.Person");
        registry.registerBeanDefinition("user", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
