package app.generators.impl.bbsgenerator;

import app.generators.GenericGenerator;
import app.generators.IntGenerator;

import java.math.BigInteger;
import java.util.Random;
import java.util.stream.Stream;

public class BigIntegerGenerator implements GenericGenerator<BigInteger> {

    private Random initialStateGenerator = new Random();

    @Override
    public BigInteger nextValue() {
        IntGenerator intGenerator = new BBSBitGenerator(BigInteger.valueOf(initialStateGenerator.nextLong()));

        return Stream.iterate(0, n -> n + 1)
                .limit(BITS_NUMBER)
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ZERO,
                        (num1, num2) ->
                                num1.add(BigInteger.valueOf(2L).pow(num2.intValue()))
                                        .multiply(BigInteger.valueOf(intGenerator.nextValue())));
    }
}
