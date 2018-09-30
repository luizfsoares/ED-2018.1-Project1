
/**
 * DoublyLinkedList
 */
public class DoublyLinkedList {

  class Node {
    private Node prev;
    private Node next;
    private int value;

    public Node() {
      this.prev = null;
      this.next = null;
      this.value = 0;
    }

    public Node getPrev() {
      return this.prev;
    }

    public void setPrev(Node prev) {
      this.prev = prev;
    }

    public Node getNext() {
      return this.next;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    public int getValue() {
      return this.value;
    }

    public void setValue(int value) {
      this.value = value;
    }

  }

  private Node head;
  private Node tail;
  private int nElements;

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.nElements = 0;
  }

  public boolean isEmpty() {
    return this.nElements == 0;
  }

  public int size() {
    return this.nElements;
  }

  public int getElementAt(int pos) {
    if (isEmpty() || (pos < 1) || (pos > size())) {
      return -1;
    }

    Node aux = this.head;

    for (int i = 1; i < pos; i++) {
      aux = aux.getNext();
    }

    return aux.getValue();
  }

  public int searchByValue(int value) {
    if (isEmpty()) {
      return 0;
    }

    Node aux = this.head;
    for (int i = 1; i <= size(); i++) {
      if (aux.getValue() == value) {
        return i;
      }

      aux = aux.getNext();
    }

    return -1;
  }

  public boolean addListBeginning(int value) {
    Node newNode = new Node();

    newNode.setValue(value);
    newNode.setNext(this.head);
    newNode.setPrev(null);

    if (isEmpty()) {
      this.tail = newNode;
    } else {
      this.head.setPrev(newNode);
    }

    this.head = newNode;
    this.nElements++;

    return true;
  }

  public boolean addListMiddle(int pos, int value) {
    Node newNode = new Node();
    newNode.setValue(value);

    int counter = 1;

    Node aux = this.head;
    while ((counter < (pos - 1)) && (aux != null)) {
      aux = aux.getNext();
    }

    if (aux == null) {
      return false;
    }

    newNode.setPrev(aux);
    newNode.setNext(aux.getNext());
    aux.getNext().setPrev(newNode);
    aux.setNext(newNode);
    this.nElements++;

    return true;  

  }

  public boolean addEndList(int value) {
    Node newNode = new Node();
    newNode.setValue(value);

    Node aux = this.head;
    while (aux.getNext() != null) {
      aux = aux.getNext();
    }

    newNode.setNext(null);
    aux.setNext(newNode);
    newNode.setPrev(this.tail);
    this.tail = newNode;
    this.nElements++;


    return true;
  }

  public boolean add(int pos, int value) {
    if(isEmpty() && (pos != 1)) {
      return false;
    }

    if(pos == 1) {
      return addListBeginning(value);
    } else if(pos == (size() + 1)) {
      return addEndList(value);
    } else {
      return addListMiddle(pos, value);
    }
  }

  private int removeListBeginningUnitary() {
    int value = this.head.getValue();
    this.head = null;
    this.tail = null;
    this.nElements--;
    return value;
  }

  private int removeListBeginning() {
    Node node = this.head;
    int value = node.getValue();

    this.head = node.getNext();
    node.getNext().setPrev(null);
    this.nElements--;

    node = null;
    return value;
  }

  private int removeListEnd() {
    Node node = this.tail;
    int value = node.getValue();

    node.getPrev().setNext(null);
    this.tail = this.tail.getPrev();
    node = null;

    return value;
  }

  private int removeMiddleList(int pos) {
    Node node = this.head;
    int counter = 1;

    while((counter <= (pos -1)) && (node != null)) {
      node = node.getNext();
      counter++;
    }

    if(node == null) {
      return -1;
    }

    int value = node.getValue();
    node.getPrev().setNext(node.getNext());
    node.getNext().setPrev(node.getPrev());
    this.nElements--;
    node = null;
    return value;

  }

  public int remove(int pos) {

    if(isEmpty() || pos < 1 || pos > size()) {
      return 0;
    }

    if((pos == 1) && (size() == 1)) {
      return removeListBeginningUnitary();
    } else if( pos == 1) {
      return removeListBeginning();
    } else if(pos == size()) {
      return removeListEnd();
    } else {
      return removeMiddleList(pos);
    }

  }

}
