package com.oracle;

/**
 * @author RoySinaga
 * @created 04/05/2025 - 17:24
 * @project algorithm
 */
public class DoublyLinkedList {

    class Node {
      private int  value;
      Node next;
      Node prev;

      Node(int value){
          value = value;
      }

    }

    private Node head;
    private Node tail;

    private int length;
  public DoublyLinkedList(int value) {
      Node newNode = new Node(value);
      head = newNode;
      tail = newNode;
      length = 1;
  }

  public void getHead(){
      System.out.println("Head : "+ head.value);
      }

  public void getTail() {
      System.out.println("Tail : "+ tail.value );

  }

  public void getLength(){
      System.out.println("Length : "+ length);
  }

  public void printList(){
      Node temp = head;
      while(temp!=null){
          System.out.println(temp.value);
          temp = temp.next;
      }
  }






}
