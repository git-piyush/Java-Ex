package com.sll;

public class Node {

	int data;
	Node next;
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Node(int data) {
		super();
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
	
}
