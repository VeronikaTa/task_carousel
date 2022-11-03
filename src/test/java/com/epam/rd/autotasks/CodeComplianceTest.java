package com.epam.training.student_veronika_tarasova.task_carousel.src.test.java.com.epam.rd.autotasks;

import com.epam.training.student_veronika_tarasova.task_carousel.src.main.java.com.epam.rd.autotasks.CompleteByRequestTask;
import com.epam.training.student_veronika_tarasova.task_carousel.src.main.java.com.epam.rd.autotasks.CountDownTask;
import com.epam.training.student_veronika_tarasova.task_carousel.src.main.java.com.epam.rd.autotasks.Task;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodeComplianceTest {
    @Test
    void testTaskIsInterface() {
        assertTrue(Task.class.isInterface());
    }

    @Test
    void testImplementsTask() {
        assertTrue(Arrays.asList(CountDownTask.class.getInterfaces()).contains(Task.class));
        assertTrue(Arrays.asList(CompleteByRequestTask.class.getInterfaces()).contains(Task.class));
    }
}
