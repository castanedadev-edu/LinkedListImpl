import java.util.NoSuchElementException;

// Complete the implementation of your MyLinkedList class in this file

public class MyLinkedList implements MyList {
	// Implement the required fields and methods here
	private int size = 0; // increment as number of nodes goes up
	private Node head = null; // represents 1st object in the list

	public void append(Object o) {
		Node newNode = new Node();
		newNode.data = o; // set value
		newNode.next = null; // set pointer

		if (head == null) {
			head = newNode;
		} else if (head.next == null) {
			head.next = newNode;
		} else {

			Node lastNode = head.next;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			} 

			lastNode.next = newNode;
		}
		
		size += 1;
	}

	public void insertAt(int index, Object o) throws NoSuchElementException {
		if (index < 0 || index > size) {
			throw new NoSuchElementException();
		}

		Node previousNode = head;
		
		int i = 0;
		while(previousNode.next != null) {
			Node nextNode = previousNode.next;

			if(index == i && nextNode != null) {
				Node newNode = new Node();
				newNode.data = o;

				// Reorganize pointers between node
				previousNode.next = newNode;
				newNode.next = nextNode;
			}

			previousNode = nextNode;
			i++;
		}
	
		size += 1;
	}

	public void removeAt(int index) throws NoSuchElementException {

	}

	public Object getAt(int index) throws NoSuchElementException {
		return new Object();
	}

	public int getSize() {
		return size;
	}

	public void print() {
		MyListIterator it = this.getIterator();
		System.out.print("MyLinkedList => [");

		while(it.hasNext()) {
			Object actual = it.next();
			System.out.printf("%d",actual);

			if (it.hasNext()) {
				System.out.print(" ,");
			}
		}
		System.out.print(']');
		System.out.printf("\nSize %d\n", size);
	}

	// Do not alter the code below

	public MyListIterator getIterator() {
		return new MyLinkedListIterator();
	}

	private class MyLinkedListIterator implements MyListIterator {
		Node currentNode = null;

		@Override
		public Object next() {
			if (currentNode != null)
				currentNode = currentNode.next;
			else
				currentNode = head;

			return currentNode.data;
		}

		@Override
		public boolean hasNext() {
			if (currentNode != null)
				return currentNode.next != null;
			else
				return head != null;
		}
	}

	class Node {
		public Object data = null;
		public Node next = null;
	}
}