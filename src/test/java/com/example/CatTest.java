package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class CatTest {

    @Test
    public void testGetSound() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
