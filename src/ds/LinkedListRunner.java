package ds;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

}

class LinkedListRunner {
	static Node head;

	// Insert at end
	void insert(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;
	}

	// Delete a node by key
	public void delete(int key) {
		Node temp = head;
		Node prev = null;

		// If head node holds the key
		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}

		// Search for the key
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		// Key not found
		if (temp == null)
			return;

		// Unlink node from list
		prev.next = temp.next;
	}

	

	void display() {
		System.out.println(head);
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		LinkedListRunner list = new LinkedListRunner();

		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.display();

		list.delete(10);
		list.display();
		
		
		
	}
}
