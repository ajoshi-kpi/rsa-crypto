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
        System.out.println(test.isPrimary(BigInteger.valueOf(11)));

        IntGenerator generator = new BBSBitGenerator(BigInteger.valueOf(20061996));
//        BigInteger result = Stream.iterate(0, n -> n + 1)
//                .limit(256)
//                .map(BigInteger::valueOf)
//                .reduce(BigInteger.ZERO,
//                        (num1, num2) ->
//                                num1.add(BigInteger.valueOf(2L).pow(num2.intValue()))
//                                .multiply(BigInteger.valueOf(generator.nextValue())));
    }
}
