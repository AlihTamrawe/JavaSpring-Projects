package axsos.java.jspdemo;

public class Omikujiclass {
	private String city;
	private String person;
	private String comment;
	private int num;
	private String live;
	private String hobby;

	
	

	public Omikujiclass(String city, String person, String comment, int num, String live,String hobby) {
		this.city = city;
		this.person = person;
		this.comment = comment;
		this.num = num;
		this.live = live;
		this.hobby = hobby;
	}



	public String getHobby() {
		return hobby;
	}



	public void setHobby(String hobby) {
		this.hobby = hobby;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPerson() {
		return person;
	}



	public void setPerson(String person) {
		this.person = person;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getLive() {
		return live;
	}



	public void setLive(String live) {
		this.live = live;
	}
		

}
