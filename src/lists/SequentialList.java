/**
 * SequentialList
 */
public class SequentialList {
  private int[] data;
  private int nElements;
  private int maxSize;

  public SequentialList() {
    this.maxSize = 100;
    this.data = new int[this.maxSize];
    this.nElements = 0;
  }

  public SequentialList(int tam) {
    this.data = new int[tam];
    this.maxSize = tam;
    this.nElements = 0;
  }

  /**
   * Check if list is full
   */
  public boolean isFull() {
    return this.nElements == this.maxSize;
  }

  /**
   * Check if list is empty.
   */
  public boolean isEmpty() {
    return this.nElements == 0;
  }

  /**
   * Returns the list's size.
   */
  public int size() {
    return this.nElements;
  }

  /**
   * Get the element at a specific position.
   * Return -1 if position is invalid.
   */
  public int getElementAt(int pos) {
    // Invalid position.
    if ((pos > this.nElements) || (pos < 1)) {
      // TODO: Throw exception.
      return -1;
    }
    return this.data[pos - 1];
  }

  /**
   * Search a element in the list.
   * Return -1 if not found.
   */
  public int searchElement(int value) {
    for (int i = 0; i < this.nElements; i++) {
      if (this.data[i] == value) {
        // return pos = index + 1
        return (i + 1);
      }
    }
    // TODO: Throw execption.
    return -1;
  }

  /**
   * Search a element in the list with a position offset.
   * Return -1 if not found.
   */
  public int searchElement(int value, int offset) {
    for (int i = offset + 1; i < this.nElements; i++) {
      if (this.data[i] == value) {
        return (i + 1);
      }
    }
    // TODO: Throw execption.
    return -1;
  }

  /**
   * Insert a element at a specific position.
   * Return false if position is invalid.
   */
  public boolean add(int pos, int value) {
    if (isFull() || (pos > this.nElements + 1) || (pos < 1)) {
      return false;
    }

    /**
     * Offset all elements to insert a new one. Right to left.
     */
    for (int i = this.nElements; i >= pos; i--) {
      this.data[i] = this.data[i - 1];
    }

    // Insert new element at specific position
    this.data[pos - 1] = value;
    this.nElements++; // increment elements' counter

    return true;
  }

  /**
   * Remove a element at a specific position.
   * Return -1 if position is invalid.
   * Return the deleted element.
   */
  public int remove(int pos) {
    int value;
    if ((pos > this.nElements) || (pos < 1)) {
      // TODO: Throw exception.
      return -1;
    }

    // Copy value
    value = this.data[pos - 1];

    // Delete element from list
    for (int i = pos - 1; i < this.nElements - 1; i++) {
      this.data[i] = this.data[i + 1];
    }

    this.nElements--; // Decrement counter

    // return value
    return value;
  }

  /**
   * String representation
   */
  public String toString() {
    String s = "[";
    for (int i = 0; i < this.nElements; i++) {
      s += this.data[i];
      if (i >= 0 && i < (this.nElements - 1)) {
        s += ", ";
      }

    }
    s += "]";

    return s;
  }
}