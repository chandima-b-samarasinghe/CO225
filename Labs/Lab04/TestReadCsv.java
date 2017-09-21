public class TestReadCsv{
	public static void main(String[] args){
		try{
			ReadCsv csv=new ReadCsv("contacts.csv");
			for(Contact c:csv.getData()){
				System.out.println(c.getFname()+"\t"+c.getSname()+"\t"+c.getTel());
			}	
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}	
}