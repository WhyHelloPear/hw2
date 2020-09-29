public class ZooKeeper extends ZooEmployee{

	public void wake(Animal animal){
		animal.wakeUp();
	}

	public void rollCall(Animal animal){
		System.out.println("Calling for "+animal.name+" the "+animal.type);
	}

	public void feed(Animal animal){
		animal.eat();
	}

	public void exercise(Animal animal){
		animal.roam();
	}

	public void sleep(Animal animal){
		animal.sleep();
	}
}