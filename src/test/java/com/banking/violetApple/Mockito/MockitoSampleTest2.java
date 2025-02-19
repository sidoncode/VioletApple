package com.banking.violetApple.Mockito;

import com.banking.violetApple.MockitoService.AddService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.banking.violetApple.MockitoService.CalcService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class MockitoSampleTest2 {

    CalcService calcService;

    @Mock
    private AddService addService;

    @BeforeEach
    public void setup() {
        System.out.println("@BeforeEach CalcService2Test");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalc() {
        System.out.println("**--- Test testCalc executed ---**");

        calcService = new CalcService(addService);

        int num1 = 11;
        int num2 = 12;
        int expected = 23;

        when(addService.add(num1, num2)).thenReturn(expected);

        int actual = calcService.calc(num1, num2);

        assertEquals(expected, actual);

    }
}