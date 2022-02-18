package com.jwetherell.algorithms.data_structures.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Collection;

import org.junit.Test;

import com.jwetherell.algorithms.data_structures.BinaryHeap;
import com.jwetherell.algorithms.data_structures.test.common.JavaCollectionTest;
import com.jwetherell.algorithms.data_structures.test.common.HeapTest;
import com.jwetherell.algorithms.data_structures.test.common.Utils;
import com.jwetherell.algorithms.data_structures.test.common.Utils.TestData;

public class BinaryHeapTests {

    @Test
    public void testMinHeap() {
        TestData data = Utils.generateTestData(2500);

        String aNameMin = "Min-Heap [array]";
        BinaryHeap.BinaryHeapArray<Integer> aHeapMin = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MIN);
        Collection<Integer> aCollectionMin = aHeapMin.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MIN, aHeapMin, Integer.class, aNameMin,  
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(aCollectionMin, Integer.class, aNameMin,
                                                     data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapArray<Integer> aHeapNull = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MIN);
        aHeapNull.add(10);
        aHeapNull.add(11);
        aHeapNull.clear();
        assertNull(aHeapNull.getHeadValue()); // we expect null here

        String tNameMin = "Min-Heap [tree]";
        BinaryHeap.BinaryHeapTree<Integer> tHeapMin = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MIN);
        Collection<Integer> tCollectionMin = tHeapMin.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MIN, tHeapMin, Integer.class, tNameMin,
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(tCollectionMin, Integer.class, tNameMin,
                                                     data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapTree<Integer> tHeapNull = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MIN);
        tHeapNull.add(10);
        tHeapNull.add(11);
        tHeapNull.clear();
        assertNull(tHeapNull.getHeadValue()); // we expect null here

    }

    @Test
    public void testMaxHeap() {
        TestData data = Utils.generateTestData(2500);

        String aNameMax = "Max-Heap [array]";
        BinaryHeap.BinaryHeapArray<Integer> aHeapMax = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MAX);
        Collection<Integer> aCollectionMax = aHeapMax.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MAX, aHeapMax, Integer.class, aNameMax, 
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(aCollectionMax, Integer.class, aNameMax,
                                                 data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapArray<Integer> aHeapNull = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MAX);
        aHeapNull.add(10);
        aHeapNull.add(11);
        aHeapNull.clear();
        assertNull(aHeapNull.getHeadValue()); // we expect null here

        String lNameMax = "Max-Heap [tree]";
        BinaryHeap.BinaryHeapTree<Integer> tHeapMax = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MAX);
        Collection<Integer> tCollectionMax = tHeapMax.toCollection();
        assertTrue(HeapTest.testHeap(BinaryHeap.Type.MAX, tHeapMax, Integer.class, lNameMax, 
                                     data.unsorted, data.sorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(tCollectionMax, Integer.class, lNameMax,
                                                 data.unsorted, data.sorted, data.invalid));

        BinaryHeap.BinaryHeapTree<Integer> tHeapNull = new BinaryHeap.BinaryHeapTree<Integer>(BinaryHeap.Type.MAX);
        tHeapNull.add(10);
        tHeapNull.add(11);
        tHeapNull.clear();
        assertNull(tHeapNull.getHeadValue()); // we expect null here
    }

    // Exercices case in `BinaryHeapArray.heapDown` when the parent is less than
    // both its children, but the children are equal
    @Test
    public void testHeapDownChildrenLessButEqualMax() {
        BinaryHeap.BinaryHeapArray<Integer> aMaxHeap = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MAX);
        aMaxHeap.add(7);
        aMaxHeap.add(3);
        aMaxHeap.add(3);
        aMaxHeap.add(2);
        assertEquals(7, (int)aMaxHeap.removeHead());
        assertEquals(3, (int)aMaxHeap.removeHead());
        assertEquals(3, (int)aMaxHeap.removeHead());
        assertEquals(2, (int)aMaxHeap.removeHead());
        assertNull(aMaxHeap.removeHead());
    }

    // Exercices case in `BinaryHeapArray.heapDown` when the parent is greater than
    // both its children, but the children are equal
    @Test
    public void testHeapDownChildrenLessButEqualMin() {
        BinaryHeap.BinaryHeapArray<Integer> aMinHeap = new BinaryHeap.BinaryHeapArray<Integer>(BinaryHeap.Type.MIN);
        aMinHeap.add(2);
        aMinHeap.add(3);
        aMinHeap.add(3);
        aMinHeap.add(7);
        assertEquals(2, (int)aMinHeap.removeHead());
        assertEquals(3, (int)aMinHeap.removeHead());
        assertEquals(3, (int)aMinHeap.removeHead());
        assertEquals(7, (int)aMinHeap.removeHead());
        assertNull(aMinHeap.removeHead());
    }
}
