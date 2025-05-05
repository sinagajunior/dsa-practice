package com.oracle;

/**
 * @author RoySinaga
 * @created 04/05/2025 - 16:49
 * @project algorithm
 */
public class ColumnRotation {

    public static int minOperations(char[][] matrix, String target, int R) {
        int N = matrix.length;
        int M = matrix[0].length;
        int totalOps = 0;

        for (int col = 0; col < M; col++) {
            int minMoves = Integer.MAX_VALUE;

            for (int row = 0; row < N; row++) {
                if (matrix[row][col] == target.charAt(col)) {
                    int down = (row - R + N) % N;
                    int up = (R - row + N) % N;
                    minMoves = Math.min(minMoves, Math.min(up, down));
                }
            }

            if (minMoves == Integer.MAX_VALUE) return -1;

            totalOps += minMoves;
        }

        return totalOps;
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java ColumnRotation N M R matrix_string target_string");
            return;
        }

        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        int R = Integer.parseInt(args[2]);

        if (args.length < 3 + (N * M) + 1) {
            System.out.println("Invalid number of arguments for matrix and target.");
            return;
        }

        // Read matrix from args
        char[][] matrix = new char[N][M];
        int index = 3;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = args[index++].charAt(0);
            }
        }

        // Read target string
        String target = args[index];

        int result = minOperations(matrix, target, R);
        System.out.println("Minimum operations: " + result);
    }
}

//✅ Output:
//        For the example input:
//
//        bash
//        Copy
//        Edit
//        java ColumnRotation 3 3 1 a b c x y z a y c ayc
//        The output will be:
//
//        yaml
//        Copy
//        Edit
//        Minimum operations: 1


//Question is
//    Given a matrix of size N by M , filled with lowercase alphabets .
//    in One operation, you could rotate a column up or down by one.
//        Find minimum number of operation needed to construct a string S at row R . do this solution using java


//✅ Problem Statement (Clarified):
//        You're given:
//
//        A matrix of size N x M filled with lowercase alphabets.
//
//        A string S of length M.
//
//        An integer R (target row index).
//
//        Allowed operation: Rotate a column up or down by one position (circular).
//
//        Your goal: In minimum number of such operations, transform row R into string S.
//
//        💡 Approach:
//        For each column j (from 0 to M-1), we need to find how many up/down rotations are needed to bring S.charAt(j) into the R-th row of that column.
//
//        Since rotations are circular, the cost is the minimum between rotating up and down.
//
//        🔢 Steps:
//        For each column:
//
//        Try each row position in that column.
//
//        If character matches the desired S.charAt(j), calculate the distance from that row to row R (both up and down).
//
//        Take the minimum of those.
//
//        Sum up the minimum operations for all columns.
