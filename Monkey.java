public class Monkey extends Primate{
  public Monkey(String name){
    super(name, "howl", "monkey");
  }

  public void eat(){
		System.out.println(this.name+" ate a banana!");
	}
}
