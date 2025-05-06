package com.oracle;

/**
 * @author RoySinaga
 * @created 06/05/2025 - 12:37
 * @project algorithm
 */
public class ColumnRotationPractice {

    public static int minOperations(char[][] matrix, String target, int R ){
        int N = matrix.length;
        int M =matrix[0].length;
        int totalOPs = 0;

        for(int col=0; col < M;col++){
            int minMoves = Integer.MAX_VALUE;

            for(int row =0; row < N;row++){
                if(matrix[row][col] == target.charAt(col)){
                    int down = (row - R + N) % N;
                    int up = (R - row + N )%N;
                    minMoves = Math.min(minMoves, Math.min(up,down));
                }

            }

            if(minMoves == Integer.MAX_VALUE) return -1;
            totalOPs +=minMoves;


        }

        return  totalOPs;
    }


    public static  void main(String[] args){
        if(args.length < 4){
            System.out.println("Usage: java cplumn rotation N M R matrix_string target _string");
            return;
        }

        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        int R = Integer.parseInt(args[2]);

       if(args.length < 3 +(N * M) + 1){
           System.out.println("Invalid number of arguments for matrix and target");
         return;
        }

        // Read Matrix from args
        char[][] matrix = new char[N][M];
       int index = 3;
       for(int i =0; i < N;i++){
           for(int j =0; j<M;j++){
               matrix[i][j] = args[index++].charAt(0);
           }
       }


        // read target string
        String target = args[index];
       int result = minOperations(matrix, target,R);
        System.out.println("Minimum operations " + result);






    }






}
