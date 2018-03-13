package lab2926;

import lab2926.controller.EntryController;
import lab2926.controller.MemberController;
import lab2926.repository.EntryRepository;
import lab2926.repository.MemberRepository;
import lab2926.ui.MemberUI;

public class App {
	public static void main(String[] args) {
		
			MemberRepository memberRepository = new MemberRepository();
			EntryRepository entryRepository = new EntryRepository();
		
			MemberController memberController = new MemberController(memberRepository);
			EntryController entryController = new EntryController(entryRepository);
		
			MemberUI console = new MemberUI(memberController,entryController);
			console.Run();
		
	}
}
