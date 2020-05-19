package org.eleven1028.framework.util.objects;

import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.exception.FrameworkErrorCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectEqualityValidatorTest {

    @Test
    void of() {
        ObjectEqualityValidator<String> stringObjectEqualityValidator =
                ObjectEqualityValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), "ABC", "ABC");
        assertFalse(stringObjectEqualityValidator.getCondition().run(),"ABC不等于ABC");

        ObjectEqualityValidator<Long> longObjectEqualityValidator =
                ObjectEqualityValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), 10L, 10L);
        assertFalse(longObjectEqualityValidator.getCondition().run(),"10L不等于10L");

        stringObjectEqualityValidator =
                ObjectEqualityValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), "ABCD", "ABC");

        assertFalse(stringObjectEqualityValidator.getCondition().run(),"ABCD等于ABC");
    }
}