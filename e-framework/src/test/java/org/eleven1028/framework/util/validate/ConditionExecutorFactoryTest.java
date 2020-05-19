package org.eleven1028.framework.util.validate;

import org.eleven1028.framework.util.amount.AmountUtils;
import org.eleven1028.framework.util.condition.Condition;
import org.eleven1028.framework.util.condition.ConditionGroup;
import org.eleven1028.framework.util.condition.ConditionalOperations;
import org.eleven1028.framework.util.string.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ConditionExecutorFactoryTest {

    @Test
    void get() {

        ConditionExecutor executor = ConditionExecutorFactory.get().build();
    }

    @Test
    void build() {

        ConditionalOperations operations = objects -> StringUtils.isEmpty((String) objects[0]);
        ConditionGroup group = ConditionGroup.of(Condition.of(operations, "ABC"));
        ConditionExecutor executor = ConditionExecutorFactory.get().group(group).build();
        assertFalse(executor.execute(), "结果不是False");
    }

    @Test
    void buildTwoGroupAnd() {

        /** abc != null && abc.length > 0 */

        ConditionalOperations operations1 = objects -> StringUtils.nonEmpty((String) objects[0]);
        ConditionGroup group1 = ConditionGroup.of(Condition.of(operations1, "ABC"));

        ConditionalOperations operations2 = objects -> StringUtils.lessLength((Integer) objects[0], (String) objects[1]);
        ConditionGroup group2 = ConditionGroup.of(Condition.of(operations2, 0, "ABC"));

        ConditionExecutor executor = ConditionExecutorFactory.get().group(group1).andGroup(group2).build();
        assertTrue(executor.execute(), "结果不是true");
    }

    @Test
    void buildTwoGroupOr() {

        /** abc != null || abc.length > 0 */

        ConditionalOperations operations1 = objects -> StringUtils.nonEmpty((String) objects[0]);
        ConditionGroup group1 = ConditionGroup.of(Condition.of(operations1, "ABC"));

        ConditionalOperations operations2 = objects -> StringUtils.lessLength((Integer) objects[0], (String) objects[1]);
        ConditionGroup group2 = ConditionGroup.of(Condition.of(operations2, 0, "ABC"));

        ConditionExecutor executor = ConditionExecutorFactory.get().group(group1).orGroup(group2).build();
        assertTrue(executor.execute(), "结果不是true");

    }

    @Test
    void build1() {

        /** ( abc != null || abc.length > 0 ) && amount > 100.00 */
        String abc = "ABC";
        BigDecimal amount = BigDecimal.valueOf(101.0);

        ConditionalOperations operations1 = objects -> StringUtils.nonEmpty((String) objects[0]);
        ConditionGroup group1 = ConditionGroup.of(Condition.of(operations1, "ABC"));
        ConditionalOperations operations2 = objects -> StringUtils.lessLength((Integer) objects[0], (String) objects[1]);
        group1.and().condition(Condition.of(operations2, 0, "ABC"));

        ConditionalOperations operations3 =
                objects -> AmountUtils.greaterOther(AmountUtils.toAmount(objects[0]), AmountUtils.toAmount(objects[1]));
        ConditionGroup group2 = ConditionGroup.of(Condition.of(operations3, amount, BigDecimal.valueOf(100.0)));

        ConditionExecutor executor = ConditionExecutorFactory.get().group(group1).orGroup(group2).build();
        assertTrue(executor.execute(), "结果不是true");

    }
}