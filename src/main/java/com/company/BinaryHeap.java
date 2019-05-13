package com.company;

import java.util.ArrayList;
import java.util.List;

class BinaryHeap {
    private final List<Integer> heap;

    BinaryHeap() {
        this.heap = new ArrayList<>();
    }

    BinaryHeap(List<Integer> heap) {
        this.heap = new ArrayList<>(heap);
    }

    void insert(int value) {
        heap.add(value);
        siftUpLastElement();
    }

    int extractMax() {
        int max = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0);
        return max;
    }

    void siftUp(int idx) {
        while (idx > 0) {
            int siftingValue = heap.get(idx);
            int parentIdx = getParentIdx(idx);
            int parentValue = heap.get(parentIdx);
            if (parentValue < siftingValue) {
                swap(parentIdx, idx);
                idx = parentIdx;
                continue;
            }
            break;
        }
    }

    void siftDown(int idx) {
        int siftingValue = heap.get(idx);
        int leftChildIdx = getLeftChildIdx(idx);
        if (leftChildIdx < heap.size()) {
            int leftChildValue = heap.get(leftChildIdx);
            if (siftingValue < leftChildValue) {
                swap(leftChildIdx, idx);
                siftDown(leftChildIdx);
                return;
            }
        }

        int rightChildIdx = getRightChildIdx(idx);
        if (rightChildIdx < heap.size()) {
            int rightChildValue = heap.get(rightChildIdx);
            if (siftingValue < rightChildValue) {
                swap(rightChildIdx, idx);
                siftDown(rightChildIdx);
            }
        }
    }

    void siftUpLastElement() {
        int idx = heap.size() - 1;
        siftUp(idx);
    }

    List<Integer> getHeap() {
        return heap;
    }

    private void swap(int firstIdx, int secondIdx) {
        int temp = heap.get(firstIdx);
        heap.set(firstIdx, heap.get(secondIdx));
        heap.set(secondIdx, temp);
    }

    private int getParentIdx(int childIdx) {
        return (childIdx - 1) / 2;
    }

    private int getLeftChildIdx(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    private int getRightChildIdx(int parentIdx) {
        return 2 * parentIdx + 2;
    }
}
