
public class LinkedList {
  Node head;

  private class Node {

    int data; // Generic;
    Node nextNode;

    Node(int data) {
      this.data = data;
      this.nextNode = null;
    }

  }

  // --> 5 --> 10 --> 11 --> null
  // 45 --> null
  // 45--> 5 ->

  public void insertStart(int data) {
    Node newNode = new Node(data);
    newNode.nextNode = head;
    head = newNode;
  }

  public void insertEnd(int data) {

    if (head == null) {
      insertStart(data);
      return;
    }

    Node curreNode = head;
    Node newNode = new Node(data);
    while (curreNode.nextNode != null) {
      curreNode = curreNode.nextNode;
    }

    curreNode.nextNode = newNode;

  }

  public void insertBefore(int number, int data) {
    int index = searchIndexByNumber(number);

    if (index == 0) {
      insertStart(data);
      return;
    }

    int count = 0;
    Node currentNode = head;
    Node newNode = new Node(data);
    while (count < index - 1) {
      count++;
      currentNode = currentNode.nextNode;
    }
    newNode.nextNode = currentNode.nextNode;
    currentNode.nextNode = newNode;
  }

  public void Display() {

    if (head == null) {
      return;
    }

    Node currentNode = head;

    while (currentNode != null) {
      System.out.print(currentNode.data + " --> ");
      currentNode = currentNode.nextNode;
    }
    System.out.println("null");
  }

  private int searchIndexByNumber(int data) {
    int index = 0;

    if (head == null || head.nextNode == null) {
      return index;
    }

    Node currentNode = head;

    while (currentNode != null) {

      if (data == currentNode.data) {
        break;
      }
      index++;
      currentNode = currentNode.nextNode;
    }
    return index;
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.insertStart(5);
    list.insertStart(2);
    list.insertStart(100);
    list.insertEnd(25);

    list.insertBefore(5, 20);

    list.Display();
  }
}