package lab2926.repository;

import lab2926.exceptions.RepositoryException;
import lab2926.model.Member;

import java.io.BufferedReader;
import java.io.BufferedWriter;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class MemberRepository {
	private List<Member> members = new ArrayList<Member>();

	private final static String filenameMember = "membersF.txt";

	public MemberRepository() {
	}
	
	public void readData() throws RepositoryException {
		try{
			FileReader fileReaderMember = null;
			BufferedReader bufferedReaderMember = null;
			String currentLineMember = null;
	
			fileReaderMember = new FileReader(filenameMember);
			bufferedReaderMember = new BufferedReader(fileReaderMember);
			
			while ((currentLineMember = bufferedReaderMember.readLine()) != null) {
				if(!currentLineMember.isEmpty())
				{
					String line[] = currentLineMember.split(";");
					Member m = new Member(line[0],Integer.parseInt(line[1]));
					this.members.add(m);	
				}
			}
			bufferedReaderMember.close();
			fileReaderMember.close();
		 }
		catch(FileNotFoundException ex) {
			throw new RepositoryException("Input file not found");
		}
		catch(IOException ex){
			throw new RepositoryException("Error reading from file");
		}
		catch(ArrayIndexOutOfBoundsException| NumberFormatException ex) {
			throw new RepositoryException("Error parsing data from file");
		}
	}
	
	public Boolean userExists(int id) {
		return members.stream().anyMatch(m->m.getId()==id);
	}
	
	public void writeAllData() throws RepositoryException{
		try {
			FileWriter fileWritterMember = new FileWriter(filenameMember,false);
			BufferedWriter bufferedWriterMember = new BufferedWriter(fileWritterMember);
			
			for(Member m : members) {
				bufferedWriterMember.write(m.getName()+";"+String.valueOf(m.getId()));
				bufferedWriterMember.newLine();
			}
			bufferedWriterMember.close();
			fileWritterMember.close();
		}
		catch(IOException ex){
			throw new RepositoryException("Error writing to file",ex);
		}
	}
	
	

	 public void addMember(Member m) throws RepositoryException{
		 if(this.userExists(m.getId()))
				throw new RepositoryException("User already exists");
		 members.add(m);		 	 
	 }
	 
}
