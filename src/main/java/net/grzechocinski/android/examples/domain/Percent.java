package net.grzechocinski.android.examples.domain;

import java.math.BigDecimal;

public class Percent {

    public static final Percent PERCENT_0 = new Percent(0);
    public static final Percent PERCENT_25 = new Percent(25);
    public static final Percent PERCENT_50 = new Percent(50);
    public static final Percent PERCENT_75 = new Percent(75);
    public static final Percent PERCENT_100 = new Percent(100);

    public static final BigDecimal DIVISOR_PERCENT = new BigDecimal(100);

    private final int value;

    public Percent(int value) {
        if(value < 0 || value > 100){
            throw new IllegalArgumentException("Percentage value must be in <0;100> range");
        }
        this.value = value;
    }

    public int asIntValue() {
        return value;
    }

    public BigDecimal asBigDecimal() {
        return new BigDecimal(value).divide(DIVISOR_PERCENT);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Percent{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
