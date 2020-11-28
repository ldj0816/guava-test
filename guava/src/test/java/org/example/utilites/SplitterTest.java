package org.example.utilites;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author: 吕东杰
 * @description: Splitter测试
 * @create: 2020-11-28 14:58
 **/

public class SplitterTest {

    @Test
    public void testSplitter(){
        List<String> list = Splitter.on("|").splitToList("Hello|World");
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(),2);
    }

    @Test
    public void testSplitter_omit_empty(){
        List<String> list = Splitter.on("|").omitEmptyStrings().splitToList("Hello|World|||");
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(),2);
    }

    @Test
    public void testSplitter_omit_empty2(){
        List<String> list = Splitter.on("|").omitEmptyStrings().splitToList("Hello | World|||");
        Assert.assertNotNull(list);
        Assert.assertEquals(list.get(0),"Hello ");
    }

    @Test
    public void testSplitter_omit_empty2_trim(){
        List<String> list = Splitter.on("|").trimResults().omitEmptyStrings().splitToList("Hello | World|||");
        Assert.assertNotNull(list);
        Assert.assertEquals(list.get(0),"Hello");
    }

    @Test
    public void testSplitter_omit_empty2_trim_fixedLength(){
        List<String> list = Splitter.fixedLength(4).trimResults().omitEmptyStrings().splitToList("Hello | World|||");
        Assert.assertNotNull(list);
        System.out.println(list.toString());
    }

    @Test
    public void testSplitter_limit(){
        List<String> list = Splitter.on("|").limit(3).splitToList("Hello|World|java|guava|go");
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(),3);
        System.out.println(list.toString());
    }

    @Test
    public void onPattern(){
        List<String> list = Splitter.onPattern("\\|").splitToList("Hello|World|java|guava|go");
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(),5);
        System.out.println(list.toString());
    }

    @Test
    public void testSplitter_omit_empty_map(){
        Map<String, String> split = Splitter.on("|").omitEmptyStrings().withKeyValueSeparator("+").split("Hello+Java|World+Cuava|||");
        System.out.println(split.toString());
        Assert.assertNotNull(split);
        Assert.assertEquals("Java",split.get("Hello"));
    }
}
