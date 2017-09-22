import java.io.IOException;

class TestCPU {

    static String [] prog;
    public static void main(String [] args)  {
		try {
			CPUReg regFile = new CPUReg(); //for the particular proessor
			Controller cnt = new Controller(); //for the particular ISA

			//ProgramFromFile programFromFile=new ProgramFromFile("C:\\Users\\e14305.CEWIN\\Documents\\CO225\\CPU\\program.txt");
			ProgramFromFile programFromFile=new ProgramFromFile("program.txt");
			prog=programFromFile.load();

			printRegTitles();

			for(int i=0; i < prog.length; i++) {
				String [] cmd = cleanIns(prog[i]);
				cnt.executeInstruction(cmd, regFile);
				printRegValues(regFile);
			}

			

		} catch(IOException e) {
			System.out.println(e);
		}
    }

    private static String[] cleanIns(String ins){
		return ins.trim().split("[ ]+");
	}

	private static void printRegTitles(){
		for(int i=0;i<8;i++)
			System.out.print("R"+i+"\t");
		System.out.println();
	}

	private static void printRegValues(CPUReg regFile) throws IOException{
		for(int i=0;i<8;i++)
			System.out.print(regFile.readReg("R"+i)+"\t");
		System.out.println();
	}
}

		      
