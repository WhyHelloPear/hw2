public class ZooAnnouncer extends ZooEmployee{
	protected ZooKeeper keeper;
	protected ZooFoodServer server;

	/* This is an example of the observer pattern. When the ZooAnnouncer is
	instantiated, it attaches itself to the keeper and foodserver. Then those
	employees can update it with the update_keeper() and update_server() methods.
	*/

	public ZooAnnouncer(ZooKeeper keeper, ZooFoodServer server){
		this.keeper = keeper;
		this.keeper.attach(this);

		this.server = server;
		this.server.attach(this);
	}

	public void update_keeper(){
		System.out.println("***Hello, this is the Zoo Announcer!***");
		System.out.println("***The keeper is about to "+keeper.getState()+" the animals!***");
	}

	public void update_server(){
		System.out.println("***Hello, this is the Zoo Announcer!***");
		System.out.println("***The server is about to "+server.getState()+"!***");
	}
}
