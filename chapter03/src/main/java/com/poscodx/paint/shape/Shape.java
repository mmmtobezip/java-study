package com.poscodx.paint.shape;

import com.poscodx.paint.i.Drawable;
import com.posocodx.paint.point.Point;

public abstract class Shape implements Drawable{ //draw()메서드 추상클래스
	Point[] points; 
	String fillColor;
	String lineColor;
//	public abstract void draw(); 인터페이스로 구현
}
