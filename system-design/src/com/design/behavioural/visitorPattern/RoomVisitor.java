package com.design.behavioural.visitorPattern;

public interface RoomVisitor {
	public void visit(SingleRoom singleRoom);
	public void visit(DoubleRoom doubleRoom);
	public void visit(DeluxRoom deluxRoom);
}
