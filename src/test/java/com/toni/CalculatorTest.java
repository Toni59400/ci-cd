package com.toni;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

class CalculatorTest {

    @Test
    @DisplayName("add: 2 + 3 = 5")
    void add_ok() {
        assertEquals(5, Calculator.add(2, 3));
        assertNotEquals(-5, Calculator.add(5, 0));
        assertEquals(0, Calculator.add(0, 0));
        assertEquals(-3, Calculator.add(-1, -2));
    }

    @Test
    void divInt_throws_on_zero() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.divInt(10, 0));
    }

    @Test
    void divReal_ok() {
        assertEquals(2.5, Calculator.divReal(5, 2), 1e-9);
        assertEquals(0.5, Calculator.divReal(1, 2), 1e-12);
    }

    @Test
    void timeout_example() {
        assertTimeout(Duration.ofMillis(200), () -> {
            int x = 0; for (int i = 0; i < 10000; i++) x += i;
        });
    }

    @Disabled("À implémenter plus tard")
    @Test
    void ignored_example() {
        // not implemented
    }

    @Tag("fast")
    @Test
    void fast_tagged() {
        assertTrue(1 + 1 == 2);
    }

    // --- Tests paramétrés ---
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void add_params_value_source(int n) {
        assertEquals(n + n, Calculator.add(n, n));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5",
            "10,5,15"
    })
    void add_params_csv(int a, int b, int expected) {
        assertEquals(expected, Calculator.add(a, b));
    }
}
