package com.ssafy.happyhouse.model.dto;
public class Trio{
    private int x,y;
    private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

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
		return "Trio [x=" + x + ", y=" + y + ", str=" + str + "]";
	}
 }
