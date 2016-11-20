package app.tests;

import java.math.BigInteger;
import java.util.Random;

public class MillerRabbinPrimaryTest implements PrimaryTest {

    private PrimaryTest nextPrimaryTest;
    private MillerRabinUtils utils;

    public MillerRabbinPrimaryTest() {
    }

    public MillerRabbinPrimaryTest(PrimaryTest nextPrimaryTest) {
        this.nextPrimaryTest = nextPrimaryTest;
    }

    @Override
    public boolean isPrimary(BigInteger number) {

        boolean isPrimary = testIsPrimaryByRabbin(number);
        return isPrimary && (nextPrimaryTest != null) ? nextPrimaryTest.isPrimary(number) : isPrimary;
    }

    private boolean testIsPrimaryByRabbin(BigInteger number) {
        utils = new MillerRabinUtils(number);
        if (utils.testGcd(number)) {
            return false;
        }
        //TODO
        return true;
    }

    private class MillerRabinUtils {

        private BigInteger number;
        private BigInteger s = BigInteger.ZERO;
        private BigInteger d;
        private BigInteger x;

        public MillerRabinUtils(BigInteger number) {
            this.number = number.subtract(BigInteger.ONE);
            calculateParameters();
        }

        public void calculateParameters() {
            while (number.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                number = number.divide(BigInteger.valueOf(2));
                s = s.add(BigInteger.ONE);
            }
            d = number;
        }

        private BigInteger getGCD(BigInteger number, BigInteger x) {
            return number.gcd(x);
        }

        private boolean testGcd(BigInteger number) {
            Random randomGenerator = new Random(number.longValue());
            long l = randomGenerator.nextLong();
            return getGCD(number, BigInteger.valueOf(randomGenerator.nextLong())).equals(BigInteger.ONE);
        }
    }
}
