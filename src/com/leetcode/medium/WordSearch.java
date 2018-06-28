package com.leetcode.medium;

public class WordSearch {
	
	    public boolean exist(char[][] board, String word) {
	        
	        for(int i=0;i<board.length;i++) {
	            for(int j=0;j<board[i].length;j++) {
	                if(word.charAt(0) == board[i][j]) {
	                    boolean [][] found =  new boolean[board.length][board[0].length];
	                   // System.out.println(word+"--"+i+"--"+j);
	                  //  found[i][j] = true;
	                    boolean isFound = search(i, j,board, found, word.substring(0, word.length()));
	                    if(isFound)
	                        return true;
	                }
	                    
	            }
	        }
	        return false;
	    }
	    public boolean search(int i, int j,char[][] board, boolean[][] found, String word) {
	        
	        if(word.length() == 0)
	            return true;
	        if((i>=0 && i<found.length) && (j>=0 && j<found[0].length)) {
	         //   System.out.println(word+' '+i+' '+j+' '+found[i][j]);
	            if(!found[i][j] && word.charAt(0)==board[i][j]) {
	                found[i][j] = true;
	                boolean exist= 
	                    search(i, j+1,board, found, word.substring(1, word.length())) ||
	                    search(i, j-1,board, found, word.substring(1, word.length())) ||
	                    search(i-1, j,board, found, word.substring(1, word.length())) ||
	                        search(i+1, j,board, found, word.substring(1, word.length())) ;
	                if(!exist)   {
	                     found[i][j]=false;
	                    return false;
	                }
	                return exist;
	                
	            }
	           
	                
	        }
	       
	        return false;
	    }
	}
