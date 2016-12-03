package app;

import app.tests.MillerRabbinPrimaryTest;
import app.tests.PrimaryTest;
import app.tests.SimplePrimaryTest;
import app.util.FileHelper;

import java.io.IOException;
import java.math.BigInteger;

public class PrimaryNumbersTest {
    public static void main(String[] args) throws IOException {

        PrimaryTest test = new SimplePrimaryTest(new MillerRabbinPrimaryTest());
        FileHelper fileHelper = new FileHelper();
        for (BigInteger bigInteger : fileHelper.getPQFromFile()) {
            System.out.println(test.isPrimary(bigInteger));
        }
    }
}
