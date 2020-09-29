public abstract class Animal{
	/* Animal is an abstract class. We should never need an Animal object (other
	than an object that is a subclass of Animal), but we would like to inherit
	from Animal. */


	String name;
	String noise;
	String type;
	Boolean awake;
	RoamBehavior roam_behavior;

	public Animal(String name, String noise, String type){
		this.name = name;
		this.noise = noise;
		this.type = type;
		this.awake = false;
	}

	public void setBehavior(RoamBehavior behavior){
		this.roam_behavior = behavior;
	}

	public void wakeUp(){
		if(!this.awake){
			this.awake = true;
		}
		else{
			System.out.println(this.name + " has fallen asleep!");
		}
	}

	public void makeNoise(){
		System.out.println(this.name+" the "+this.type+" "+this.noise+"ed!");
	}

	public void eat(){
		System.out.println(this.name+" has been fed!");
	}


	// Idea is to change how each animal roams around by
	// implementing an interface for roam and setting a strategy
	// that's appropriate for each animal
	public void roam(){
		String action = this.roam_behavior.roam();
		System.out.println(this.name+" the "+this.type+" "+action);

	}

	public void sleep(){
		if(this.awake){
			this.awake = false;
		}
		else{
			System.out.println(this.name + " has fallen asleep");
		}
	}
}
