package sample;

import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class NoHeaderObjectOutputStream extends ObjectOutputStream {
    public NoHeaderObjectOutputStream(OutputStream os) throws Exception {
        super(os);
    }
    protected void writeStreamHeader() {}
}
