/*
 * The MIT License
 *
 * Copyright 2018 Maikel Chandika <mkdika@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mkdika.jeneric.function;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Maikel Chandika (mkdika@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class IntegerFunTest {

    @Before
    public void setup() {
    }

    @Test
    public void test_class_instance() {
        System.out.println("test_IntegerFun_class_instance");

        try {
            Constructor<IntegerFun> c = IntegerFun.class.getDeclaredConstructor();
            c.setAccessible(true);
            IntegerFun sf = c.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        }
    }

    @Test
    public void test_nvl_success() {
        System.out.println("test_IntegerFun_nvl_success");

        Integer a = IntegerFun.nvl(125);
        assertThat(a, equalTo(125));
        
        Integer b = IntegerFun.nvl(null);
        assertThat(b, equalTo(0));
    }
    
    @Test
    public void test_rand_success() {
        System.out.println("test_IntegerFun_nvl_success");
                        
        Integer a = IntegerFun.random();        
        assertTrue(a > -1);
        
        Integer b = IntegerFun.random(1, 1000);        
        assertTrue((b >= 1 && b <= 1000));                
    }
}
