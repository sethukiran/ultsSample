package com.example.ultsDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UltsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UltsDemoApplication.class, args);

		//Example 1
//	int[][] input = {{1, 1, 0, 0},{1, 0, 0, 1},{0, 0, 1, 1},{0, 0, 0, 0}};

		//Example 2
//		int[][] input = {{1, 1, 0, 0},{0, 1, 0, 0},{0, 1, 1, 1},{0, 0, 0, 1}};

		//Example 3
//		int[][] input = {{1, 0, 1, 0},{0, 0, 0, 0},{1, 0, 1, 0},{0, 1, 0, 1}};

		//Example 4
		int[][] input = {{0, 1, 0},{1, 1, 1},{0, 1, 0}};
    System.out.println(countIsLands(input));
	}
	public static int countIsLands(int[][] input){

		if(input == null || input.length == 0){
			return 0;
		}
		int count = 0;
		for(int i =0; i< input.length ; i++){
			for(int j = 0 ; j <input[0].length;j++){
				if(input[i][j] == 1){
					count++;
					recCountIsLands(input,i,j);
				}
			}
		}
		return count;
	}
	public static void recCountIsLands(int[][] input, int row, int col){
		if (row < 0 || row >= input.length || col < 0 || col >= input[0].length || input[row][col] == 0) {
			return;
		}
    input[row][col]=0;
		recCountIsLands(input,row-1,col);
		recCountIsLands(input,row+1,col);
		recCountIsLands(input,row,col-1);
		recCountIsLands(input,row,col+1);
	}
}
