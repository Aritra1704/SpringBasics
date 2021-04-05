package org.arpaul.javabrains;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
//		Triangle triangle = (Triangle) context.getBean("triangle");
//		triangle.draw();
//		Circle circle = (Circle) context.getBean("circle");
//		circle.draw();
		Shape shape = (Shape) context.getBean("circle");
		shape.draw();
	}
	/*
	 * To create autowired annotation
	 * in spring.xml add <bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor" />
	 * then add @Autowired annotation to the setter method, 
	 * if similar beans are there then use alias
	 */
	/**
	 * To verify all beans have been correctly declared in sprint.xml
	 * Add <bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor" />
	 */
	/*
	 * Creating Bean factory post processor
	 * In Spring.xml <bean class="org.arpaul.javabrains.MyBeanFactoryPP" />
	 * Create a class implementing public class MyBeanFactoryPP implements BeanFactoryPostProcessor
	 * 
	 * To remove declaration of object or value in spring.xml create a .properties file
	 * Map it in spring.xml this way
	 * <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer" >
		<property name="locations" value="pointsconfig.properties"></property>
	</bean>
	And map the data this way
	<bean id="pointA" class="org.arpaul.javabrains.Point">
		<property name="x" value="${pointA.pointX}" />
		<property name="y" value="${pointA.pointY}" />
	</bean>
	 */
	/**
	 * Attaching bean post processor
	 * In spring.xml add a anew bean <bean class="org.arpaul.javabrains.DisplayNameBeanPostProcessor" />
	 * Create the class and implement it as follows
	 * DisplayNameBeanPostProcessor implements BeanPostProcessor
	 */
	/*
	 * Attaching lifecycle methods for Bean
	 * SOLUTION 1
	 * implements InitializingBean, DisposableBean
	 * @Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializingbean init method called for triangle");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Desposablebean destroy method called for triangle");
	}
	
	SOLUTION 2
	in the respective bean block in spring.xml => init-method="myInit" destroy-method="myDestroy"
	in the respective bean class
	public void myInit() {
		System.out.println("MyInit method called for triangle");
	}
	
	public void myDestroy() {
		System.out.println("MyDestroy method called for triangle");
	}
	
	SOLUTION 3 
	if the init/cleanup methods are of similar names for all beans
	add these in beans cluster top level default-init-method="myInit" default-destroy-method="cleanup"
	
	SOLUTION 4 
	if both SOLUTION 1 and SOLUTION 3 is used together then SOLUTION 1 gets first preference at both stages(init and destroy) then comes SOLUTION 3
	 */
	/**
	 * Bean inheritance
	 * <bean id="parentTriangle" class="org.arpaul.javabrains.Triangle" >
		<property name="pointA" ref="pointA" />
	</bean>
	
	<bean id="triangle1" class="org.arpaul.javabrains.Triangle" parent="parentTriangle">
		<property name="pointB" ref="pointB" />
		<property name="pointC" ref="pointC" />
	</bean>
	
	<bean id="triangle2" class="org.arpaul.javabrains.Triangle" parent="parentTriangle">
		<property name="pointB" ref="pointB" />
	</bean>
	 * @param args
	 */
//	public static void main(String[] args) {
////		Triangle triangle = new Triangle();
////		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		Triangle triangle1 = (Triangle) context.getBean("triangle1");
//		triangle1.draw();
//		
//		Triangle triangle2 = (Triangle) context.getBean("triangle2");
//		triangle2.draw();
//
//	}

	/**
	 * Scopes:
	 * Singleton
	 * Prototype
	 * declare as
	 * <bean id="triangle" class="org.arpaul.javabrains.Triangle" name="triangle-name" autowire="byName" scope="singleton">
	 * <bean id="triangle" class="org.arpaul.javabrains.Triangle" name="triangle-name" autowire="byName" scope="prototype">
	 */
}
