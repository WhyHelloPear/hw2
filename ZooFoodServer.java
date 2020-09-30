public class ZooFoodServer extends ZooEmployee{
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
		announcer.update_server();
	}

  public void makeFood(){
    System.out.println("ZooFoodServer is making food.");
  }

  public void serveFood(){
    this.setState("serve food");
    System.out.println("ZooFoodServer is serving food.");
  }

  public void clean(){
    System.out.println("ZooFoodServer is cleaning.");
  }


}
