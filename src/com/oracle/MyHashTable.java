package com.oracle;

/**
 * @author RoySinaga
 * @created 04/05/2025 - 15:24
 * @project algorithm
 */
public class MyHashTable {

    private int size =7;
    private Node[] datamap;

  class Node {
        private String key;
        private int value;
        private Node next;
   Node (String key, int value) {
      this.key = key;
      this.value = value;
  }

 }

   public MyHashTable() {
      datamap = new Node[size];
   }


   private int hash(String key){
      int hash =0;
      char[] keyChars = key.toCharArray();
      for(int i = 0; i < keyChars.length;i++){
          int asciiValues = keyChars[i];
          hash = (hash + asciiValues * 23) % datamap.length;
      }
      return  hash;
   }

   public int get(String key){
      int index = hash(key);
      Node temp = datamap[index];
      while(temp !=null){
          if(temp.key == key) return  temp.value;
          temp = temp.next;
      }
      return 0;
   }




   public void set(String key, int value){
      int index = hash(key);
      Node newNode = new Node(key,value);
      if(datamap[index]==null) {
          datamap[index] = newNode;
      }else {
             Node temp = datamap[index];
             while(temp.next!=null){
                 temp = temp.next;
          }
             temp.next = newNode;
      }



   }


   public void prinntTable(){
      for (int i=0; i< datamap.length;i++){
          System.out.println(i+":");
          Node temp = datamap[i];
          while (temp != null){
              System.out.println(" { "+temp.key+ "= "+temp.value +" }");
              temp = temp.next;

          }
      }


   }


}
