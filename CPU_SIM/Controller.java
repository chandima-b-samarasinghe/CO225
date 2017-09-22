import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Controller {

    Map<String, Instruction> cnt;
    RAM ram;
    public Controller() {
		cnt = new HashMap<String, Instruction>();
		ram=new RAM(32);//32MB

		class ADD implements Instruction {
			public void execute(String [] args, CPUReg regFile) throws IOException  {
				regFile.writeReg(
						args[1],
						regFile.readReg(args[2]) + regFile.readReg(args[3])
				);
			}
		}
		cnt.put("ADD", new ADD());

		class SUB implements Instruction {
			public void execute(String [] args, CPUReg regFile)	throws IOException  {
				regFile.writeReg(
						args[1],
						regFile.readReg(args[2]) - regFile.readReg(args[3])
				);
			}
		}
		cnt.put("SUB", new SUB());

		class MUL implements Instruction {
			public void execute(String [] args, CPUReg regFile) throws IOException  {
				regFile.writeReg(
						args[1],
						regFile.readReg(args[2]) *
						regFile.readReg(args[3])
				);
			}
		}
		cnt.put("MUL", new MUL());

		class LI implements Instruction {
			public void execute(String [] args, CPUReg regFile) throws IOException  {
				regFile.writeReg(
						args[1],
						Integer.valueOf(args[2])
				);
			}
		}
		cnt.put("LI", new LI());

		class LW implements Instruction{// LW R4,ram_address 
			public void execute(String[] args, CPUReg regFile) throws IOException{
				regFile.writeReg(
					args[1],
					ram.lw(args[2])
				);
			}
		}
		cnt.put("LW",new LW());

		class SW implements Instruction{//LW R4,ram_address
			public void execute(String[] args, CPUReg regFile) throws IOException{
				ram.sw(
					args[2],
					regFile.readReg(args[1])
				);
			}
		}
		cnt.put("SW", new SW());
    }
    

    public void executeInstruction(String [] args, CPUReg regFile) throws IOException {
		Instruction inst = cnt.get(args[0]);
		if(inst == null) throw new IOException("Cannot find instruction");

		inst.execute(args, regFile);
    }
}