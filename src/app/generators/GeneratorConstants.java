package app.generators;

import java.math.BigInteger;

public interface GeneratorConstants {
    BigInteger P = new BigInteger("D5BBB96D30086EC484EBA3D7F9CAEB07", 16);
    BigInteger Q = new BigInteger("425D2B9BFDB25B9CF6C416CC6E37B59C1F", 16);
    BigInteger N = P.multiply(Q);
}
