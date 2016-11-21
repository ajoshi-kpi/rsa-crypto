package app.tests;

import java.math.BigInteger;

public interface PrimaryTest {
    boolean isPrimary(BigInteger number);

    long[] PRIMARY_NUMBERS = {2, 3, 5, 7, 11, 13};
    long K = 100;
}
