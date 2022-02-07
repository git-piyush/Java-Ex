package com.dll;

public class DoublyLinkedList {

	Node head = null;
	Node tail = null;

	public void push(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			newNode.next = null;
			newNode.prev = null;
			head = newNode;
			tail = newNode;
		} else {
			System.out.println("dll is not empty");
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			newNode.prev = null;
			tail = newNode;
		}

	}

	public void append(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			newNode.next = null;
			newNode.prev = null;
			head = newNode;
			tail = newNode;
		}else {
			Node last = head;
			while(last.next != null) {
				last = last.next;
			}
			
			if(last.next == null) {
				System.out.println(last.data);
				last.next = newNode;
				newNode.prev = last;
				newNode.next = null;
				last = newNode;
			}
			
		}
	}


	public void display(Node node) {

		Node last = null;
		System.out.println("Traversal in forward Direction");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		System.out.println();
		System.out.println("Traversal in reverse direction");
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.prev;
		}

	}

	public static void main(String[] args) {

		DoublyLinkedList dll = new DoublyLinkedList();

		dll.push(10);
		dll.push(20);
		dll.push(30);
		dll.push(40);
		dll.push(50);
		dll.push(60);
		dll.append(05);
		dll.append(04);

		dll.display(dll.head);

	}

}
