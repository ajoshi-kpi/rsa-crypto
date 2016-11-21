package app.primarynumberworkers;

import app.generators.impl.bbsgenerator.BigIntegerGenerator;
import app.tests.MillerRabbinPrimaryTest;
import app.tests.PrimaryTest;
import app.tests.SimplePrimaryTest;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by ajoshi on 21-Nov-16.
 */
public class Worker implements Callable<BigInteger> {

    private CountDownLatch latch;
    private BigIntegerGenerator generator = new BigIntegerGenerator();
    private PrimaryTest test = new SimplePrimaryTest(new MillerRabbinPrimaryTest());

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public BigInteger call() {
        BigInteger candidate = generator.nextValue();
        while(candidate.equals(BigInteger.ONE) || candidate.equals(BigInteger.ZERO) || !test.isPrimary(candidate)) {
            candidate = generator.nextValue().add(BigInteger.ONE);
        }
        latch.countDown();
        return candidate;
    }
}
