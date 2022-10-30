package Axsos.java.abstractart;

public class Sculpture extends Art {
	private String material;
	
	public Sculpture() {
		this.material="Gold";
	}

	public Sculpture(String title,String material) {
		this.title=title;
		this.material=material;
	}

	@Override
	void viewArt() {
		System.out.println("this Sculpture art we made an prototype with matirial type"+this.material);
	}

}
