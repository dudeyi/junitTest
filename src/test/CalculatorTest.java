package com.junitTest.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.Resources;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.junitTest.Calculator;
//1.    ʹ��ע�� org.junit.runners.Parameterized
@RunWith(Parameterized.class)
public class CalculatorTest {

    //2.    ������������������¼���Ե���κ�Ԥ�ڽ��
    private int arg1;
    private int arg2;
    private int result;
    private static Calculator calculator = new Calculator();
    //3.  ��������εĹ������췽������������ֵ
    public CalculatorTest(int arg1, int arg2, int result) {
        super();
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.result = result;
    }
    //4.    ʹ��ע��   @Parameters ���θ�����ֵΪjava.util.Collection �Ĺ�����̬����
    @Parameters
    public static Collection initParameters() {
        return Arrays.asList(new Object[][]{{1, 2, 3},{2,2,4},{3,2,5}});
    }
    //5.    ��д���Է�����ʹ��ȫ�ֱ�����Ϊ��������
    @Test
    public void testParameters() {
        assertEquals(result, calculator.add(arg1, arg2));
    }
    //���Ҳ��ִ��
    @Test
    public void testAdd() {
        assertEquals("���Լӷ�", 3, calculator.add(1, 2));
    }

    @Test
    public void testSub() {
        assertEquals("���Լ���", -1, calculator.sub(1, 2));
    }

    @Test
    public void testMul() {
        assertEquals("���Գ˷�", 2, calculator.mul(1, 2));
    }

    @Test
    public void testDiv() {
        assertEquals("���Գ���", 0, calculator.div(1, 2));
    }

    //    @Test
    //    public void testAssertThat() {
    //        // ��junit�İ汾�й�ϵô�� Ϊë���ܲ�������      
    //    }

    @Before
    public void before() {
        System.out.println(" before func");
    }
    @After
    public void after() {
        System.out.println(" after func");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println(" beforeClass func");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println(" afterClass func");
    }

    @Test
    (expected = ArithmeticException.class)
    public void testDiv2() {
        assertEquals("���Գ���2", 0, calculator.div(1, 0));
    }

    @Ignore
    @Test(timeout = 100)
    public void testTimeOut() {
        calculator.timeOut();
    }

}
