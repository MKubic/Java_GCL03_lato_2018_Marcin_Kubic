/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.Collection;
import junity.BasicCalculator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 *
 * @author marcin
 */

@RunWith(Parameterized.class) 
public class BasicCalculatorTest {
    private final BasicCalculator a = new BasicCalculator();
    private final double delta;
    private double b;
    private double c;
    public BasicCalculatorTest(int b,int c) {
        this.delta = 0;
        this.b=b;
        this.c=c;
    }
    
    @Parameters  
    public static Collection data() {  
    return Arrays.asList(new Object[][] { { -1, 1 }, { -4, 2 }, { -9, 3 }});  
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
     * Test of calculateSum method, of class BasicCalculator.
     */
    @Test
    public void testCalculateSum() {
        System.out.println("Testing calculateSum. Delta="+delta);
        assertEquals( 5,a.calculateSum(2,3), delta);
        assertEquals( -1,a.calculateSum(-2,1), delta);
        assertEquals( -4,a.calculateSum(-2,-2), delta);
    }

    /**
     * Test of calculateDifference method, of class BasicCalculator.
     */
    @Test
    public void testCalculateDifference() {
        System.out.println("Testing calculateDifference. Delta="+delta);
        assertEquals( -1,a.calculateDifference(2,3), delta);
        assertEquals( -3,a.calculateDifference(-2,1), delta);
        assertEquals( 0,a.calculateDifference(-2,-2), delta);
    }

    /**
     * Test of calculateMultiplication method, of class BasicCalculator.
     */
    @Test
    public void testCalculateMultiplication() {
        System.out.println("Testing calculateMultiplication. Delta="+delta);
        assertEquals( 6,a.calculateMultiplication(2,3), delta);
        assertEquals( -2,a.calculateMultiplication(-2,1), delta);
        assertEquals( 4,a.calculateMultiplication(-2,-2), delta);
    }

    /**
     * Test of calculateDivision method, of class BasicCalculator.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testCalculateDivision() {
        System.out.println("Testing calculateDivision. Delta="+delta);
        a.calculateDivision(0,0);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testCalculateDivision1() {
        System.out.println("Testing calculateDivision. Delta="+delta);
        a.calculateDivision(4,0);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testCalculateDivision2() {
        System.out.println("Testing calculateDivision. Delta="+delta);
        a.calculateDivision(2,0);
    }

    /**
     * Test of calculateSqlr method, of class BasicCalculator.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testCalculateSqlr() {
        System.out.println("Testing calculateSqlr. Delta="+delta);
        a.calculateSqlr(b);
    }

    /**
     * Test of calculatePow method, of class BasicCalculator.
     */
    @Test
    public void testCalculatePow() {
        System.out.println("Testing calculatePow. Delta="+delta);
        assertEquals( 8,a.calculatePow(2,3), delta);
        assertEquals( 4,a.calculatePow(-2,2), delta);
        assertEquals( 0.25,a.calculatePow(-2,-2), delta);
    }
}
