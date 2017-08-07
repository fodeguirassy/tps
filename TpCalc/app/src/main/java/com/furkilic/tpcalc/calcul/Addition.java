package com.furkilic.tpcalc.calcul;

import java.math.BigDecimal;

/**
 * Created by furki on 13/06/2017.
 */

public class Addition implements Calcul {
    @Override
    public BigDecimal calcul(BigDecimal nb1, BigDecimal nb2) {
        return nb1.add(nb2);
    }
}
