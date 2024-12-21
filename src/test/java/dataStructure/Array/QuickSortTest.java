package dataStructure.Array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortTest {
    @Test
    public void testQuickSort(){
        int[] actual = {5,1,6,2,3,4};
        int[] expected = {1,2,3,4,5,6};

        QuickSort.quickSort(actual);

        Assertions.assertArrayEquals(expected,actual);
    }
}