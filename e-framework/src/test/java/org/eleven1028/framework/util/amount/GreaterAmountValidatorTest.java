package org.eleven1028.framework.util.amount;

import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.exception.FrameworkErrorCode;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class GreaterAmountValidatorTest {

    @Test
    void of() {
        GreaterAmountValidator amountEqualityValidator =
                GreaterAmountValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), BigDecimal.valueOf(0.0), BigDecimal.valueOf(10.0));
        assertFalse(amountEqualityValidator.getCondition().run(), "0.0>10.0");

        amountEqualityValidator =
                GreaterAmountValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), BigDecimal.valueOf(2020202020202020202020202020202020202020.0), BigDecimal.valueOf(10.0));
        assertTrue(amountEqualityValidator.getCondition().run(), "20.0>10.0");
    }
}