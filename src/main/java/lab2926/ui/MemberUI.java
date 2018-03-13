package lab2926.ui;

import lab2926.controller.EntryController;
import lab2926.controller.MemberController;
import lab2926.model.Entry;
import lab2926.model.Member;
import lab2926.validators.EntryValidator;
import lab2926.validators.MemberValidator;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class MemberUI {
	private MemberController memberController;
	private EntryController entryController;
	
	Scanner in;
	
	public MemberUI(MemberController memberController,EntryController entryController)
	{
		this.entryController=entryController;
		this.memberController=memberController;
		this.in=new Scanner(System.in);
	}
	
	public MemberController getMemberCtrl()
	{
		return this.memberController;
	}
	
	public EntryController getEntrytrl()
	{
		return this.entryController;
	}
	
	public Scanner getIn()
	{
		return this.in;
	}
	
	public void setMemberCtrl(MemberController newCtrl)
	{
		this.memberController=newCtrl;
	}
	
	public void setEntryCtrl(EntryController newCtrl)
	{
		this.entryController=newCtrl;
	}
	
	public void setIn(Scanner newIn)
	{
		this.in=newIn;
	}
	
	public void printMenu()
	{
		String menu;
		menu="Budget Admin Menu: \n";
		menu +="\t 1 - to add a new member; \n";
		menu +="\t 2 - to add a new income/cost; \n";
		menu +="\t 3 - to list the current income/cost; \n";
		menu +="\t 0 - exit \n";
		
		System.out.println(menu);
	}
	
	String getString(String message){
		System.out.print(message);
		
		String input = in.next().trim();
		while(input.isEmpty()) {
			System.out.print("\n\n\nPlease enter a valid stringn"+message);
			in.nextLine();
			input=in.next().trim();
		}
		
		return input;
	}
	
	int getInt(String message) throws RuntimeException{
		System.out.print(message);
		int res=0;
		Boolean err=true;
		while(err)
		{
			try {
				res=in.nextInt();
				err=false;
			}catch(InputMismatchException ex) {
				System.out.println("\nPlease enter a valid number");
				System.out.print(message);
				in.nextLine();
			}
		}
		return res;
	}
	
	void printErrorStack(Exception ex) {
		System.out.println(ex.getMessage());
		if(ex.getCause()!=null)
			if(ex.getCause() instanceof Exception)
			printErrorStack((Exception)ex.getCause());
	}
	
	
	void addMember() {
		while(true) {
			try {
				String name = MemberValidator.validateName(getString("Enter name:"));
				int id = getInt("Enter id:");	
				Member aMemebr = new Member(name,id);
				memberController.addMember(aMemebr);

				System.out.println("Member added");
				return;
			}catch(Exception ex) {
				printErrorStack(ex);
			}
		}
	}
	
	void addEntry() {
		while(true) {
			try {
				Entry.TypeEntry type= EntryValidator.validateTypeEntry(getString("Enter type:"));
				int value=EntryValidator.validateBudget(getInt("Enter the value:"));
				int id = getInt("Enter the id of the member:");
				if(!memberController.userExists(id))
					throw new Exception("User does not exist");
				Entry e= new Entry(type, value, id);			
				entryController.addEntry(e);

				System.out.println("Entry added");
				return;
			}catch(Exception ex) {
				printErrorStack(ex);
			}
		}
	}
	
	public void listForMember() {
		while(true) {
			try {
				int id = getInt("Enter id:");	
				if(!memberController.userExists(id))
					throw new Exception("User does not exist");
				List<Entry> entries=entryController.getEntriesForMember(id);
				if(entries.isEmpty())
				{
					System.out.println("No entries");
				}else {
					for(Entry e : entries)
						System.out.println(e.getType().name()+":"+e.getValue());
				}
				return;
			}catch(Exception ex) {
				printErrorStack(ex);
			}
		}
	}
	
	Boolean save() {
		try {
			entryController.saveData();
			memberController.saveData();
			return true;
		}catch(Exception ex) {
			printErrorStack(ex);
		}
		return false;
	}
	
	void load() {
		while(true) {
			try {
				entryController.loadData();
				memberController.loadData();
				return;
			}catch(Exception ex) {
				printErrorStack(ex);
				if(getString("Try again?(default is yes) Yes/No").compareToIgnoreCase("no")==0)
					return;
			}
		}
	}
	
	public void Run()
	{
		load();
		
		printMenu();
		int cmd=getInt(">");
		
		while(true)
		{
			if(cmd==0) {
				if(save())
					return;
			}
			if(cmd==1)
			{							
				addMember();	
				
			}
			if(cmd==2)
			{
				addEntry();
			}
			if(cmd==3)
			{
				listForMember();			
			}

			printMenu();
			cmd=getInt(">");
		}
		
		
	}
}

