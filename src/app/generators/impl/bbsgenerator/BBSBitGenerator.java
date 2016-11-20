package app.generators.impl.bbsgenerator;

import app.generators.IntGenerator;

import java.math.BigInteger;

/**
 * Created by ajoshi on 12-Sep-16.
 */
public class BBSBitGenerator extends BBSGenerator implements IntGenerator {

    public BBSBitGenerator(BigInteger initialState) {
        super(initialState);
    }

    @Override
    public int nextValue() {
        currentState = super.nextValue(currentState);
        return currentState.mod(BigInteger.valueOf(2L)).intValue();
    }
}
