package com.nulabinc.backlog4j.http;

import org.apache.http.conn.ClientConnectionManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author nulab-inc
 */
public class HttpInputStream extends InputStream {
    private ClientConnectionManager clientConnectionManager;
    protected InputStream inputStream;

    public HttpInputStream(InputStream inputStream, ClientConnectionManager clientConnectionManager) {
        this.clientConnectionManager = clientConnectionManager;
        this.inputStream = inputStream;
    }


    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return inputStream.read(b);
    }

    @Override
    public int read(byte b[], int off, int len) throws IOException {
        return inputStream.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return inputStream.skip(n);
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
        clientConnectionManager.shutdown();
    }

    @Override
    public int available() throws IOException {
        return inputStream.available();
    }

    @Override
    public synchronized void mark(int readlimit) {
        inputStream.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        inputStream.reset();
    }

    @Override
    public boolean markSupported() {
        return inputStream.markSupported();
    }
}
