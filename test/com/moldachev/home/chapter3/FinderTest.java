package com.moldachev.home.chapter3;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sergey on 23.03.2016.
 */
public class FinderTest extends TestCase {

    @Test
    public void testGetIndexes() throws Exception {
        Integer[] indexesFirst = Finder.getIndexes(new char[][] {{'a', 'b', 'c'}, {'a'}}, 'a');
        Assert.assertArrayEquals(new Integer[]{0,0}, indexesFirst);

        Integer[] indexesSecond = Finder.getIndexes(new char[][] {{'a', 'b', 'c'}, {'a', 'c'}}, 'c');
        Assert.assertArrayEquals(new Integer[]{2,1}, indexesSecond);

        Integer[] indexesThird = Finder.getIndexes(new char[][] {{'a', 'b', 'c'}, {'a'}}, 'b');
        Assert.assertArrayEquals(new Integer[]{1,null}, indexesThird);

        Integer[] indexesFourth = Finder.getIndexes(new char[][] {{'a', 'b', 'c'}, {'a'}}, 'j');
        Assert.assertArrayEquals(new Integer[]{null,null}, indexesFourth);

        Integer[] indexesFive = Finder.getIndexes(new char[][] {{'a', 'b', 'c'}, {'a', 'j'}}, 'j');
        Assert.assertArrayEquals(new Integer[]{null,1}, indexesFive);
    }
}