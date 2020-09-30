public class ZooKeeper extends ZooEmployee{
	private ZooAnnouncer announcer;
	private String state;

	public String getState(){
		return state;
	}

	public void attach(ZooAnnouncer announcer){
		this.announcer = announcer;
	}

	public void setState(String state){
		this.state = state;
		announcer.update_keeper();
	}

	public void wake(Animal animal){
		if(this.state != "wake up"){
			this.setState("wake up");
		}
		animal.wakeUp();
	}

	public void rollCall(Animal animal){
		if(this.state != "call out"){
			this.setState("call out");
		}
		System.out.println("Calling for "+animal.name+" the "+animal.type);
	}

	public void feed(Animal animal){
		if(this.state != "feed"){
			this.setState("feed");
		}
		animal.eat();
	}

	public void exercise(Animal animal){
		if(this.state != "let out"){
			this.setState("let out");
		}
		animal.roam();
	}

	public void sleep(Animal animal){
		if(this.state != "end the day and put away"){
			this.setState("end the day and put away");
		}
		animal.sleep();
	}
}
