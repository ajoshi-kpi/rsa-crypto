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
        for (int i = 0; i < K; i++) {
            if (!utils.testGcd(number)) {
                return false;
            }
            if (utils.testIfEqualsOne(number)) {
                return true;
            }
            if (utils.testIfSimpleInCycle(number).equals(MillerRabinUtils.SimplicityStatus.SIMPLE)) {
                return true;
            } else if (utils.testIfSimpleInCycle(number).equals(MillerRabinUtils.SimplicityStatus.NON_SIMPLE)) {
                return false;
            }
        }
        return false;
    }

    private static class MillerRabinUtils {

        private BigInteger number;
        private BigInteger s = BigInteger.ZERO;
        private BigInteger d;
        private BigInteger x;
        Random randomGenerator;

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

        private boolean testGcd(BigInteger number) {
            if (randomGenerator == null) {
                randomGenerator = new Random();
            }
            BigInteger currentBase = BigInteger.valueOf(randomGenerator.nextLong() % number.longValue());
            if(currentBase.compareTo(BigInteger.ZERO) == -1) {
                currentBase = currentBase.add(number);
            }
            return getGCD(number, currentBase).equals(BigInteger.ONE) ||
                    getGCD(number, currentBase).equals(number);
        }

        private BigInteger getGCD(BigInteger number, BigInteger x) {
            this.x = x;
            return number.gcd(x);
        }

        private boolean testIfEqualsOne(BigInteger p) {
            return x.modPow(d, p).equals(BigInteger.ONE);
        }

        private SimplicityStatus testIfSimpleInCycle(BigInteger p) {
            for (int i = 0; i < s.intValue() - 1; i++) {
                BigInteger xr = x.modPow(d.multiply(BigInteger.valueOf(2).pow(i)), p);
                if (xr.equals(p.subtract(BigInteger.ONE))) {
                    return SimplicityStatus.SIMPLE;
                } else if (xr.equals(BigInteger.ONE)) {
                    return SimplicityStatus.NON_SIMPLE;
                }
            }
            return SimplicityStatus.UNDEFINED;
        }

        private enum SimplicityStatus {
            SIMPLE,
            NON_SIMPLE,
            UNDEFINED
        }
    }
}
