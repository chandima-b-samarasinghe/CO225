import java.io.IOException;
abstract class RegBase {
    protected int value;
    public int readReg() throws IOException{
        return this.value;
    }
    abstract public void writeReg(int value) throws IOException;
}



