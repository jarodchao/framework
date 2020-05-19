package org.eleven1028.framework.util.objects;

import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.exception.FrameworkErrorCode;

import static org.junit.jupiter.api.Assertions.*;

class EmptyValidatorTest {

    @org.junit.jupiter.api.Test
    void of() {

        EmptyValidator emptyValidator =
                EmptyValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), "");
        assertFalse(emptyValidator.getCondition().run(),"空字符串不等于empty");
        emptyValidator =
                EmptyValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), null);
        assertTrue(emptyValidator.getCondition().run(),"NULL不等于empty");
    }
}