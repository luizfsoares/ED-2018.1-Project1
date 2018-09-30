// 1119 - A Fila de Desempregados - LDE

import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    while (true) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int m = sc.nextInt();

      if (n == 0 && k == 0 && m == 0) {
        break;
      }

      DoublyLinkedList list = new DoublyLinkedList();

      for (int i = 1; i <= n; i++) {
        list.add(i, i);
      }

      int counter = 0;
      int removeRight = n;
      int removeLeft = n + 1;

      while (counter < list.size()) {
        int kValue = k;
        int mValue = m;

        // go right
        while (kValue > 0) {
          removeRight++;
          if (removeRight > list.size()) {
            removeRight = removeRight % list.size();
          }
          
          while (list.getElementAt(removeRight) == 0) {
            removeRight++;
            
            if (removeRight > list.size()) {
              removeRight = removeRight % list.size();
            }
          }
          if(removeRight == 0) {
            removeRight = 1;
          }
          kValue--;
        }

        while (mValue > 0) {
          removeLeft--;
          if(removeLeft == 0) {
            removeLeft = n;
          }
          if (removeLeft < 0) {
            removeLeft = (removeLeft) % (list.size() + 1);
          }
          while (list.getElementAt(removeLeft) == 0) {
            removeLeft--;

            if(removeLeft == 0) {
              removeLeft = n;
            }

            if (removeLeft < 0) {
              removeLeft = (removeLeft) % (list.size() + 1);
            }
          }
          mValue--;
        }

        System.out.printf("%3d", removeRight);
        counter++;

        if (removeRight != removeLeft) {
          System.out.printf("%3d", removeLeft);
          counter++;
        }
        list.setValueAt(removeRight, 0);
        list.setValueAt(removeLeft, 0);

        if (counter < list.size()) {
          System.out.printf(",");
        }

      }
      System.out.println();

    }

  }
}

class DoublyLinkedList {

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

  public boolean setValueAt(int pos, int value) {
    if (isEmpty() || (pos < 1) || (pos > size())) {
      return false;
    }

    Node aux = this.head;

    for (int i = 1; i < pos; i++) {
      aux = aux.getNext();
    }

    aux.setValue(value);

    return true;
  }

  public Node getNodeAt(int pos) {
    if (isEmpty() || (pos < 1) || (pos > size())) {
      return null;
    }

    Node aux = this.head;

    for (int i = 1; i < pos; i++) {
      aux = aux.getNext();
    }

    return aux;
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

  public boolean addListBeginning(int value) {
    Node newNode = new Node();

    newNode.setValue(value);

    if (isEmpty()) {
      newNode.setNext(null);
      newNode.setPrev(null);
      this.head = newNode;
      this.tail = newNode;

    } else {
      newNode.setNext(this.head);
      newNode.setPrev(this.tail);
      this.tail.setNext(newNode);
      this.head.setPrev(newNode);
      this.head = newNode;
    }

    this.nElements++;
    return true;
  }

  public boolean addEndList(int value) {
    Node newNode = new Node();
    newNode.setValue(value);

    newNode.setNext(this.head);
    newNode.setPrev(this.tail);
    this.tail.setNext(newNode);
    this.head.setPrev(newNode);
    this.tail = newNode;

    this.nElements++;

    return true;
  }

  public boolean add(int pos, int value) {
    if (isEmpty() && (pos != 1)) {
      return false;
    }

    if (pos == 1) {
      return addListBeginning(value);
    } else {
      return addEndList(value);
    }
  }

  public String toString() {
    String s = "";
    for (int i = 1; i <= size(); i++) {
      s += getElementAt(i) + " -> ";
    }

    return s;
  }

}