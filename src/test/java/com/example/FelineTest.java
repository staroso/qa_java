package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class FelineTest {

    @Test
    public void testGetFoodForHerbivore() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void testGetFoodForPredator() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFoodForUnknownAnimal() {
        Feline feline = new Feline();
        try {
            feline.getFood("Неизвестное");
            fail("Ожидалось исключение");
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens()); // Проверяем дефолтный вызов без аргументов
    }

    @Test
    public void testGetKittensWithCustomCount() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3)); // Проверяем метод с передачей кастомного значения
    }
}
