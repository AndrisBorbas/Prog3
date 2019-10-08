package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Demo{

    public static void main(String[] args) throws IOException {
        FileOutputStream fis=new FileOutputStream("test.txt");
        OutputStreamWriter foo=new OutputStreamWriter(fis);
        foo.write('a');
        foo.close();
    }
}