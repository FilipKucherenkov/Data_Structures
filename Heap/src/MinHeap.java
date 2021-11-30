import java.util.ArrayList;
import java.util.List;


/**
 * Min-Heap data structure. Smallest integer is always on top.
 */
public class MinHeap {

    private List<Integer> heap;

    /**
     * Constructor for class MinHeap. Takes an array of integers and builds a heap from them.
     * @param array - the given array.
     */
    public MinHeap(List<Integer> array){
        heap = buildHeap(array);
    }

    /**
     * Given an array of integers build a Min-heap.
     * @param array - given array.
     * @return - heap
     */
    private List<Integer> buildHeap(List<Integer> array) {
        int parentIndex = (array.size()-1)/2;
        for(int currentIndex = parentIndex; currentIndex >=0; currentIndex--){
            siftDown(currentIndex,array.size()-1,array);
        }
        return array;
    }

    /**
     * Sift an element up until it's on it's place.
     * @param currentIndex - index at which to start sifting.
     * @param heap - the heap.
     */
    private void siftUp(int currentIndex, List<Integer> heap){
        if(currentIndex < 0){
            throw new IllegalArgumentException("Invalid Index provided");
        }
        int parentIndex = (currentIndex - 1) / 2;

        //swap until it satisfies the "heap property"
        while(currentIndex > 0 && heap.get(currentIndex) < heap.get(parentIndex)){
            //swap
            int tmp = heap.get(currentIndex);
            heap.set(currentIndex, heap.get(parentIndex));
            heap.set(parentIndex,tmp);

            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }

    /**
     * Sift an element down until it's on it's right place.
     * @param currentIndex - index at which sifting starts.
     * @param endIndex - last index in the heap.
     * @param heap - the heap.
     */
    private void siftDown(int currentIndex, int endIndex, List<Integer> heap){
        if(currentIndex < 0){
            throw new IllegalArgumentException("Invalid Index provided");
        }

        int leftIndex = currentIndex * 2 + 1;

        while(leftIndex <= endIndex){
            int rightIndex = currentIndex * 2 + 2;

            int smallerChild;
            if(rightIndex <= endIndex && heap.get(rightIndex) < heap.get(leftIndex)){
                smallerChild = rightIndex;
            }else{
                smallerChild = leftIndex;
            }

            //swap with smaller child.
            if(heap.get(currentIndex) > heap.get(smallerChild)){
                int tmp = heap.get(currentIndex);
                heap.set(currentIndex, heap.get(smallerChild));
                heap.set(smallerChild, tmp);
                currentIndex = smallerChild;
                leftIndex = currentIndex * 2 + 1;
            }else{
                return;
            }
        }
    }

    /**
     * Remove the smallest element of the heap.
     * @return the removed element.
     */
    public int remove(){
        //swap last with first
        // 1. swap first and last
        int tmp = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.set(heap.size()-1, tmp);

        // 2. remove last
        heap.remove(heap.size()-1);

        // sift down the first
        siftDown(0, heap.size()-1, heap);
        return tmp;
    }

    /**
     * Insert a new element in the heap.
     * @param element - element to be inserted.
     */
    public void insert(int element){
        //1. Insert element at the back
        heap.add(element);
        //2. Sift the element up.
        siftUp(heap.size()-1, heap);
    }

    /**
     * @return the size of the heap.
     */
    public int size(){
        return heap.size();
    }

    /**
     * @return the smallest element in the heap.
     */
    public int peek(){
        // As smallest element is always on top.
        return heap.get(0);
    }

}

