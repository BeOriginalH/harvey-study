package com.harvey.mockit.demo;

import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

/**
 * @author harvey
 * @date 2020/8/24
 */
public class MockitoDemoTest{

    /**
     * 一、verify()方法的功能：
     *
     * 1、验证是否调用了某个方法
     * 2、验证调用某个方法的次数
     * 3、验证某个类所有方法都没被调用
     * 4、验证某个方法没有被调用
     * 5、验证某个方法是否被验证过
     * 6、验证方法调用顺序
     * 7、验证某个方法至少被调用几次
     * 8、验证某个方法最多被调用几次
     * 9、验证调用某个方法使用了特定的参数
     *
     */

    @Test
    public void testVerifyOfCallMethod() {

        List list = Mockito.mock(List.class);

        list.add("test verify");
        list.clear();

        Mockito.verify(list).add("test verify");
        Mockito.verify(list).clear();
    }

    @Test
    public void testVerifyOfCallMethodNumber() {

        List list = Mockito.mock(List.class);

        list.size();
        list.size();

        Mockito.verify(list, Mockito.times(2)).size();
    }

    @Test
    public void testVerifyOfNotCallAllMethod() {

        List list = Mockito.mock(List.class);

        Mockito.verifyZeroInteractions(list);
    }

    @Test
    public void testVerifyOfNotCallSomeOneMethod() {

        List list = Mockito.mock(List.class);

        list.clear();

        //方式一
        //        Mockito.verify(list,Mockito.times(0)).size();

        //方式二
        Mockito.verify(list, Mockito.never()).size();
    }

    @Test
    public void testVerifyNoMoreInteractions() {

        List list = Mockito.mock(List.class);

        list.size();

        Mockito.verify(list).size();
        Mockito.verifyNoMoreInteractions(list);
    }

    @Test
    public void testVerifyOfCallMethodOrder() {

        List list = Mockito.mock(List.class);

        list.size();
        list.add("one");
        list.clear();

        InOrder order = Mockito.inOrder(list);
        order.verify(list).size();
        order.verify(list).add("one");
        order.verify(list).clear();
    }

    @Test
    public void testVerifyOfCallMethodNum() {

        List list = Mockito.mock(List.class);

        list.clear();
        list.clear();
        list.clear();

        Mockito.verify(list, Mockito.atLeast(1)).clear();
        Mockito.verify(list, Mockito.atMost(4)).clear();
    }

    @Test
    public void testVerifyOfSpecifyParam(){

        List<String> list = Mockito.mock(List.class);

        list.add("test");

        Mockito.verify(list).add("test");
        //匹配器
        Mockito.verify(list).add(Mockito.anyString());
    }

    /**
     * 二、测试桩
     */

    @Test
    public void testStub(){

        LinkedList linkedList = Mockito.mock(LinkedList.class);

        Mockito.when(linkedList.get(0)).thenReturn("first");
        Mockito.when(linkedList.get(1)).thenReturn(new RuntimeException());

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));

        Mockito.verify(linkedList).get(0);

    }

    @Test
    public void testArgument(){

        List list = Mockito.mock(List.class);

        Mockito.when(list.contains(Mockito.argThat(isValid()))).thenReturn(true);

        System.out.println(list.contains("2"));

    }

    private ArgumentMatcher isValid(){


        return new ArgumentMatcher(){

            @Override
            public boolean matches(Object o) {

                if("1".equals(o)){
                    return true;
                }

                return false;
            }
        };
    }


}
