package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void testGetFamilyReturnsCorrectValue() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensReturnsDefaultOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensReturnsCorrectValue() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3));
    }
}
