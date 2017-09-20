import java.io.IOException;

class ReadWriteReg extends RegBase {

    public ReadWriteReg() {
	value = 0;
    }

    public void writeReg(int value) throws IOException {
	    this.value = value;
    }

}
