package tv;

public class TV {

	private int volume; //0 ~ 100 유지
	private int channel; //1 ~ 255 유지
	private boolean power; //0 ~ 100 유지, 1씩 증감
	
	public TV(int volume, int channel, boolean power) { //1. 생성자 생성
		this.volume = volume;
		this.channel = channel;
		this.power = power;
	}
	
	//setter, getter 생성x
	//내용 출력
	public void status() {
		System.out.println("TV[power=on/off, channel=10, volume=100]"); 
		//true, false가 아닌 on, off로 출력되게
		//channel은 실제 보는 채널
		//volume도 현재 볼륨 
	}
	
	//power는 on off
	
	//볼륨은 2개 메서드 생성
	//하나는 int, 하나는 boolean
	//범위에 맞춰 라운딩 
	
	//채널은 2개 메서드 생성 
	//하나는 int, 하나는 boolean 
	
}
