package tv;

public class TV {

	private int volume; //0 ~ 100
	private int channel; //1 ~ 255
	private boolean power; //1씩 증감
	
	public TV(int volume, int channel, boolean power) { //생성자
		this.volume = volume;
		this.channel = channel;
		this.power = power;
	}
	
	public void status() {
		System.out.println("TV[power=" + (power ? "on" : "off") +
						   ", channel=" + channel +
						   ", volume=" + volume + "]");
	}

	public void power(boolean on) {
		this.power = on;
	}

	public void channel(int channel) {
		if(channel < 1) {
			this.channel = 255;
		} else if(channel > 255) {
			this.channel = 1;
		} else {
			this.channel = channel;
		}
	}

	public void channel(boolean up) {
		if (up) {
			channel(this.channel + 1);
		} else {
			channel(this.channel - 1);
		}
	}

	public void volume(int volume) {
		if(volume < 0) {
			this.volume = 100;
		} else if(volume > 100) {
			this.volume = 0;
		} else {
			this.volume = volume;
		}
	}

	public void volume(boolean up) {
		if(up) {
			volume(this.volume + 1);
		} else {
			volume(this.volume - 1);
		}
	}
}
