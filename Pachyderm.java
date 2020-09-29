import java.util.Random;
public abstract class Pachyderm extends Animal{

	public Pachyderm(String name, String noise, String type){
		super(name,noise,type);
	}

	/*
	This method provides a good example of abstraction. A pachyderm object
	just had the method roam(). The inner workings (deciding wether the animal
	charges or not) are abstracted away.
	*/
	public void roam(){
		Random random = new Random();
		int roll = random.nextInt(3);
		if(roll == 0){
			System.out.println(this.name+" has refused to exercise! They charge at you instead!");
		}
		else{
			System.out.println(this.name+" roams around.");
		}
	}
}
