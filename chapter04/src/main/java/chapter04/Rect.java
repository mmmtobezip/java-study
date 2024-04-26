package chapter04;

import java.util.Objects;

public class Rect {
	private int w;
	private int h;
	
	public Rect(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	@Override
	public String toString() {
		return "Rect [w=" + w + ", h=" + h + "]";
	}

	//내용 기반의 비교를 위해선 equals() 오버라이딩해줘야 되는데, hashCode()도 함께 진행해야함. -> 내용기반으로 Integer로 변환을 빠르게 하기 위해(비교를 위해 =성능 올리
	@Override
	public int hashCode() {
		return Objects.hash(h*w);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rect other = (Rect) obj;
		//return h == other.h && w == other.w;
		return h*w == other.h * other.w; 
	}

}
