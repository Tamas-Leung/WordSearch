package com.tamasleung.wordsearch.model;

import android.util.Log;

import com.tamasleung.wordsearch.Constants;
import com.tamasleung.wordsearch.utils.Direction;

import java.util.Random;

public class Board {

    private int size;
    private char game_board[][];

    public Board(int size, String[] words) {
        this.game_board = new char[size][size];
        this.size = size;
        for (int i = 0; i < words.length; i++) {
            placeIntoBoard(words[i]);
        }

        instantiateRestOfBoard();
    }

    private void placeIntoBoard(String word) {
        Random random = new Random();
        int x = 0;
        int y = 0;
        boolean complete = false;
        Direction startingDir = getRandomDirection();
        Direction currentDir = startingDir;
        int tries = 0;

        while (true) {
            x = random.nextInt(size - 1);
            y = random.nextInt(size - 1);

            Log.v(Constants.DebugTag, ""+startingDir.ordinal());

            currentDir = startingDir.getNextDirection();
            while(currentDir != startingDir){
                if(checkIfViable(x,y,currentDir,word)){
                    complete = true;
                    break;
                }
                currentDir = currentDir.getNextDirection();
            }

            if(complete) break;
            if(tries++ > 1000) break;
        }
        //TODO Tries change from 1000 to checking all the other available slots.
        
        putIntoBoard(x, y, currentDir, word);
    }

    private boolean checkIfViable(int x, int y, Direction direction, String word){
        if(word.length() <= 0) {
            return true;
        }
        if (x > size - 1 || y > size - 1 || x < 0 || y < 0) {
            return false;
        }

        if(game_board[x][y] == 0 || game_board[x][y] == word.charAt(0)){
            return checkIfViable(x + direction.getxDir(), y + direction.getyDir(), direction, word.substring(1));
        }

        return false;
    }

    private void putIntoBoard(int x, int y, Direction direction, String word){
        if(word.length() <= 0) {
            return;
        }

        game_board[x][y] = word.charAt(0);

        putIntoBoard(x + direction.getxDir(), y + direction.getyDir(), direction, word.substring(1));

    }

    private void instantiateRestOfBoard(){

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (game_board[i][j] == 0) {
                    game_board[i][j] = (char)(random.nextInt(26)+'A');
                }
            }
        }
    }

    public char getCharacter(int x, int y) {
        return game_board[x][y];
    }

    public char[] getBoardAs1DArray(){
        char[] tempBoard = new char[size*size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Log.v("Testing Tag", "Test1: "+ i+ ":" + j+":" + game_board[i][j]);
                tempBoard[i*size+j] = game_board[i][j];
            }
        }
        return tempBoard;
    }

    public char[][] getBoard(){
       return game_board;
    }

    public Direction getRandomDirection(){
        Random random = new Random();
        return Direction.values()[random.nextInt(Direction.values().length - 1)];
    }
}
