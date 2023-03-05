package com.wgh.register;

/**
 * @ClassNam MyComponentRegisterPostProcessor
 * @Author zuijiaoshangyang
 * @Date 2023/3/5 14:22
 **/

import com.wgh.utils.BaseClassScanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *          实现自定义注解@MyComponent 注册Bean功能
 * @author zuijiaoshangyang
 */

@Component
public class MyComponentRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //通过Utils工具类扫描指定包下的@MyComponent注解获取相应的信息  {person = class com.wgh.pojo.Person}
        Map<String, Class> map = BaseClassScanUtils.scanMyComponentAnnotation("com.wgh");
        map.forEach((beanName,clazz)->{
            String className = clazz.getName();  //com.wgh.pojo.Person
            //
            BeanDefinition definition = new RootBeanDefinition();
            definition.setBeanClassName(className);
            registry.registerBeanDefinition(beanName, definition);
        });
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
