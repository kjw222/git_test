package TV;

public class TV {
	private int channel; //1~255
	private int volume;		//0~100
	private boolean power;
	
	public TV(int i, int j, boolean b) {
		this.channel = i;
		this.volume =j;
		this.power=b;
	}

	public void status() {
//		System.out.println( "TV [channel=" + channel + ", volume=" + volume + ", power=" + isPower() + "]");
	}
	
	int getChannel() {
		return channel;
	}
	int getVolume() {
		return volume;
	}

//	String power(boolean b) {
//		this.power=;
//		return power;
//	}

	void volume(boolean b) {
		if(this.getVolume()<=100 &&this.getVolume()>=1) {
			if(b==true) {
			this.volume=100;
			}
			else {this.volume=0;}
		}else;
	}

	void channel(boolean b) {
		if(this.getChannel()<=255 &&this.getChannel()>=1) {
			if(b==true) {
			this.channel=255;
			}
			else {this.channel=0;}
		}else;
		
	}
	
	void isPower() {
		if(this.power==true) {System.out.println("on");}	
		else{System.out.println("off");}	
	}

	void volume(int b) {
		if(this.getVolume()<=100 &&this.getVolume()>=1) {
			if(b<=100  && b>=1) {
			this.volume=100;
			}
//			else if;
		}else;
	}

	void channel(int b) {
		if(this.getChannel()<=255 &&this.getChannel()>=1) {
			if(b<=255 && b>=1) {
			this.channel=b;
			}
			else;
		}else;
	}


}
