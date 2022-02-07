package com.sll;

public class SinglyLinkedList {

	Node head = null;
	Node tail = null;

	public void push(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			System.out.println("test");
			newNode.next = null;
			head = newNode;
			tail = newNode;
		} else {
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

		while (last != null) {
			System.out.println(last.data);
			last = last.next;
		}

	}

	public int findElement(int element) {
		Node last = head;
		int elePosition = 0;
		int res;
		if (head == null) {
			System.out.println("LinkedList is empty");
			res = -1;
			return res;
		}

		while (last != null) {
			elePosition++;
			if (last.data == element) {
				System.out.println("Found");
				res = elePosition;
				return res;
			}
			last = last.next;

		}
		return -1;

	}

	public void findAndDeleteElement(int element) {
		Node last = head;
		if (head == null) {
			System.out.println("LinkedList is empty");
		}

		if (last.next == null) {
			System.out.println("Only one element present in Linked List");
			if (last.data == element) {
				head = null;
				tail = null;
			} else {
				System.out.println("first data");
				return;
			}

		}

		while (last.next != null) {
			if (last.data == element) {		//condition for first element
				head = last.next;
				return;
			}else if(last.next.next==null){  //condition for last element
				if(last.next.data == element) {
					System.out.println("Its last element that need to be deleted");
					last.next = null;
					tail = last.next;
				}
				return;
			}else if (last.next.data == element) {
				System.out.println("test1");
				last.next = last.next.next;
				return;
			}
			last = last.next;

		}

	}

	public static void main(String[] args) {

		SinglyLinkedList sll = new SinglyLinkedList();

		sll.push(10);
		sll.push(20);
		sll.push(30);
		sll.push(40);
		sll.push(50);
		sll.push(60);
		sll.push(70);
		sll.push(80);
		// sll.display();
		// int res = sll.findElement(55);
		sll.findAndDeleteElement(90);
		sll.display();

	}

}
