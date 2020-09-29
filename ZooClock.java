public class ZooClock{
	private int hour;
	private int time;
	private String period;

	public void newDay(){
		this.hour = 0;
		this.time = 8;
		this.period = "AM";
		System.out.println("The time is currently 8AM");
	}

	public int getHour(){
		return hour;
	}

	public void announceTime(){
		System.out.println("<The time is currently "+this.time+this.period+">");
	}

	public void nextHour(){
		this.hour += 1;
		this.time += 1;
		if(this.time == 13){
			this.time = 1;
			this.period = "PM";
		}
	}

	public Boolean isDay(){
		Boolean value;
		if(this.hour <= 12){
			value = true;
		}
		else{
			value = false;
		}
		return value;
	}

}