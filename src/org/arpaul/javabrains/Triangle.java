package org.arpaul.javabrains;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape  {
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	/**
	 * <bean id="triangle" class="org.arpaul.javabrains.Triangle" name="triangle-name" autowire="byName" scope="prototype">
		
	</bean>
	 * @return
	 */
	/**
	 * Bean scopes and bean contextaware
	 * implements ApplicationContextAware, BeanNameAware
	 * Use private ApplicationContext context;
	 * @Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = context;
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean name: " + beanName);
	}
	 * @return
	 */
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw() {
		System.out.println("Drawing Triangle");
		System.out.println("Point A = (" + getPointA().getX() + ", " + getPointA().getY() + ")");
		System.out.println("Point B = (" + getPointB().getX() + ", " + getPointB().getY() + ")");
		System.out.println("Point C = (" + getPointC().getX() + ", " + getPointC().getY() + ")");
	}
	
	public void myInit() {
		System.out.println("MyInit method called for triangle");
	}
	
	public void cleanup() {
		System.out.println("Mycleanup method called for triangle");
	}

//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("Initializingbean init method called for triangle");
//	}
//
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("Desposablebean destroy method called for triangle");
//	}
	
//	private List<Point> points;
//
//	public List<Point> getPoints() {
//		return points;
//	}
//
//	public void setPoints(List<Point> points) {
//		this.points = points;
//	}
	
	/**
	 * Declaring a list in a bean
	 * <property name="points">
			<list>
				<ref bean="zeroPoint"/>
				<ref bean="point2"/>
				<ref bean="point3"/>
			</list>
		</property>
	 */
//	public void draw() {
//		for(Point point : points) {
//			System.out.println("Point = (" + point.getX() + ", " + point.getY() + ")");
//		}
//	}
//	private Point pointA;
//	private Point pointB;
//	private Point pointC;
//	
//	public Point getPointA() {
//		return pointA;
//	}
//
//	public void setPointA(Point pointA) {
//		this.pointA = pointA;
//	}
//
//	public Point getPointB() {
//		return pointB;
//	}
//
//	public void setPointB(Point pointB) {
//		this.pointB = pointB;
//	}
//
//	public Point getPointC() {
//		return pointC;
//	}
//
//	public void setPointC(Point pointC) {
//		this.pointC = pointC;
//	}

	/**
	 * Spring.xml implementation for alias, name and alternate way of declaring singly used objects in spring.xml
	 * <bean id="triangle" class="org.arpaul.javabrains.Triangle" name="triangle-name">
		<property name="pointA" ref="zeroPoint"/>
		<property name="pointB" >
			<bean class="org.arpaul.javabrains.Point">
				<property name="x" value="-20" />
				<property name="y" value="0" />
			</bean>
		</property>
		<property name="pointC">
			<bean class="org.arpaul.javabrains.Point">
				<property name="x" value="20" />
				<property name="y" value="0" />
			</bean>
		</property>
	</bean>
	
	<bean id="zeroPoint" class="org.arpaul.javabrains.Point">
		<property name="x" value="0" />
		<property name="y" value="0" />
	</bean>
	
	<alias name="triangle" alias="triangle-alias"/>
	 */
	
	/**
	 * Spring.xml implementation for multiple objects
	 * <bean id="zeroPoint" class="org.arpaul.javabrains.Point">
		<property name="x" value="0" />
		<property name="y" value="0" />
	</bean>
	<bean id="point2" class="org.arpaul.javabrains.Point">
		<property name="x" value="-20" />
		<property name="y" value="0" />
	</bean>
	<bean id="point3" class="org.arpaul.javabrains.Point">
		<property name="x" value="20" />
		<property name="y" value="0" />
	</bean>
	 */
//	public void draw() {
//		System.out.println("Point A = (" + getPointA().getX() + ", " + getPointA().getY() + ")");
//		System.out.println("Point B = (" + getPointB().getX() + ", " + getPointB().getY() + ")");
//		System.out.println("Point C = (" + getPointC().getX() + ", " + getPointC().getY() + ")");
//	}
//	private String type;
//	private int height;
//	
//	/**
//	 * Setup in String.xml
//	 * <constructor-arg value="Isoceles" />
//	 * OR
//	 * <constructor-arg type="java.lang.String" value="20" />
//	 * @param type
//	 */
//	public Triangle(String type) {
//		this.type = type;
//	}
//	
//	/**
//	 * Setup in String.xml
//	 * <constructor-arg type="int" value="20" />
//	 * @param height
//	 */
//	public Triangle(int height) {
//		this.height = height;
//	}
//	
//	/**
//	 * Setup in String.xml
//	 * <constructor-arg value="Equilateral" />
//		<constructor-arg value="20" />
//		Order is important
//	 * Or
//	 * <constructor-arg index="1" value="20" />
//		<constructor-arg index="0" value="Isoceles" />
//		Index provides the order
//	 * @param type
//	 * @param height
//	 */
//	public Triangle(String type, int height) {
//		this.type = type;
//		this.height = height;
//	}
//	
//	public int getHeight() {
//		return height;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	/**
//	 * Setup in String.xml
//	 * <property name="type" value="Equilateral" />
//	 * @param type
//	 */
//	public void setType(String type) {
//		this.type = type;
//	}

//	public void draw() {
//		System.out.println(getType() + " Triangle drawn of height " + getHeight());
//	}
}
