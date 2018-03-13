package lab2926.model;

public class Entry {	
	private int value;
	private TypeEntry typeEntry;//cost or income
	private int idMember;
	
	public enum TypeEntry{
		cost,income
	}
	
	public Entry(TypeEntry typeEntry, int value,int idM){
		this.typeEntry=typeEntry;
		this.value=value;
		this.idMember=idM;
	}
	
	public void setType(TypeEntry newType) {
		typeEntry = newType;
	}
	
	public TypeEntry getType() {
		return typeEntry;
	}

	public void setValue(int newValue) {
		this.value = newValue;
	}

	public int getValue() {
		return value;
	}
	public void setMember(int newMember) {
		this.idMember= newMember;
	}

	public int getIdMember() {
		return idMember;
	}
	public String toString() {
		String e=" idM=" +this.idMember+" " + this.typeEntry.name() + " " + this.value;
		return e;   
	}
	
}
