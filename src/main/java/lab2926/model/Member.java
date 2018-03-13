package lab2926.model;

public class Member {
	private String name;
	private int id;	
	
	public Member(String name, int id){
		this.name= name;
		this.id=id;
		
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	
	public String toString() {
		String s=this.name + " " + this.id;
		return s;   
	}
}
