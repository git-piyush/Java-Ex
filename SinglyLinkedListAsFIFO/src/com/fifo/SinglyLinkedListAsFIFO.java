package com.fifo;

public class SinglyLinkedListAsFIFO {

	Node front = null;
	Node rear = null;

	public void enqueue(int key) {
		
		Node newNode = new Node(key);
		
		if(front==null) {
			newNode.next = null;
			front = newNode;
			rear = newNode;
			return;
		}
		
		rear.next = newNode;
		rear = newNode;
		newNode.next = null;
		return;
	}

	public void dequeue() {
		
		if(front.next == null) {
			front = null;
			rear = null;
			return;
		}
		front = front.next;
		return;
	}

	public void display() {
		
		Node last = front;
		
		if(front==null) {
			System.out.println("Empty Queue");
		}
		
		while(last!=null) {
			System.out.println(last.data);
			last = last.next;
		}
		
	}

	public static void main(String[] args) {
		
		SinglyLinkedListAsFIFO sll = new SinglyLinkedListAsFIFO();
		
		sll.enqueue(10);
		sll.enqueue(20);
		sll.enqueue(30);
		sll.enqueue(40);
		
		sll.display();
		System.out.println();
		sll.dequeue();
		sll.display();


	}

}
