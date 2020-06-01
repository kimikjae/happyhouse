package com.ssafy.happyhouse.model.dto;
public class Pair{
    private int x,y;

    public int getX() {
       return x;
    }

    public void setX(int x) {
       this.x = x;
    }

    public int getY() {
       return y;
    }

    public void setY(int y) {
       this.y = y;
    }

    @Override
    public String toString() {
       return "Pair [x=" + x + ", y=" + y + "]";
    }
 }
