import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramFromFile implements Program {
    FileInputStream fin;
    ArrayList<String> progInstructions;
    public ProgramFromFile(String filename){
        //filename=System.getProperty("user.dir").replace("\\","/")+"/src/"+filename;
        filename=Controller.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"/"+filename;
        //System.out.println(filename);
        progInstructions=new ArrayList<String>();
        try{
            fin=new FileInputStream(filename);
            Scanner scanner=new Scanner(fin);
            while(scanner.hasNextLine()){
                progInstructions.add(scanner.nextLine());
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public String[] load() throws IOException {
        String[] temp=new String[progInstructions.size()];

        return progInstructions.toArray(temp);
    }
}
