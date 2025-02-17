package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    private Feline mockFeline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        mockFeline = mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(2);
        when(mockFeline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        lion = new Lion("Самец", mockFeline);
    }

    @Test
    public void testGetKittensReturnsCorrectValue() {
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testGetFoodCallsFelineGetFood() throws Exception {
        List<String> actualFood = lion.getFood();
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), actualFood);
        verify(mockFeline, times(1)).getFood("Хищник");
    }

    @Test(expected = Exception.class)
    public void testLionConstructorThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Неизвестный", mockFeline);
    }
}
