package Axsos.java.abstractart;

public class Painting extends Art{
	private String paintType;
	Painting(){
		this.title = "kilopatra";
		this.paintType="Oil";
		
	}
	Painting(String title,String paintype){
		this.title = title;
		this.paintType=paintype;
		
	}
	@Override
	void viewArt() {
		System.out.println("the Painting has done by "+this.title+" type"+this.paintType);
		
	}
	public String getPaintType() {
		return paintType;
	}
	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
	

}
