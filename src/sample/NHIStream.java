package sample;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class NHIStream extends ObjectInputStream {
    public NHIStream(InputStream in) throws Exception{
        super(in);
    }
    static {
        System.out.println("From NHIStream: " + STREAM_MAGIC);
    }

    @Override
    protected void readStreamHeader() throws IOException, StreamCorruptedException {
        //super.readStreamHeader();
        //super.readStreamHeader();
        System.out.println("From readStreamHeader: " + STREAM_MAGIC);

    }
}
