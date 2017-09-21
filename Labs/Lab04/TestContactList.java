import java.util.ArrayList;

public class TestContactList{
	public static void main(String[] args) throws Exception{

		ReadCsv readCsv=new ReadCsv("contacts.csv");
		ContactList contactList=new ContactList(readCsv.getData());

		if(args[0].substring(0,2).equals("F:")){
			printResults(contactList.findByFname(args[0].substring(2)));
		}else if(args[0].substring(0,2).equals("L:")){
			printResults(contactList.findBySname(args[0].substring(2)));
		}else{
			System.out.println("Invalid Argument");
		}

	}

	public static void printResults(ArrayList<Contact> result){
		for(Contact c:result){
			System.out.println(c.getFname()+"\t"+c.getSname()+"\t"+c.getTel());
		}
	}
}