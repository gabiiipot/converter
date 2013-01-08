package com.gaby.tutorial.javaee.ejb;

import java.math.BigDecimal;

import javax.ejb.Remote;

@Remote
public interface Converter {
    public BigDecimal dollarToYen(BigDecimal dollars);
    public BigDecimal yenToEuro(BigDecimal yen);
}
