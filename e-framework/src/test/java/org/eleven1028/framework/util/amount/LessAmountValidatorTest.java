package org.eleven1028.framework.util.amount;

import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.exception.FrameworkErrorCode;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LessAmountValidatorTest {

    @Test
    void of() {
        LessAmountValidator amountEqualityValidator =
                LessAmountValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), BigDecimal.valueOf(0.0), BigDecimal.valueOf(10.0));
        assertTrue(amountEqualityValidator.getCondition().run(), "0.0<10.0");
    }

    @Test
    void testOf() {
        LessAmountValidator amountEqualityValidator =
                LessAmountValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), BigDecimal.valueOf(-1.0));
        assertTrue(amountEqualityValidator.getCondition().run(), "-1<0.0");
    }
}