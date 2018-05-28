package com.jumpingStones.beans;

/**
 * 
 * Defines all the movements that a token can do.
 * fromPositon: Defines where it comes from
 * toPosition: where it can move to
 * jumpPosition: token that is eaten
 *
 */
public class Movement {

	private Item fromPosition;
	private Item toPosition;
	private Item jumpPosition;

	public Movement(){
		
	}
	
	public Movement(Item from, Item jump, Item to){
		this.fromPosition = from;
		this.toPosition = to;
		this.jumpPosition = jump;
	}
	
	public Item getFromPosition() {
		return fromPosition;
	}

	public void setFromPosition(Item fromPosition) {
		this.fromPosition = fromPosition;
	}

	public Item getToPosition() {
		return toPosition;
	}

	public void setToPosition(Item toPosition) {
		this.toPosition = toPosition;
	}

	public Item getJumpPosition() {
		return jumpPosition;
	}

	public void setJumpPosition(Item jumpPosition) {
		this.jumpPosition = jumpPosition;
	}

	@Override
	public String toString() {
		return fromPosition + "--" + jumpPosition + "-->" + toPosition;
	}
	
	@Override
	public Movement clone(){
		Movement tmp = new Movement();
		tmp.setFromPosition(this.fromPosition.clone());
		tmp.setJumpPosition(this.jumpPosition.clone());
		tmp.setToPosition(this.getToPosition().clone());
		return tmp;
	}
}
