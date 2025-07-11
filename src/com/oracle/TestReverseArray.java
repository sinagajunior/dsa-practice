package com.oracle;

import java.util.HashSet;
import java.util.Set;

public class TestReverseArray {


    public static void main(String[] args){

        int[] intArray = {20,35,-15,7,55,1,-22};
        //Set<Integer> listSet = new HashSet<>(); 

        for(int arrayIndex =intArray.length-1; arrayIndex>=0 ;arrayIndex--){
            // for(int i =0;i<arrayIndex;i++){
            //    //System.out.println("Luar "+ intArray[arrayIndex]);
            //     //System.out.println("Dalam "+ intArray[i]);
            //     listSet.add(intArray[arrayIndex]);
            // }
            System.out.println(intArray[arrayIndex]);

        }

          // System.out.println(listSet.toString());


    }


}
