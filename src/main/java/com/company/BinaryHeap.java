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
    }

    void insert(int value, int idx) {
        heap.add(idx, value);
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
        while (idx < heap.size() && getLeftChildIdx(idx) < heap.size() && getRightChildIdx(idx) < heap.size()) {
            int siftingValue = heap.get(idx);
            int leftChildIdx = getLeftChildIdx(idx);
            int leftChildValue = heap.get(leftChildIdx);
            int rightChildIdx = getRightChildIdx(idx);
            int rightChildValue = heap.get(rightChildIdx);
            if (leftChildValue > siftingValue) {
                swap(leftChildIdx, idx);
                idx = leftChildIdx;
                continue;
            }
            if (rightChildValue > siftingValue) {
                swap(rightChildIdx, idx);
                idx = rightChildIdx;
                continue;
            }
            break;
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
