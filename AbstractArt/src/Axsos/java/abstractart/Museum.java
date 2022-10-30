package Axsos.java.abstractart;

import java.util.ArrayList;

public class Museum {
	Painting red = new Painting();
	Sculpture grailf=new Sculpture();
	
	public static void main(String[] args) {
        // TODO: create paintings and sculptures here
		Painting tree = new Painting("tree","Watercolor");
		Painting wall = new Painting("wall of jerausalem","oil");
		Painting tower = new Painting("burj Kaliefa","Acrylic");
		Sculpture ibrhim=new Sculpture("Ibrahim","Bronze");
		Sculpture ibnfernace=new Sculpture("abn Fernaces","Marble");


		ArrayList<Art> musem = new ArrayList<Art>();
		musem.add(tree);
		musem.add(wall);
		musem.add(tower);
		musem.add(ibrhim);
		musem.add(ibnfernace);
		
		for(Art item:musem) {
			item.viewArt();
		}
    }

}
