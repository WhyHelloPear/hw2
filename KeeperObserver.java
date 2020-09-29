public class KeeperObserver extends ZooAnnouncer{
	
	public KeeperObserver(ZooKeeper keeper){
		this.keeper = keeper;
		this.keeper.attach(this);
	}

	@Override
	public void update(){
		System.out.println("***Hello, this is the Zoo Announcer!***");
		System.out.println("***The keeper is about to "+keeper.getState()+" the animals!***");
	}
}