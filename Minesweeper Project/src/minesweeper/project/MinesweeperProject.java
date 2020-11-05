/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.project;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Xuehong (That's My Mom :))
 */
public class MinesweeperProject {
    ArrayList<Integer> mineNums;
    int num_mines = 10;
    int rows = 8;
    int cols = 8;
    Random rand = new Random();
    int [][] grid = new int[rows][cols];
    
    
    public MinesweeperProject() {
        // set Arraylist for # of mines
        // set new variable for 0
        // set mine variable to n
        mineNums = new ArrayList<Integer>();
        int numbers = 0;
        while(numbers < num_mines) {
            int n = rand.nextInt(rows*cols);
            if (!mineNums.contains(n)){
                mineNums.add(n);
                numbers++;
            }
        }    
    }
    
    private void setMinesInGrid(){
        // loop through mine numbers
        // set mine values to -1
        for (int i = 0; i< rows; i++){
            for (int j = 0; j< cols; j++){
                if ( mineNums.contains(i*j) )
                    grid[i][j] = -1;
                else
                   grid[i][j] = 0; 
            }
        }
    }
    
    // find adjacent cells to mines and set to proper number 
    private void calculateMinesNumber(){ 
        for (int i = 0; i< rows; i++){ // row
            for (int j = 0; j< cols; j++){ // column
                if ( grid[i][j] != -1 ){   
                    int previousRow = i - 1;
                    int previousCol = j - 1;
                    int nextCol = j + 1;
                    int nextRow = i+1;
                    
                    //check previous & next cells if mine found
                    
                    // check previous row
                    if (previousRow>=0 && previousCol>0 && grid[previousRow][previousCol]==-1 )
                        grid[i][j]++;
                        /*☑ 0 0 
                          0 0 0
                          0 0 0 */
                    
                    if (previousRow>=0 && grid[previousRow][j]==-1 )
                        grid[i][j]++;
                        /*0 ☑ 0 
                          0 0 0
                          0 0 0 */
                    
                   if (previousRow>=0 && nextCol<cols && grid[previousRow][nextCol]==-1 )
                        grid[i][j]++;                    
                        /*0 0 ☑ 
                          0 0 0
                          0 0 0 */
                        
                    //check previous & next cols 
                    if (previousCol>=0 && grid[i][previousCol]==-1 )
                        grid[i][j]++;
                        /*0 0 0 
                          ☑ 0 0
                          0 0 0 */
                        
                    if (nextCol<cols && grid[i][nextCol]==-1 )
                        grid[i][j]++;   
                        /*0 0 0 
                          0 0 ☑
                          0 0 0 */
                       
                    // check next row for adjacent cells
                    if (nextRow < rows && previousCol>=0 && grid[nextRow][previousCol]==-1 )
                        grid[i][j]++;
                        /*0 0 0 
                          0 0 0
                          ☑ 0 0 */
                    
                    if (nextRow < rows && grid[nextRow][j]==-1 )
                        grid[i][j]++;
                        /*0 0 0 
                          0 0 0
                          0 ☑ 0 */
                    
                    if (nextRow < rows  && nextCol<cols && grid[nextRow][nextCol]==-1 )
                        grid[i][j]++;
                        /*0 0 0 
                          0 0 0
                          0 0 ☑ */
                }    
            }
        }
    }
    
    // output the grid
    private void printGrid(){
         for (int i = 0; i< rows; i++){
            for (int j = 0; j< cols; j++){
                System.out.print(grid[i][j]+"  "); 
                // "  " added for space between numbers
            }
            System.out.println();
         }
        System.out.println();
    }

    
    public static void main(String[] args) {
        MinesweeperProject game = new MinesweeperProject();
        game.setMinesInGrid();
        game.printGrid();
        game.calculateMinesNumber();
        game.printGrid();
    }
        
}

