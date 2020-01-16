package com.tamasleung.wordsearch.utils;

public enum Direction {

    Up(0,-1),
    UpRight(1,-1),
    Right(1,0),
    DownRight(1,1),
    Down(0,1),
    DownLeft(-1,1),
    Left(-1,0),
    UpLeft(-1,-1);

    private int xDir;
    private int yDir;

    public int getxDir() { return xDir; }
    public int getyDir() { return yDir; }

    Direction(int xDir, int yDir){
        this.xDir = xDir;
        this.yDir = yDir;
    }

    public Direction getNextDirection(){
        return Direction.values()[(this.ordinal() + 1) % Direction.values().length];

    }



}

