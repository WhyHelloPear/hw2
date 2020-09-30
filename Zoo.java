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
		/* Each behavior object is instantiated and added to a list. */
		behaviors.add( new SwingRoam() );
		behaviors.add( new NormalRoam() );
		behaviors.add( new LazyRoam() );
		behaviors.add( new SprintRoam() );
		behaviors.add( new SneakRoam() );
		int behavior_length = behaviors.size();

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
		int animal_length = animals.size();

		// for loop used to randomly assign animals behaviors based on their animal type
		for(int i = 0; i < animal_length; i++){
			int min = 1;
			int max = behavior_length;
			Animal animal = animals.get(i);

			if(animal instanceof Primate){
				min = 0;
				max -= 2;
			}
			if(animal instanceof Pachyderm){
				max -= 1;
			}

			Random random = new Random();
			int roll = random.nextInt(max - min) + min; //random number between max and min range

			animal.setBehavior(behaviors.get(roll));
		}

		/* This loop is a good example of polymorphism. currentAnimal can be a Dog,
		Tiger, Cat, etc. But regardless, the wake(), rollCall(), etc. methods can
		be called the same way */

		for(int i = 1; i <= days; i++){
			System.out.println("Day "+i+":");

			ZooKeeper keeper = new ZooKeeper();
			System.out.println("Zookeeper has entered the zoo!");
			ZooFoodServer server = new ZooFoodServer();
			System.out.println("ZooFoodServer has entered the zoo!");
			ZooAnnouncer announcer = new ZooAnnouncer(keeper, server);

			ZooClock clock = new ZooClock();
			clock.newDay();

			while(clock.isDay()){
				clock.announceTime();
				int curr_hour = clock.getHour();
				if(curr_hour == 0 || curr_hour == 1 || curr_hour == 3 || curr_hour == 8 || curr_hour == 12){
					for(int j = 0; j < animal_length; j++){
						Animal currentAnimal = animals.get(j);
						switch(curr_hour){
							case 0:
								keeper.wake(currentAnimal);
								break;
							case 1:
								keeper.rollCall(currentAnimal);
								break;
							case 3:
								keeper.feed(currentAnimal);
								break;
							case 8:
								keeper.exercise(currentAnimal);
								break;
							case 12:
								keeper.sleep(currentAnimal);
								break;
						}
					}
				}

				if(curr_hour == 3 || curr_hour == 8){
					server.makeFood();
				}
				else if(curr_hour == 4 || curr_hour == 9){
					server.serveFood();
				}
				else if(curr_hour == 5 || curr_hour == 10){
					server.clean();
				}

				clock.nextHour();
			}
			keeper = null;
			clock = null;
			System.out.println("Zookeeper has left the zoo!");
			System.out.println("ZooFoodServer has left the zoo!");
		}
    }
}
