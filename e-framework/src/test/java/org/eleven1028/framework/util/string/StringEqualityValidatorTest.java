package org.eleven1028.framework.util.string;

import org.eleven1028.framework.exception.ErrorInfo;
import org.eleven1028.framework.exception.FrameworkErrorCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringEqualityValidatorTest {

    @Test
    void of() {
        StringEqualityValidator validator = StringEqualityValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), null, "ABC");
        assertFalse(validator.getCondition().run(),"null is ABC");

        validator = StringEqualityValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), "ABC", "ABC");
        assertTrue(validator.getCondition().run(),"ABC is ABC");

        validator = StringEqualityValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), "", "ABC");
        assertFalse(validator.getCondition().run()," \'\' is ABC");
    }

    @Test
    void testOf() {
        StringEqualityValidator validator = StringEqualityValidator.of(ErrorInfo.of(FrameworkErrorCode.NO_EXCEPTION_TRIGGER), "ABC");
        assertFalse(validator.getCondition().run(),"ABC is not null ");

    }
}