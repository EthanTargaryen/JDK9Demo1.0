package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class NHIStream extends ObjectInputStream {
    public NHIStream(InputStream in) throws Exception{
        super(in);
    }

    @Override
    protected void readStreamHeader() throws IOException, StreamCorruptedException {
        //super.readStreamHeader();
    }
}
