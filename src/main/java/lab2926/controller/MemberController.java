package lab2926.controller;


import lab2926.exceptions.ControllerException;
import lab2926.exceptions.RepositoryException;
import lab2926.model.Member;
import lab2926.repository.MemberRepository;

public class MemberController {
	
    private MemberRepository mr;
    
    public MemberController(MemberRepository newMr){    	
    	this.mr = newMr;    	
    }
    
    public void loadData() throws ControllerException {
    	try {
			this.mr.readData();
		} catch (RepositoryException ex) {
			throw new ControllerException("Error loading data",ex);
		}
    }
    
    public void saveData() throws ControllerException{
    	try {
    		this.mr.writeAllData();
    	}catch(RepositoryException ex) {
    		throw new ControllerException("Error saving data", ex);
    	}
    }
    
    public Boolean userExists(int id) {
    	return this.mr.userExists(id);
    }
    
    public void addMember(Member aMemebr) throws ControllerException {
    	try {
    		mr.addMember(aMemebr);
    	}catch(RepositoryException ex) {
    		throw new ControllerException("Error on adding member", ex);
    	}
    }

} 