package com.jumpingStones.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import com.jumpingStones.Exception.IlegalMoveException;
import com.jumpingStones.beans.Item;
import com.jumpingStones.beans.Movement;
import com.jumpingStones.rules.Rules;

public class GameResolver {

	private static final Logger log = Logger.getLogger(GameResolver.class);

	private boolean[][] table = null;
	private Rules rules = null;
	private List<Movement> moves = null;

	public GameResolver() {

	}

	public GameResolver(boolean[][] table, Rules rules) {
		this.table = table;
		this.rules = rules;
	}

	public void findSolution() throws NullPointerException {
		if (table == null) {
			throw new NullPointerException("The Table is null");
		}
		if (rules == null) {
			throw new NullPointerException("There are no rules");
		}
		moves = new ArrayList<Movement>();

		solve(0);
	}

	private void solve(int iterations) {

		if (log.isDebugEnabled()) {
			log.debug("iteration: " + iterations);
			log.debug("\nTable: "
					+ ((iterations > 0 && moves.size() > 0) ? moves.get(moves
							.size() - 1) : "") + "\n" + showTable(table));
		}
		if (countTokens(table) == 1) {
			log.info(generateReport(moves, iterations));
			return;
		}
		Collection<Item> tokens = rules.getTokens();
		boolean hasMove = false;
		for (Item token : tokens) {
			if (table[token.getRow()][token.getCol()]) {
				List<Movement> movements = rules.getMovements(token);
				for (Movement movement : movements) {
					if (canMove(table, movement)) {
						moves.add(movement);
						hasMove = true;
						doMove(table, movement);
						solve(++iterations);
					}
				}
			}
		}
		if (!hasMove) {
			log.info("We arrived to a point of end...");
			log.info("Iterations: " + iterations);
			log.info("Number of tokens: " + countTokens(table));
			log.info(moves);
		}

		goBack(table, moves.get(moves.size() - 1));
		moves.remove(moves.size() - 1);
		log.debug("Return from iteration: " + iterations--);
		return;
	}

	private String generateReport(List<Movement> moves, int iteration) {
		return "Succeed!!!!\nNumber of Iterations: " + iteration
				+ "\nMoves:\n " + moves.toString();
	}

	private int countTokens(boolean[][] table) {
		int cant = 0;
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (table[i][j]) {
					cant++;
				}
			}
		}
		return cant;
	}

	private boolean canMove(boolean[][] table, Movement movement) {
		return (table[movement.getFromPosition().getRow()][movement
				.getFromPosition().getCol()]
				&& table[movement.getJumpPosition().getRow()][movement
						.getJumpPosition().getCol()] && !table[movement
				.getToPosition().getRow()][movement.getToPosition().getCol()]);

	}

	private boolean[][] doMove(boolean[][] table, Movement movement) {

		table[movement.getFromPosition().getRow()][movement.getFromPosition()
				.getCol()] = false;
		table[movement.getJumpPosition().getRow()][movement.getJumpPosition()
				.getCol()] = false;
		table[movement.getToPosition().getRow()][movement.getToPosition()
				.getCol()] = true;
		return table;
	}

	private boolean[][] goBack(boolean[][] table, Movement movement) {

		table[movement.getFromPosition().getRow()][movement.getFromPosition()
				.getCol()] = !table[movement.getFromPosition().getRow()][movement
				.getFromPosition().getCol()];
		table[movement.getJumpPosition().getRow()][movement.getJumpPosition()
				.getCol()] = !table[movement.getJumpPosition().getRow()][movement
				.getJumpPosition().getCol()];
		table[movement.getToPosition().getRow()][movement.getToPosition()
				.getCol()] = !table[movement.getToPosition().getRow()][movement
				.getToPosition().getCol()];
		return table;
	}

	private String showTable(boolean[][] table) {
		String s = "";

		s += String
				.format(
						"%1$-7s%2$-7s%3$-7s%4$-7s%5$-7s%6$-7s%7$-7s%8$-7s%9$-7s%10$-7s",
						" ", "a", "b", "c", "d", "e", "f", "g", "h", "i");
		s += "\n";
		for (int i = 0; i < table.length; i++) {
			s += String.format("%1$-3s", i + 1) + ":[";
			for (int j = 0; j < table[i].length; j++) {
				s += String.format("%1$5s", (table[i][j]) ? "  x  " : "  .  ");
			}
			s = s.substring(0, s.length() - 2);
			s += "]\n";
		}
		return s;
	}

	private String showCompleteGame(boolean[][] table, List<Movement> moves)
			throws IlegalMoveException {
		boolean[][] tmp = table;
		String s = "";
		s += "Initial: \n";
		s += showTable(tmp);

		for (Movement move : moves) {
			if (canMove(tmp, move)) {
				tmp = doMove(tmp, move);
				s += "Move: " + move;
				s += showTable(tmp);
			} else {
				throw new IlegalMoveException(move);
			}
		}
		return s;
	}

}
