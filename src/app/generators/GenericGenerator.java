package app.generators;

public interface GenericGenerator<T> {
    T nextValue();
    int BITS_NUMBER = 94;
}
