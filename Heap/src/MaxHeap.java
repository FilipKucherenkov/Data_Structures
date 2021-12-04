import java.util.List;


/**
 * Class to represent A Max Heap data structure. Largest Integer is always on top.
 */
public class MaxHeap {

    private List<Integer> heap;

    /**
     * Constructor for class MaxHeap. Takes a list of integers and builds a heap from them.
     * @param arr - the given list.
     */
    public MaxHeap(List<Integer> arr){
        heap = buildHeap(arr);
    }

    /**
     * Given a list of integers build a Max-heap.
     * @param arr - given list.
     * @return - heap
     */
    private List<Integer> buildHeap(List<Integer> arr) {
        int firstParentIndex = ((arr.size()-1)-1) / 2;
        for(int parent = firstParentIndex; parent >= 0; parent--){
            siftDown(parent, arr.size()-1, arr);
        }
        return arr;
    }

    /**
     * Sift an element up until it's on it's place.
     * @param currentIndex - index at which to start sifting.
     * @param heap - the heap.
     */
    private void siftUp(int currentIndex, List<Integer> heap){
        int parentIndex = (currentIndex-1) / 2;
        while (currentIndex > 0 && heap.get(parentIndex) < heap.get(currentIndex)){
            //swap them
            swap(currentIndex, parentIndex, heap);
            currentIndex = parentIndex;
            parentIndex = (currentIndex-1) / 2;
        }
    }

    /**
     * Sift an element down until it's on it's right place.
     * @param currentIndex - index at which sifting starts.
     * @param endIndex - last index in the heap.
     * @param heap - the heap.
     */
    private void siftDown(int currentIndex, int endIndex, List<Integer> heap){
        int leftChildIndex = currentIndex * 2 + 1;
        while(leftChildIndex <= endIndex){
            int rightChildIndex = currentIndex * 2 + 2 <= endIndex ? currentIndex * 2 + 2 : -1;

            int biggerChildIndex;
            if (rightChildIndex == -1){
                biggerChildIndex = leftChildIndex;
            }else{
                if(heap.get(leftChildIndex) >= heap.get(rightChildIndex)){
                    biggerChildIndex = leftChildIndex;
                }else{
                    biggerChildIndex = rightChildIndex;
                }
            }

            if(heap.get(currentIndex) < heap.get(biggerChildIndex)){
                // swap
                swap(currentIndex, biggerChildIndex, heap);
                currentIndex = biggerChildIndex;
                leftChildIndex = currentIndex * 2 + 1;
            }else{
                return;
            }
        }
    }
    /**
     * Insert a new element in the heap.
     * @param value - element to be inserted.
     */
    public void insert(int value){
        //1. add a new node to the end of the heap.
        heap.add(value);

        //2. Sift the value to it's right place.
        siftUp(heap.size()-1, heap);
    }

    /**
     * Remove the largest element of the heap.
     * @return the removed element.
     */
    public int remove(){
        //1. swap first with last.
        swap(0, heap.size()-1, heap);
        //2. remove the last one.
        int removed = heap.remove(heap.size()-1);
        //3. sift the first down to it's right place.
        siftDown(0,heap.size()-1, heap);

        return removed;
    }

    /**
     * Swap two elements in the heap
     * @param first - index of first element.
     * @param second - index of second element.
     * @param heap - List of integers which represents the heap.
     */
    private void swap(int first, int second, List<Integer> heap) {
        int tmp = heap.get(first);
        heap.set(first,heap.get(second));
        heap.set(second, tmp);
    }

    /**
     * @return the largest element in the heap.
     */
    public int peek(){
        return heap.get(0);
    }

    /**
     * @return the size of the heap.
     */
    public int size(){
        return heap.size();
    }


}
