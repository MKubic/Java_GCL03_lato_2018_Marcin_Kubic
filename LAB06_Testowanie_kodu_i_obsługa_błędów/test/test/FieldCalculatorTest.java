/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import junity.FieldCalculator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marcin
 */
public class FieldCalculatorTest {
    private final FieldCalculator a = new FieldCalculator();
    private final double delta;
    public FieldCalculatorTest() {
        this.delta = 0.0;
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start of tests");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("End of tests");
    }
    
    @Before
    public void setUp() {
        System.out.println("Testing new method");
    }
    
    @After
    public void tearDown() {
        System.out.println("Test ended");
    }

    /**
     * Test of calculateSquare method, of class FieldCalculator.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testCalculateSquare() {
        System.out.println("Testing calculateSquare. Delta="+delta);
        assertEquals( 4,a.calculateSquare(2), delta);
        assertEquals( 4,a.calculateSquare(-2), delta);
        assertEquals( 0,a.calculateSquare(0), delta);
    }

    /**
     * Test of calculateCircle method, of class FieldCalculator.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testCalculateCircle() {
        System.out.println("Testing calculateCircle. Delta="+delta);
        assertEquals( 4*3.14,a.calculateCircle(2), delta);
        assertEquals( 4*3.14,a.calculateCircle(-2), delta);
        assertEquals( 0,a.calculateCircle(0), delta);
    }

    /**
     * Test of calculateTriangle method, of class FieldCalculator.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testCalculateTriangle() {
        System.out.println("Testing calculateTriangle. Delta="+delta);
        assertEquals( 3,a.calculateTriangle(2,3), delta);
        assertEquals( -1,a.calculateTriangle(2,-1), delta);
        assertEquals( 1,a.calculateTriangle(-1,-2), delta);
    }

    /**
     * Test of calculateRectangle method, of class FieldCalculator.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testCalculateRectangle() {
        System.out.println("Testing calculateRectangle. Delta="+delta);
        assertEquals( 6,a.calculateRectangle(2,3), delta);
        assertEquals( -2,a.calculateRectangle(2,-1), delta);
        assertEquals( 2,a.calculateRectangle(-1,-2), delta);
    }
    
}
