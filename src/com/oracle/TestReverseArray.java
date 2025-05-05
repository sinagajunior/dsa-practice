package com.oracle;

public class TestReverseArray {


    public static void main(String[] args){

        int[] intArray = {20,35,-15,7,55,1,-22};

        for(int arrayIndex =intArray.length-1; arrayIndex>0 ;arrayIndex--){
            for(int i =0;i<arrayIndex;i++){
                System.out.println("Luar "+ intArray[arrayIndex]);
                System.out.println("Dalam "+ intArray[i]);
            }

        }




    }


}
