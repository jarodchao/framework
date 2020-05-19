package org.eleven1028.framework.util.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringLengthEqualityValidatorTest {

    @Test
    void of() {
        StringLengthEqualityValidator validator = StringLengthEqualityValidator.of(null, "ABC", "ABC");
        assertTrue(validator.getCondition().run(),"abc != abc");

        validator = StringLengthEqualityValidator.of(null, "ABCD", "ABC");
        assertFalse(validator.getCondition().run(),"abcd = abc");
    }

    @Test
    void testOf() {

        StringLengthEqualityValidator validator = StringLengthEqualityValidator.of(null, "ABC", 3);
        assertTrue(validator.getCondition().run(),"abc length not 3");

        validator = StringLengthEqualityValidator.of(null, "ABCD", 3);
        assertFalse(validator.getCondition().run(),"abcd length is 3");
    }
}