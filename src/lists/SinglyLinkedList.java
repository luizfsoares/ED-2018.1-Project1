
/**
 * SinglyLinkedList
 */
public class SinglyLinkedList {

  private Node head;
  private int nElements;

  public SinglyLinkedList() {
    this.head = null;
    this.nElements = 0;
  }

  public Node getHead() {
    return this.head;
  }

  public void setHead(Node head) {
    this.head = head;
  }

  /**
   * Check if list is empty.
   */
  boolean isEmpty() {
    return this.nElements == 0;
  }

  /**
   * Get list's size.
   */
  public int size() {
    return this.nElements;
    // /* Alternative */
    // Node aux = this.head;

    // int cont = 0;
    // while(aux != null) {
    // aux = aux.getProx();
    // cont++;
    // }

    // return cont;
  }

  /**
   * Get element at a specific position. Return -1 if position is invalid or list
   * is empty
   */
  public int getElementAt(int pos) {
    if ((isEmpty()) || (pos < 1) || (pos > size())) {
      // TODO: Throw exception.
      return -1;
    }

    // Start by the head
    Node aux = this.head;
    // Loop until pos - 1 element
    for (int i = 1; i < pos; i++) {
      aux = aux.getNext();
    }

    return aux.getValue();

  }

  /**
   * Search a value in the list. Return -1 if list is empty or if note found.
   */
  public int searchByValue(int value) {
    int counter = 1;
    Node aux;

    if (isEmpty()) {
      return -1;
    }

    aux = this.head;

    while (aux != null) {
      if (aux.getValue() == value) {
        return counter;
      }

      aux = aux.getNext();
      counter++;
    }

    return -1;
  }

  /**
   * Add new Node at list's beginning. Return True
   */
  private boolean addListBeginning(int value) {
    // Allocate a new Node
    Node newNode = new Node();
    newNode.setValue(value); // set newNode value

    newNode.setNext(this.head); // newNode now points to "old" head
    this.setHead(newNode); // makes newNode the list's head.
    this.nElements++; // increments nElements counter

    return true;
  }

  /**
   * Add new Node at list's ends. Return True
   */
  private boolean addListEnd(int value) {
    // Allocate new Node
    Node newNode = new Node();
    newNode.setValue(value); // Set newNode value
    newNode.setNext(null); // set newNode next node

    // Loop through last element
    Node aux = this.head;
    for (int i = 1; i < size(); i++) {
      aux = aux.getNext();
    }

    // make last element pointer to newNode.
    aux.setNext(newNode);
    this.nElements++; // increments nElements counter

    return true;

  }

  /**
   * Add new Node in the middle of the list. Return true
   */
  private boolean addListMiddle(int pos, int value) {
    // Allocate newNode
    Node newNode = new Node();
    newNode.setValue(value); // Set newNode value

    // Start Loop at the head
    Node aux = this.head;

    // Loop through list until specific position.
    for (int i = 1; i < (pos - 1); i++) {
      aux = aux.getNext();
    }

    // make newNode point to the next.
    newNode.setNext(aux.getNext());
    // make previous node pointer to newNode
    aux.setNext(newNode);
    this.nElements++; // Increments nElements counter

    return true;

  }

  /**
   * Add a new node to the list Return false if invalid position
   */
  public boolean add(int pos, int value) {
    if ((pos < 1) || ((isEmpty() && (pos != 1))) || (pos > (size() + 1))) {
      return false;
    }
    // List's beggining
    if (pos == 1) {
      return addListBeginning(value);
    } else if (pos == (size() + 1)) {
      // List's end
      return addListEnd(value);
    } else {
      // Any position on the list
      return addListMiddle(pos, value);
    }

  }

  private int removeListBeginning() {
    // get list's head
    Node aux = this.head;
    int value = aux.getValue();

    // set list's head to the next element
    this.head = aux.getNext();
    this.nElements--;

    aux = null;

    return value;

  }

  private int removeMiddleList(int pos) {
    // Get list's head
    Node current = null;
    Node previous = null;
    int counter = 1;

    current = this.head;
    for (int i = 1; i < (pos - 1); i++) {
      previous = current;
      current = current.getNext();
    }

    // end of list
    if (current == null) {
      return -1;
    }

    // remove element of list
    int value = current.getValue();
    previous.setNext(current.getNext());
    this.nElements--; // decrement counter

    current = null;
    return value;

  }

  public int remove(int pos) {
    if (isEmpty() || (pos < 1) || (pos > size() + 1)) {
      return -1;
    }

    if (pos == 1) {
      return removeListBeginning();
    } else {
      return removeMiddleList(pos);
    }
  }

  public String toString() {
    String s = "";

    Node aux = this.head;

    int i = 0;
    while (aux != null) {
      System.out.println(++i + "-th element = " + aux.getValue());
      aux = aux.getNext();
    }

    return s;
  }

}