package com.example.demo.service;

import com.example.demo.services.CategoryIdentificationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CategoryIdentificationServiceTest {

    @InjectMocks
    CategoryIdentificationService categoryIdentificationService;

    @Test
    public void testIdentifyCategoryForMobile() throws IOException {
        String category = categoryIdentificationService.identifyCategory("I bought a new Samsung Galaxy 16 ultra pro max");
        assertEquals("Mobile", category);
    }

    @Test
    public void testIdentifyCategoryForOther() throws IOException {
        String category = categoryIdentificationService.identifyCategory("luxury apartment in goa for vacation");
        assertEquals("Other", category);
    }

    @Test
    public void testIdentifyCategoryForCar() throws IOException {
        String category = categoryIdentificationService.identifyCategory("brand new Hyundai i20 race edition");
        assertEquals("Car", category);
    }
}
