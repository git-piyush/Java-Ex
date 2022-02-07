package com.sll;

public class SinglyLinkedList {
	
	Node head = null;
	Node tail = null;
	
	public void push(int data) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			System.out.println("test");
			newNode.next = null;
			head = newNode;
			tail = newNode;
		}else {
			newNode.next = null;
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void display() {
		Node last = head;
		
		if (head == null) {
			System.out.println("LinkedList is empty");
			return;
		}
		
		while(last!=null) {
			System.out.println(last.data);
			last = last.next;
		}
		
	}

	public static void main(String[] args) {
		
		SinglyLinkedList sll = new SinglyLinkedList();
		
		sll.push(10);
		sll.push(20);
		
		sll.display();
		
	}

}
