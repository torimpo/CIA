package com.jumpingStones;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jumpingStones.business.GameResolver;
import com.jumpingStones.rules.Rules;

public class Main {
	private static final Logger log = Logger.getLogger(Main.class);
	public static void main(String[] args){
		boolean[][] table;
		table = new boolean[9][9];
/*		table[0]= new boolean[]{false, false, false, false, false, false, false, false, false};
		table[1]= new boolean[]{false, false, false, false, false, false, false, false, false};
		table[2]= new boolean[]{false, false, false, false, true , false, false, false, false};
		table[3]= new boolean[]{false, false, false, false, true , false, false, false, false};
		table[4]= new boolean[]{false, false, true , true , true , true , true , false, false};
		table[5]= new boolean[]{false, false, false, false, true , false, false, false, false};
		table[6]= new boolean[]{false, false, false, false, true , false, false, false, false};
		table[7]= new boolean[]{false, false, false, false, false, false, false, false, false};
		table[8]= new boolean[]{false, false, false, false, false, false, false, false, false};
*/
		table[0]= new boolean[]{false, false, false, false, false, false, false, false, false};
		table[1]= new boolean[]{false, false, false, false, true , false, false, false, false};
		table[2]= new boolean[]{false, false, false, true , true , true , false, false, false};
		table[3]= new boolean[]{false, false, true , true , true , true , true , false, false};
		table[4]= new boolean[]{false, false, false, false, true , false, false, false, false};
		table[5]= new boolean[]{false, false, false, false, true , false, false, false, false};
		table[6]= new boolean[]{false, false, false, true , true , true , false, false, false};
		table[7]= new boolean[]{false, false, false, true , true , true , false, false, false};
		table[8]= new boolean[]{false, false, false, false, false, false, false, false, false};

		log.info("Start Solving...");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-conf.xml");
		Rules rules = (Rules)ctx.getBean("rules");
		GameResolver gameResolver = new GameResolver(table, rules);
		gameResolver.findSolution();
		log.info("Finished");

	}
	
	
}
