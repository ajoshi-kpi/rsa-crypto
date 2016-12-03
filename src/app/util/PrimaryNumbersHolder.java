package app.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajoshi on 03-Dec-16.
 */
public class PrimaryNumbersHolder {

    private static List<BigInteger> numbers = new ArrayList<>();
    private static int currentNumber = 0;

    static {
        try {
            numbers = (new FileHelper()).getPQFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BigInteger getNextBigPrimary() {
        return numbers.get(currentNumber++ % numbers.size());
    }
}
