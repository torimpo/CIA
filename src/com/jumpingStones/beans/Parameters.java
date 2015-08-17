package com.jumpingStones.beans;

import java.util.ArrayList;
import java.util.List;

import com.jumpingStones.rules.Rules;

/**
 * 
 * Class that simulates the game.
 * table: draws the table.
 * rules: All the possible movements for each token.
 * moves: Moves done at the moment.
 * iteration: Number of iteration.
 *
 */
public class Parameters {

	private boolean[][]table;
	private Rules rule;
	private List<Movement>moves;
	private Integer iteration;
	
	public Parameters(){
	}
	public Parameters(Parameters parameters){
		table = parameters.getTable().clone();
		rule = parameters.getRule().clone();
		moves = new ArrayList<Movement>(parameters.getMoves());
		iteration = parameters.getIteration();
	}
	
	public Parameters(boolean[][]table, Rules rule, List<Movement> moves){
		this.table = table;
		this.rule = rule;
		this.moves = moves;
	}
	
	public boolean[][] getTable() {
		return table;
	}
	public void setTable(boolean[][] table) {
		this.table = table;
	}
	public Rules getRule() {
		return rule;
	}
	public void setRule(Rules rule) {
		this.rule = rule;
	}
	public List<Movement> getMoves() {
		return moves;
	}
	public void setMoves(List<Movement> moves) {
		this.moves = moves;
	}
	public Integer getIteration() {
		return iteration;
	}
	public void setIteration(Integer iteration) {
		this.iteration = iteration;
	}
	public void addIteration(){
		this.iteration+=1;
	}
	
	public Parameters clone(){
		Parameters tmp = new Parameters();
		tmp.setTable(this.table.clone());
		tmp.setRule(this.rule.clone());
		tmp.setMoves(new ArrayList<Movement>(this.moves));
		tmp.setIteration(new Integer(this.iteration.intValue()));
		return tmp;
	}
}
