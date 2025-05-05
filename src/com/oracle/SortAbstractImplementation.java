package com.oracle;

public abstract class SortAbstractImplementation {


    private int arrayInt[];
    public SortAbstractImplementation(int arraysInt[]){
        this.arrayInt =arraysInt;
        printArray();
    }
    private   void printArray(){
        for(int i=0;i<this.arrayInt.length;i++){
            System.out.println(arrayInt[i]);
        }

    }



}
