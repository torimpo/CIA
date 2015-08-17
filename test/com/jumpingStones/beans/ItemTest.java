package com.jumpingStones.beans;

import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jumpingStones.rules.Rules;

public class ItemTest extends TestCase {
	private static final Logger log = Logger.getLogger(ItemTest.class);
	private ApplicationContext context;
	public void setUp(){
		context = new ClassPathXmlApplicationContext(
		"spring-conf.xml");
	}
	
	public void ntestGetItem(){
		Item item = (Item)context.getBean("d1");
		System.out.println(item);
	}
	
	public void ntestGetTokens(){
		List<Item> list = (List<Item>)context.getBean("tokens");
		
		System.out.println(list);
	}
	
	public void ntestGetMovement(){
		Movement move = (Movement)context.getBean("move_d1f1");
		System.out.println(move);
	}
	
	public void ntestGetRule(){
		Rules rules = (Rules)context.getBean("rules");
		System.out.println(rules);
	}
	
	public void testSmth(){
		Rules rules = (Rules)context.getBean("rules");
		System.out.println(rules.getClass().getName());
	}
}

