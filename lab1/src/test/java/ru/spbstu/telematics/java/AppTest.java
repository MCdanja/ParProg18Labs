package ru.spbstu.telematics.java;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public void testReadertext() throws IOException
    {
        assertEquals(App.ReadFromFile("text.txt"), "Hello World!\nMy name is Daniel.\n");
    }
    public void testReaderprog() throws IOException
    {
        assertEquals(App.ReadFromFile("prog.txt"), "package ru.spbstu.telematics.java;\n" +
                "\n" +
                "import java.io.*;\n" +
                "\n" +
                "public class App \n" +
                "{\n" +
                "    public static void main( String[] args ) throws NumberFormatException, IOException\n" +
                "    {\n" +
                "        FileReader reader = new FileReader(\"text.txt\");\n" +
                "            // читаем посимвольно\n" +
                "            int c;\n" +
                "            while((c=reader.read())!=-1)\n" +
                "            {\n" +
                "                System.out.print((char)c);\n" +
                "            }\n" +
                "    }\n" +
                "}\n");
    }
}
