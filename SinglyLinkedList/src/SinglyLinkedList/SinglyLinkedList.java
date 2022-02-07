package SinglyLinkedList;

public class SinglyLinkedList {

	public Node start = null;
	public Node end = null;

	public void addNode(Object data) {

		//System.out.println("hello");
		Node newNode = new Node(data);

		if (start == null) {
			// empty list, create the first node
			// in this case start and end will point to the same node node
			start = newNode;
			end = newNode;
		} else {
			// Addr of New node need to be linked at the end of existing LList
			end.addr = newNode;

			// and then end will become new node
			end = newNode;

		}

	}

	public void display() {

		Node currentNode = start;

		if (start == null) {
			System.out.println("LinkedList is empty");
			return;
		}

		while (currentNode != null) {

			System.out.print(currentNode.data + " ");
			currentNode = currentNode.addr;
		}

	}

	public void cloneLinkedList() {
		Node currentNode = start;
		
		start = null;
		end = null;
		
		while (currentNode != null) {
			addNode(currentNode.data);
			currentNode = currentNode.addr;
		}
		System.out.println("Calling Display method from inside cloneLinkedList");
		display();
	}

	public static void main(String[] args) {

		SinglyLinkedList list = new SinglyLinkedList();

		list.addNode(1);
		list.addNode("chemistry");
		list.addNode(3);
		list.addNode(new Student("Ram", 25));
		list.addNode(15);

		list.display();
		list.cloneLinkedList();

	}

}
