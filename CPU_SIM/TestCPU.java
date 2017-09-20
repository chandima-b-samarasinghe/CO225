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

			for(int i=0; i < prog.length; i++) {
				String [] cmd = cleanIns(prog[i]);
				cnt.executeInstruction(cmd, regFile);
			}

			System.out.println("R3 = " +  regFile.readReg("R3"));
		} catch(IOException e) {
			System.out.println(e);
		}
    }

    private static String[] cleanIns(String ins){
		return ins.trim().split("[ ]+");
	}
}

		      
