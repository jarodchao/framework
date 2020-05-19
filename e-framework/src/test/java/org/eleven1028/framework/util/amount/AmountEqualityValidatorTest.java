package org.eleven1028.framework.util.amount;

import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.exception.FrameworkErrorCode;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AmountEqualityValidatorTest {

    @Test
    void of() {

        AmountEqualityValidator amountEqualityValidator =
                AmountEqualityValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), BigDecimal.valueOf(0.0), BigDecimal.valueOf(0.0));
        assertTrue(amountEqualityValidator.getCondition().run(), "0.0不等于0.0");


    }

    @Test
    void testOf() {
        AmountEqualityValidator amountEqualityValidator =
                AmountEqualityValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), BigDecimal.valueOf(0L));
        assertTrue(amountEqualityValidator.getCondition().run(), "0.0不等于0.0");
    }
}