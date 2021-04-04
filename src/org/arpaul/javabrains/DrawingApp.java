package org.arpaul.javabrains;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.draw();
	}
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
