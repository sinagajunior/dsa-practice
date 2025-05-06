package com.oracle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author RoySinaga
 * @created 07/05/2025 - 4:16
 * @project algorithm
 */
public class ClimbingRock {

    static class Point{
        int row,col,steps;
        Point(int r,int c, int s){
            row = r;
            col= c;
            steps =s;
        }
    }


    public static int climbingRock(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<Point> queue = new LinkedList<>();

        // Find the start position (value 2)
        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                if(grid[i][j]==2){
                    queue.add(new Point(i,j,0));
                    visited[i][j]= true;
                }
            }
        }

        // directions: up, down, left ,right :this still be question mark why we need using this direction ?
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!queue.isEmpty()){
            Point current = queue.poll();
            if(grid[current.row][current.col]==3){
                return current.steps;
            }
            for(int d=0; d < 4; d++){
                int newRow = current.row + dr[d];
                int newCol = current.col + dc[d];
            if (newRow >= 0 && newRow < rows && newCol >=0 && newCol < cols &&
                    !visited[newRow][newCol] && (grid[newRow][newCol]==1 || grid[newRow][newCol] == 3)){
                visited[newRow][newCol] = true;
                queue.add(new Point(newRow,newCol, current.steps + 1));
              }

            }
        }

        return -1; // Goal no reachable

    }

   public static void main(String[] args){

       try {
           Scanner sc = new Scanner(new File("input.txt"));

           // Read dimensions
           int height = sc.nextInt();
           int width =  sc.nextInt();
           sc.nextLine(); // consume remaining newLine

           int[][] grid = new int[height][width];

           for(int i=0; i < height; i++){
               String line= sc.nextLine().trim();
               String[] tokens = line.split("\\s+");
               for(int j =0; j< width; j++){
                   grid[i][j] = Integer.parseInt(tokens[j]);
               }
           }
           int difficulty = climbingRock(grid);
           System.out.println("Difficulty Level :" + difficulty);

       } catch (FileNotFoundException e) {
           System.out.println("File not found");
       }
       catch (Exception e){
           System.out.println("Invalid input format :"+ e.getMessage());
       }
   }
}
