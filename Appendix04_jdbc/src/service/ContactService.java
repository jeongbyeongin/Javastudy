package service;

public interface ContactService {	// abstract class = interface라고 부르기로했다
	public void addContact();
	public void removeContact();		// delete 
	public void modifyContact();
	public void findContactsByName();
	public void findALLContacts();
}
