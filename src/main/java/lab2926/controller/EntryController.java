package lab2926.controller;

import lab2926.exceptions.ControllerException;
import lab2926.exceptions.RepositoryException;
import lab2926.model.Entry;
import lab2926.repository.EntryRepository;

import java.util.List;
import java.util.stream.Collectors;



public class EntryController {
	private EntryRepository er;
	
	public EntryController(EntryRepository er) {
		this.er=er;
	}
	
	public void loadData() throws ControllerException {
		try {
			this.er.readData();
		} catch (RepositoryException ex) {
			throw new ControllerException("Error loading data",ex);
		}
	}
	
	public void saveData() throws ControllerException{
    	try {
    		this.er.writeAllData();
    	}catch(RepositoryException ex) {
    		throw new ControllerException("Error saving data", ex);
    	}
    }
	
	public void addEntry(Entry entry) {
		this.er.addEntry(entry);
	}
	
	public List<Entry> getEntriesForMember(int id) {
		return this.er.getAllEntries().stream().filter(e->e.getIdMember()==id).collect(Collectors.toList());
	}
}
