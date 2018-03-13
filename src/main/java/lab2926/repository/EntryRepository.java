package lab2926.repository;

import lab2926.exceptions.RepositoryException;
import lab2926.model.Entry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class EntryRepository {

	private List<Entry> entries = new ArrayList<Entry>();
	private final static String filenameBudget = "budgetF.txt";
	
	public EntryRepository(){
	}
	
	
	public void readData() throws RepositoryException {
		try{
			FileReader fileReaderEntry = null;
			BufferedReader bufferedReaderEntry = null;
			String currentLineEntry = null;
	
			fileReaderEntry = new FileReader(filenameBudget);
			bufferedReaderEntry = new BufferedReader(fileReaderEntry);
				
			while ((currentLineEntry = bufferedReaderEntry.readLine()) != null) {
				if(!currentLineEntry.isEmpty())
				{
					String line[] = currentLineEntry.split(";");
					Entry.TypeEntry typeEntry = Entry.TypeEntry.valueOf(line[0]);
					int valueEntry = Integer.parseInt(line[1]);
					int idEntryMember = Integer.parseInt(line[2]);
					Entry e = new Entry(typeEntry,valueEntry,idEntryMember);
					this.entries.add(e);	
				}		
			}
			bufferedReaderEntry.close();
			fileReaderEntry.close();
		}
		catch(FileNotFoundException ex) {
			throw new RepositoryException("Input file not found");
		}
		catch(IOException ex){
			throw new RepositoryException("Error reading from file");
		}
		catch(ArrayIndexOutOfBoundsException| IllegalArgumentException ex) {
			throw new RepositoryException("Error parsing data from file");
		}
	}
	
	public void writeAllData() throws RepositoryException{
		try {
			FileWriter fileWritterEntry = new FileWriter(filenameBudget,false);
			BufferedWriter bufferedWriterEntry = new BufferedWriter(fileWritterEntry);
			
			for(Entry e : entries) {
				bufferedWriterEntry.write(e.getType()+";"+String.valueOf(e.getValue())+";"+String.valueOf(e.getIdMember()));
				bufferedWriterEntry.newLine();
			}
			bufferedWriterEntry.close();
			fileWritterEntry.close();
		}
		catch(IOException ex){
			throw new RepositoryException("Error writing to file",ex);
		}
	}
	

	 public void addEntry(Entry e){
		 entries.add(e);		 	 
	 }
	 

	 public List<Entry> getAllEntries(){
		 return entries;
	 }
}
