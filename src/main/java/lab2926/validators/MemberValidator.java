package lab2926.validators;


import lab2926.exceptions.InvalidNameException;

public class MemberValidator {
	public static String validateName(String name) throws InvalidNameException {
		name=name.trim();
		if(!name.matches("[a-zA-Z]+"))
			throw new InvalidNameException("Name must contain only letters");
		if(name.isEmpty())
			throw new InvalidNameException("Name must contain at least one letter");
		return name;
	}
}
