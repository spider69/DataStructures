package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryHeapTest {

    @Test
    void siftUp() {
        BinaryHeap binaryHeap = new BinaryHeap(Arrays.asList(42, 29, 18, 14, 7, 18, 12, 11, 13, 100));
        binaryHeap.siftUpLastElement();
        assertEquals(Arrays.asList(100, 42, 18, 14, 29, 18, 12, 11, 13, 7), binaryHeap.getHeap());
    }

    @Test
    void siftDown() {
        BinaryHeap binaryHeap = new BinaryHeap(Arrays.asList(1, 42, 29, 18, 14, 7));
        binaryHeap.siftDown(0);
        assertEquals(Arrays.asList(42, 18, 29, 1, 14, 7), binaryHeap.getHeap());
    }
}