package server;

import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class NHOStream extends ObjectOutputStream {
    public NHOStream(OutputStream os) throws Exception {
        super(os);
    }
    protected void writeStreamHeader() {}
}
