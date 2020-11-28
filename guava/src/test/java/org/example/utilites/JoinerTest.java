package org.example.utilites;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: 吕东杰
 * @description: Joiner测试
 * @create: 2020-11-27 20:43
 **/
public class JoinerTest {

    private static final List<String> strList = Arrays.asList("google", "java", "Guava", null, "Scala");

    private static final Map<String,String> strMap = ImmutableMap.of("Hello", "Guava", "java", "Scala");

    @Test
    public void testJoinOnJoin(){
        String result = Joiner.on("#").join(strList);
        System.out.println(result);
        Assert.assertEquals(result,"google#java#Guava#Scala");
    }

    @Test
    public void testJoinOnJoinSkipNull(){
        String result = Joiner.on("#").skipNulls().join(strList);
        System.out.println(result);
        Assert.assertEquals(result,"google#java#Guava#Scala");
    }

    @Test
    public void testJoinOnJoinWithUseNull(){
        String result = Joiner.on("#").useForNull("DEFULT").join(strList);
        System.out.println(result);
        Assert.assertEquals(result,"google#java#Guava#DEFULT#Scala");
    }

    @Test
    public void testJoinOnJoinWithUseNullAppendTo(){
        StringBuilder builder = new StringBuilder("");
        StringBuilder defult = Joiner.on("#").useForNull("DEFULT").appendTo(builder, strList);
        System.out.println(defult.toString());
        Assert.assertSame(builder,defult);
        Assert.assertEquals(builder.toString(),defult.toString());
    }

    @Test
    public void testJoinOnJoinJava8(){
        String collect = strList.stream().filter(str -> str != null && !str.isEmpty()).collect(Collectors.joining("#"));
        Assert.assertEquals(collect,"google#java#Guava#Scala");
    }

    @Test
    public void testJoinOnJoinMap(){
        String join = Joiner.on("#").withKeyValueSeparator("=").join(strMap);
        Assert.assertEquals(join,"google=Guava#java=Scala");
    }
}
