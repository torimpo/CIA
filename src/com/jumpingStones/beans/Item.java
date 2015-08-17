package com.jumpingStones.beans;

/**
 * This is a cross grid. 
 *  abcdefghi
 * 1   xxx
 * 2   xxx
 * 3   xxx
 * 4xxxxxxxxx
 * 5xxxx xxxx
 * 6xxxxxxxxx
 * 7   xxx
 * 8   xxx
 * 9   xxx 
 * Defines a token in the grid.
 * name: name of the token (ussually row + col)
 * row: Row where is placed.
 * col: Column where is placed.
 *
 */
public class Item {
	private String name;
	private int row;
	private int col;

	public Item() {

	}

	public Item(String name, int row, int col) {
		this.name = name;
		this.row = row;
		this.col = col;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public Item clone(){
		Item tmp = new Item();
		tmp.setName(new String(this.name));
		tmp.setCol(this.col);
		tmp.setRow(this.row);
		return tmp;
	}

}
