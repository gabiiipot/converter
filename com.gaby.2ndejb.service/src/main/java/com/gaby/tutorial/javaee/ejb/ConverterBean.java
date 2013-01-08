package com.gaby.tutorial.javaee.ejb;

import java.math.BigDecimal;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(mappedName="converter")
@Remote(Converter.class)
public class ConverterBean implements Converter {
    private BigDecimal yenRate = new BigDecimal("115.3100");
    private BigDecimal euroRate = new BigDecimal("0.0071");

    public BigDecimal dollarToYen(BigDecimal dollars) {
        BigDecimal result = dollars.multiply(yenRate);
        return result.setScale(2, BigDecimal.ROUND_UP);
    }

    public BigDecimal yenToEuro(BigDecimal yen) {
        BigDecimal result = yen.multiply(euroRate);
        return result.setScale(2, BigDecimal.ROUND_UP);
    }
}
