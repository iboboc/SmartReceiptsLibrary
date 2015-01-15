package co.smartreceipts.android.model.impl;

import co.smartreceipts.android.model.Price;

/**
 * Provides common methods that all {@link co.smartreceipts.android.model.Price} implementations use
 *
 * @author williambaumann
 */
abstract class AbstractPriceImpl implements Price {

    protected static final float EPSILON = 0.00001f;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImmutablePriceImpl that = (ImmutablePriceImpl) o;

        if (!getCurrency().equals(that.getCurrency())) {
            return false;
        }
        if (Math.abs(getPrice().floatValue() - that.getPrice().floatValue()) > EPSILON) {
            return false;
        }
        if (!getCurrencyFormattedPrice().equals(that.getCurrencyFormattedPrice())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = getPrice().hashCode();
        result = 31 * result + getCurrency().hashCode();
        result = 31 * result + getCurrencyFormattedPrice().hashCode();
        return result;
    }
}