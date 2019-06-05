package com.zhaoshg.test.other;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @className: CollectionsTest
 *
 * @description:
 *
 * @author zhaoshuguang
 *
 * @Date 2019-05-15
 */
public class CollectionsTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testUnmodifiableList() {
        List<String> tempList = new ArrayList<>(Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6"}));
        List<String> list = Collections.unmodifiableList(tempList);
        exception.expect(UnsupportedOperationException.class);
        list.add("7");
    }
}