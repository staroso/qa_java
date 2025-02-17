package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class LionTest {

    @Mock
    Feline mockedFeline;

    Lion lion;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this); // инициализация моков
        lion = new Lion("Самец", mockedFeline); // передаем мок в конструктор
    }

    @Test
    public void testDoesHaveMane() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        when(mockedFeline.getKittens()).thenReturn(3); // мокаем метод getKittens()
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        when(mockedFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void testLionWithInvalidSex() {
        try {
            new Lion("Неизвестный", mockedFeline); // Проверяем исключение на неправильный пол
            fail("Ожидалось исключение");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}
