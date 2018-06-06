package kata.sort.mergesort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MergeSortTest {

    private static final List<Integer> theList = new ArrayList<Integer>(Arrays.asList(101, 19, 86, 72, 56, 35, 47));
    private static final List<Integer> theSortedList = new ArrayList<Integer>(Arrays.asList(19, 35, 47, 56, 72, 86, 101));
    private MergeSort sorter;

    @Before
    public void before() throws Exception {
        sorter = new MergeSort();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void when_InputUnsortedList_then_ReturnSortedList() throws Exception {
        assertThat(sorter.sort(theList), equalTo(theSortedList));
    }
} 
