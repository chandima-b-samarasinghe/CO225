import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class ReadCsv{
    ArrayList<Contact> filedata;
    String[] header=null;

    public int getNumberOfHeaders(){return header.length;}
    public String getHeader(int index) throws Exception{
    	return header[index];
    }
    public String[] getHeaders(){return this.header;}
    public ReadCsv(String filename) throws Exception{
        filename=ReadCsv.class.getProtectionDomain().
        	getCodeSource().getLocation().getPath().replace("%20"," ")+"/"+filename;
        
        filedata=new ArrayList<Contact>();
        
        BufferedReader br=null;
        FileReader fr=null;

        try{
            fr=new FileReader(filename);
            br=new BufferedReader(fr);

            String currentRecord; String[] currentRecordArr;
            
            if((currentRecord=br.readLine())!=null){
            	header=currentRecord.trim().split(",");
            }

            while((currentRecord=br.readLine())!=null){
                currentRecordArr=currentRecord.trim().split(",");
            	filedata.add(new Contact(
                        currentRecordArr[0],
                        currentRecordArr[1],
                        currentRecordArr[2]
                    )
                );
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Contact> getData(){return this.filedata;}
    public int getSize(){return filedata.size();}

}