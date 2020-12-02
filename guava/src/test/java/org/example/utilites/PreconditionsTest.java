package org.example.utilites;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;

/**
 * @author: 吕东杰
 * @description: 断言类测试
 * @create: 2020-12-02 18:46
 **/
public class PreconditionsTest {

    private void checkNotNull(final List<String> list){
        Preconditions.checkNotNull(list);
    }

    @Test(expected = NullPointerException.class)
    public void testCheckNotNull(){
        checkNotNull(null);
    }

    @Test
    public void testCheckNotNullWithMessage(){
        Preconditions.checkNotNull(null,"The should not be null");
    }

    @Test
    public void testCheckArgument(){
        final String type = "A";
        Preconditions.checkArgument(type.equals("A"));
    }

    @Test
    public void testCheckState(){
        final String type = "A";
        try {
            Preconditions.checkState(type.equals("B"));
        }catch (Exception e){
            Assert.assertSame(e.getClass(), IllegalStateException.class);
        }

    }

    @Test
    public void testCheckElementIndex(){
        try {
            List<String> list = ImmutableList.of();
            Preconditions.checkElementIndex(10,list.size());
        }catch (Exception e){
            Assert.assertSame(e.getClass(), IndexOutOfBoundsException.class);
        }

    }

    @Test
    public void testByObjects(){
        try {
            Objects.isNull(null);
        }catch (Exception e){
            Assert.assertSame(e.getClass(), NullPointerException.class);
        }

    }



}
