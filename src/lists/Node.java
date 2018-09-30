/**
 * Node
 */
public class Node {

	private int value;
	private Node next;

	public Node() {
		this.value = 0;
		this.next = null;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}