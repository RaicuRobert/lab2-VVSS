package lab2926.validators;


import lab2926.exceptions.InvalidBudgetException;
import lab2926.exceptions.InvalidTypeException;
import lab2926.model.Entry;

public class EntryValidator {
	public static int validateBudget(int budget) throws InvalidBudgetException {
		if(budget<=0)
			throw new InvalidBudgetException("Budget cannot be negative");
		return budget;
	}
	
	public static Entry.TypeEntry validateTypeEntry(String typeEntry) throws InvalidTypeException {
		try {
			return Entry.TypeEntry.valueOf(typeEntry);
		}catch(IllegalArgumentException ex) {
			throw new InvalidTypeException("Type can be only income or cost");
		}
	}
	
}
