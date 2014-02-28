package com.dianping.start;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-2-27
 * Time: PM9:34
 * To change this template use File | Settings | File Templates.
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory---------begin");
        System.out.println("decide to process myBean");
        BeanDefinition myBeanDefinition = configurableListableBeanFactory.getBeanDefinition("myBean");
        if(myBeanDefinition!=null){
            System.out.println("myBeanDefinition.isLazyInit() : "+myBeanDefinition.isLazyInit());
            System.out.println("myBeanDefinition.isSingleton() : "+myBeanDefinition.isSingleton());
            MutablePropertyValues propertyValues = myBeanDefinition.getPropertyValues();
            PropertyValue propertyValue = propertyValues.getPropertyValue("sex");
            propertyValue.setConvertedValue("guess ni mei");
            System.out.println("modify myBean sex");
        }
        System.out.println("postProcessBeanFactory---------end");
    }



}
