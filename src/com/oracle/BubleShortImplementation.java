package com.oracle;

public class BubleShortImplementation {

    public static void main(String[] args) {
	// write your code here
     int[] intarray = {20,35,15,7,55,1,-22};
    for(int lastUnsortedIndex= intarray.length - 1;lastUnsortedIndex>0;lastUnsortedIndex--){
        for(int i=0;i< lastUnsortedIndex;i++){
            if(intarray[i] > intarray[i+1]){
                swap(intarray,i,i+1);
            }
        }
    }

     for (int i=0;i<intarray.length;i++){
         System.out.println(intarray[i]);
     }


    }

    public static void swap(int[] array, int i,int j){
        if(i==j){
            return;
        }
        int temp=array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
