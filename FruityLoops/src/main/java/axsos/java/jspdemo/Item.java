package axsos.java.jspdemo;

public class Item {
    
    // MEMBER VARIABLES
    private String name;
    private double price;
    private  int i;
    private static int in=0;

    
    
    // CONSTRUCTOR
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        in++;
        i=in;
        
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public int getindex() {
		return i;
	}
    
    


}