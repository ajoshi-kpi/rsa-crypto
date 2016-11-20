package app.generators.impl.bbsgenerator;

import app.generators.GeneratorConstants;

import java.math.BigInteger;

/**
 * Created by ajoshi on 12-Sep-16.
 */
public class BBSGenerator implements GeneratorConstants {

    protected BigInteger currentState;

    protected BBSGenerator(BigInteger initialState) {
        this.currentState = initialState;
    }

    protected BigInteger nextValue(BigInteger currentState) {
        return currentState.modPow(BigInteger.valueOf(2L), N);
    }
}
