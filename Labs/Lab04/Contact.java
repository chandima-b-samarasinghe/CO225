public class Contact{
	private String fname,sname,tel;
	public Contact(String fname,String sname,String tel){
		this.fname=fname; this.sname=sname; this.tel=tel;
	}
	public boolean findByFname(String fname){
		if(this.fname.equals(fname)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean findBySname(String sname){
		if(this.sname.equals(sname)){
			return true;
		}else{
			return false;
		}
	}

	public String getFname(){return this.fname;}
	public String getSname(){return this.sname;}
	public String getTel(){return this.tel;}

}