package org.eleven1028.framework.util.string;

import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.exception.FrameworkErrorCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringEmptyValidatorTest {

    @Test
    void of() {

        StringEmptyValidator stringEmptyValidator = StringEmptyValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), "");
        assertTrue(stringEmptyValidator.getCondition().run(),"空字符在不等于empty");
    }
}