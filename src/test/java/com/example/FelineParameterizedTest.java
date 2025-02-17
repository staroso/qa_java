package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

import java.util.List;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private String animalKind;
    private List<String> expectedFood;

    // Конструктор для параметризированного теста
    public FelineParameterizedTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    // Параметры теста
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { "Травоядное", List.of("Трава", "Различные растения") },
                { "Хищник", List.of("Животные", "Птицы", "Рыба") }
        };
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood(animalKind);
        assertEquals(expectedFood, food);
    }
}
