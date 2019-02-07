package sample;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class NHOStream extends ObjectOutputStream {
    public NHOStream(OutputStream os) throws Exception {
        super(os);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        //super.writeStreamHeader();
        System.out.println("From writeStreamHeader: " + STREAM_MAGIC);
    }
}
