import java.util.Random;
import java.util.*;

public class Zoo{


	public static void main(String[] args){

    	Scanner scan= new Scanner(System.in);    //System.in is a standard input stream
		System.out.println("Welcome to The Zoo!");
		System.out.println("Enter the number of days you'd like to simulate:");
		int days = scan.nextInt();
		System.out.println("================================================\n");


		List<RoamBehavior> behaviors = new ArrayList<RoamBehavior>();

		behaviors.add( new SwingRoam() );
		behaviors.add( new NormalRoam() );
		behaviors.add( new LazyRoam() );
		behaviors.add( new SprintRoam() );
		behaviors.add( new SneakRoam() );

		List<Animal> animals = new ArrayList<Animal>();
		/* Each animal object is given an identity - a name. */
		animals.add( new Wolf("Wendy") );
		animals.add( new Wolf("Walter") );
		animals.add( new Dog("Dumbo") );
		animals.add( new Dog("Deborah") );
		animals.add( new Tiger("Terry") );
		animals.add( new Tiger("Tiarra") );
		animals.add( new Lion("Larry") );
		animals.add( new Lion("Lara") );
		animals.add( new Rhino("Randy") );
		animals.add( new Rhino("Rafi") );
		animals.add( new Hippo("Henry") );
		animals.add( new Hippo("Hariett") );
		animals.add( new Elephant("Eddie") );
		animals.add( new Elephant("Edna") );
		animals.add( new Monkey("Mandy") );
		animals.add( new Monkey("Mark") );
		animals.add( new Orangutan("Odie") );
		animals.add( new Orangutan("Oat") );
		animals.add( new Baboon("Bob") );
		animals.add( new Baboon("Billie") );

		// System.out.println(animals.get(0).roam_behavior.roam());

		int length = animals.size();

		for(int i = 0; i < length; i++){
			int min = 1;
			int max = behaviors.size();
			Animal animal = animals.get(i);

			if(animal instanceof Primate){
				min = 0;
				max -= 2;
			}
			if(animal instanceof Pachyderm){
				max -= 1;
			}

			Random random = new Random();
			int roll = random.nextInt(max - min) + min; //random number between max and min

			animal.setBehavior(behaviors.get(roll));
		}

		/* This loop is a good example of polymorphism. currentAnimal can be a Dog,
		Tiger, Cat, etc. But regardless, the wake(), rollCall(), etc. methods can
		be called the same way */

		for(int i = 1; i <= days; i++){
			System.out.println("Day "+i+":");
			ZooKeeper keeper = new ZooKeeper();
			System.out.println("Zookeeper has entered the zoo!");
			for(int j = 0; j < length; j++){
				Animal currentAnimal = animals.get(j);
				keeper.wake(currentAnimal);
				keeper.rollCall(currentAnimal);
				keeper.feed(currentAnimal);
				keeper.exercise(currentAnimal);
				keeper.sleep(currentAnimal);
			}
			keeper = null;
			System.out.println("Zookeeper has left the zoo!\n");
		}
    }
}
