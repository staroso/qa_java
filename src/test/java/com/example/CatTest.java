package com.example;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    private Feline mockFeline;
    private Cat cat;

    @Before
    public void setUp() {
        mockFeline = mock(Feline.class);
        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodCallsEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
        verify(mockFeline, times(1)).eatMeat();
    }
}
