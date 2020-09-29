import java.util.Random;
public abstract class Primate extends Animal{

	public Primate(String name, String noise, String type){
		super(name, noise, type);
	}

	public void eat(){
		Random random = new Random();
		int roll = random.nextInt(10);
		if(roll <= 2){
			System.out.println(this.name+" has refused to eat!");
			this.sleep();
		}
		else if(roll <= 5 && roll >= 3){
			System.out.println(this.name+" has refused to eat!");
			this.makeNoise();
		}
		else{
			this.eat();
		}
	}
}
