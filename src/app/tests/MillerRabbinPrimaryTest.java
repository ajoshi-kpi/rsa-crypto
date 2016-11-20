package app.tests;

import java.math.BigInteger;

public class MillerRabbinPrimaryTest implements PrimaryTest {

    private PrimaryTest nextPrimaryTest;

    public MillerRabbinPrimaryTest() {
    }

    public MillerRabbinPrimaryTest(PrimaryTest nextPrimaryTest) {
        this.nextPrimaryTest = nextPrimaryTest;
    }

    @Override
    public boolean isPrimary(BigInteger number) {
        boolean isPrimary = false;
        return isPrimary && (nextPrimaryTest != null) ? nextPrimaryTest.isPrimary(number) : isPrimary;
    }
}
