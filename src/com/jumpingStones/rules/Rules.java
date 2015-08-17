package com.jumpingStones.rules;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.jumpingStones.beans.Item;
import com.jumpingStones.beans.Movement;

public class Rules {

	private static HashMap<Item, List<Movement>> rules = new HashMap<Item, List<Movement>>();

	public HashMap<Item, List<Movement>> getRules(){
		return rules;
	}
	
	public void setRules(HashMap<Item, List<Movement>> rules){
		this.rules = rules;
	}
	
	public List<Movement> getMovements(Item key){
		return rules.get(key);
	}
	
	public String toString(){
		return rules.toString();
	}
	
	public Collection<Item> getTokens(){
		return rules.keySet();
	}
	
	@Override
	public Rules clone(){
		Rules tmp = new Rules();
		tmp.setRules((HashMap<Item, List<Movement>>)this.getRules().clone());
		return tmp;
	}

}
