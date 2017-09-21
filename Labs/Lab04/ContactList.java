import java.util.ArrayList;

public class ContactList{
	private ArrayList<Contact> contacts;
	public ContactList(ArrayList<Contact> contacts){
		this.contacts=contacts;
	}
	public ArrayList<Contact> findByFname(String fname){
		ArrayList<Contact> result=new ArrayList<Contact>();
		for(Contact c:contacts){
			if(c.findByFname(fname)){
				result.add(c);
			}
		}
		return result;
	}

	public ArrayList<Contact> findBySname(String sname){
		ArrayList<Contact> result=new ArrayList<Contact>();
		for(Contact c:contacts){
			if(c.findBySname(sname)){
				result.add(c);
			}
		}
		return result;
	}
}