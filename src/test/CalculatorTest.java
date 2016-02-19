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
//1.    使用注解 org.junit.runners.Parameterized
@RunWith(Parameterized.class)
public class CalculatorTest {

    //2.    建立几个变量，来记录测试的入参和预期结果
    private int arg1;
    private int arg2;
    private int result;
    private static Calculator calculator = new Calculator();
    //3.  建立有入参的公共构造方法，给变量赋值
    public CalculatorTest(int arg1, int arg2, int result) {
        super();
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.result = result;
    }
    //4.    使用注解   @Parameters 修饰个返回值为java.util.Collection 的公共静态方法
    @Parameters
    public static Collection initParameters() {
        return Arrays.asList(new Object[][]{{1, 2, 3},{2,2,4},{3,2,5}});
    }
    //5.    编写测试方法，使用全局变量作为参数测试
    @Test
    public void testParameters() {
        assertEquals(result, calculator.add(arg1, arg2));
    }
    //这个也会执行
    @Test
    public void testAdd() {
        assertEquals("测试加法", 3, calculator.add(1, 2));
    }

    @Test
    public void testSub() {
        assertEquals("测试减法", -1, calculator.sub(1, 2));
    }

    @Test
    public void testMul() {
        assertEquals("测试乘法", 2, calculator.mul(1, 2));
    }

    @Test
    public void testDiv() {
        assertEquals("测试除法", 0, calculator.div(1, 2));
    }

    //    @Test
    //    public void testAssertThat() {
    //        // 和junit的版本有关系么？ 为毛不能测试起来      
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
        assertEquals("测试除法2", 0, calculator.div(1, 0));
    }

    @Ignore
    @Test(timeout = 100)
    public void testTimeOut() {
        calculator.timeOut();
    }

}
