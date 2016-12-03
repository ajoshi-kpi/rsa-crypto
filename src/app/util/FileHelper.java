package app.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajoshi on 03-Dec-16.
 */
public class FileHelper {
    private final String FILE_NAME = "resources/pqpq.txt";
    private final BufferedReader reader;

    public FileHelper() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(FILE_NAME));
    }

    public List<BigInteger> getPQFromFile() throws IOException {
        List<BigInteger> resultLits = new ArrayList<>();
        String currentLine = reader.readLine();
        while(currentLine != null) {
            resultLits.add(new BigInteger(currentLine));
            currentLine = reader.readLine();
        }
        return resultLits;
    }
}
