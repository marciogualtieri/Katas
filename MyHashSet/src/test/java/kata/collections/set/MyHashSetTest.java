package kata.collections.set;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MyHashSetTest {

    private Set<String> testSet;
    private static final String MOE = "moe";
    private static final String[] ORIGINAL_STOOGES = {MOE, "larry", "curly"};
    private static final String SHEMP = "shemp";
    private static final String[] NEW_STOOGES = {SHEMP, "joe", "curlyjoe"};
    private static final String[] ALL_STOOGES = ArrayUtils.addAll(ORIGINAL_STOOGES, NEW_STOOGES);
    @Before
    public void before() throws Exception {
        testSet = new MyHashSet<String>();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void whenCreateEmptySet_thenSizeIsZero() throws Exception {
        assertThat(testSet.size(), equalTo(0));
    }

    @Test
    public void whenSetIsEmpty_thenIsEmptyIsTrue() throws Exception {
        assertThat(testSet.isEmpty(), equalTo(true));
    }

    @Test
    public void whenSetIsNotEmpty_thenIsEmptyIsFalse() throws Exception {
        addMoeToTestSet();
        assertThat(testSet.isEmpty(), equalTo(false));
    }

    @Test
    public void whenAddMoeToEmptySet_thenSetContainsMoe() throws Exception {
        addMoeToTestSet();
        assertThat(testSet.contains(MOE), equalTo(true));
    }

    @Test
    public void whenAddOriginalStooges_thenSetDoesNotContainShemp() throws Exception {
        addOriginalStoogesToTestSet();
        assertThat(testSet.contains(SHEMP), equalTo(false));
    }

    @Test
    public void testIterator() throws Exception {
        addOriginalStoogesToTestSet();
        List<String> iteratorAsList = Lists.newArrayList(testSet.iterator());
        assertThat(iteratorAsList, containsInAnyOrder(ORIGINAL_STOOGES));
    }

    @Test
    public void whenSetToArray_thenGetArray() throws Exception {
        addOriginalStoogesToTestSet();
        Object[] expectedObjectArray = testSet.toArray();
        String[] expectedStringArray = Arrays.copyOf(expectedObjectArray, expectedObjectArray.length, String[].class);
        assertThat(Arrays.asList(expectedStringArray), containsInAnyOrder(ORIGINAL_STOOGES));
    }

    @Test
    public void whenAddMoeToEmptySet_thenElementMoeExists() throws Exception {
        addMoeToTestSet();
        assertThat(testSet, hasSize(1));
        assertThat(testSet, contains(MOE));
    }

    @Test
    public void whenAddOriginalStoogesToEmptySet_thenOriginalStoogesExist() throws Exception {
        addOriginalStoogesToTestSet();
        assertThat(testSet, containsInAnyOrder(ORIGINAL_STOOGES));
    }

    @Test
    public void whenRemoveMoeFromSetWithOriginalStooges_thenMoeDoesNotExist() throws Exception {
        addOriginalStoogesToTestSet();
        assertThat(testSet, containsInAnyOrder(ORIGINAL_STOOGES));
        assertThat(testSet, hasSize(ORIGINAL_STOOGES.length));
        testSet.remove(MOE);
        assertThat(testSet, hasSize(ORIGINAL_STOOGES.length - 1));
        assertThat(testSet.contains(MOE), equalTo(false));
    }

    @Test
    public void whenClearSet_thenSetIsEmpty() throws Exception {
        addOriginalStoogesToTestSet();
        assertThat(testSet, containsInAnyOrder(ORIGINAL_STOOGES));
        testSet.clear();
        assertThat(testSet, hasSize(0));
    }

    @Test
    public void whenRemoveNewStoogesFromAllStooges_thenGetOriginalStooges() throws Exception {
        addAllStoogesToTestSet();
        assertThat(testSet, containsInAnyOrder(ALL_STOOGES));
        testSet.removeAll(Arrays.asList(NEW_STOOGES));
        assertThat(testSet, containsInAnyOrder(ORIGINAL_STOOGES));
    }

    @Test
    public void whenRetainNewStoogesFromAllStooges_thenGetNewStooges() throws Exception {
        addAllStoogesToTestSet();
        assertThat(testSet, containsInAnyOrder(ALL_STOOGES));
        testSet.retainAll(Arrays.asList(NEW_STOOGES));
        assertThat(testSet, containsInAnyOrder(NEW_STOOGES));
    }

    @Test
    public void whenSetHasAllStooges_ThenSetContainsOriginalAndNewStooges() throws Exception {
        addAllStoogesToTestSet();
        assertThat(testSet, containsInAnyOrder(ALL_STOOGES));
        assertThat(testSet.containsAll(Arrays.asList(ORIGINAL_STOOGES)), equalTo(true));
        assertThat(testSet.containsAll(Arrays.asList(NEW_STOOGES)), equalTo(true));
    }

    @Test
    public void whenSetToArrayWithSpecificType_thenGetArray() throws Exception {
        addOriginalStoogesToTestSet();
        String[] expectedStringArray = testSet.toArray(new String[ORIGINAL_STOOGES.length]);
        assertThat(Arrays.asList(expectedStringArray), containsInAnyOrder(ORIGINAL_STOOGES));
    }

    private void addMoeToTestSet() {
        String testElement = MOE;
        testSet.add(testElement);
    }

    private void addOriginalStoogesToTestSet() {
        testSet.addAll(Arrays.asList(ORIGINAL_STOOGES));
    }

    private void addNewStoogesToTestSet() {
        testSet.addAll(Arrays.asList(NEW_STOOGES));
    }

    private void addAllStoogesToTestSet() {
        testSet.addAll(Arrays.asList(ORIGINAL_STOOGES));
        testSet.addAll(Arrays.asList(NEW_STOOGES));
    }
}