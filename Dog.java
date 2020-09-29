import java.util.Random;
public class Dog extends Animal{
  
  public Dog(String name){
    super(name, "bark", "dog");
  }

  public void roam(){
		Random random = new Random();
		int roll = random.nextInt(3);
		if(roll == 0){
			System.out.println(this.name+" has refused to exercise! They chose to dig instead.");
		}
		else{
			System.out.println(this.name+" roams around.");
		}
	}

}
