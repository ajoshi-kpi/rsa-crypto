package app;

import app.generators.GeneratorConstants;
import app.generators.IntGenerator;
import app.generators.impl.bbsgenerator.BBSBitGenerator;
import app.tests.MillerRabbinPrimaryTest;
import app.tests.PrimaryTest;
import app.tests.SimplePrimaryTest;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Main implements GeneratorConstants {
    public static void main(String[] args) {

        PrimaryTest test = new SimplePrimaryTest(new MillerRabbinPrimaryTest());
        System.out.println(test.isPrimary(new BigInteger("35742549198872617291353508656626642561")));
    }
}
