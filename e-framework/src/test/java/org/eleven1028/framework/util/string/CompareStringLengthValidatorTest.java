package org.eleven1028.framework.util.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareStringLengthValidatorTest {

    @Test
    void of() {
        CompareStringLengthValidator validator =
                CompareStringLengthValidator.of(null, "ABC", 4);
        assertTrue(validator.getCondition().run(),"abc length not less than 4");

        validator =
                CompareStringLengthValidator.of(null, "ABC", 3);
        assertFalse(validator.getCondition().run(),"abc length less than 3");
    }

    @Test
    void testOf() {

        CompareStringLengthValidator validator =
                CompareStringLengthValidator.of(null,  2 ,"ABC");
        assertTrue(validator.getCondition().run(),"abc length greater than 3");

        validator =
                CompareStringLengthValidator.of(null,  4 ,"ABC");
        assertFalse(validator.getCondition().run(),"abc length greater than 4");
    }
}