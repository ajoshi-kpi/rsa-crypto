package app.tests;

import java.math.BigInteger;
import java.util.Arrays;

public class SimplePrimaryTest implements PrimaryTest {

    private PrimaryTest nextPrimaryTest;

    public SimplePrimaryTest() {
    }

    public SimplePrimaryTest(PrimaryTest nextPrimaryTest) {
        this.nextPrimaryTest = nextPrimaryTest;
    }

    @Override
    public boolean isPrimary(BigInteger number) {
        boolean isPrimary = Arrays.stream(PRIMARY_NUMBERS)
                .noneMatch(value -> number.mod(BigInteger.valueOf(value)).equals(BigInteger.ZERO));
        return isPrimary && (nextPrimaryTest != null) ? nextPrimaryTest.isPrimary(number) : isPrimary;
    }
}
