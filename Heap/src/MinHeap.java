import java.util.ArrayList;
import java.util.List;


/**
 * Min heap class.
 */
public class MinHeap {

    List<Integer> heap;

    public MinHeap(List<Integer> array){
        heap = buildHeap(array);
    }

    private List<Integer> buildHeap(List<Integer> array) {
        int parentIndex = (array.size()-1)/2;
        for(int currentIndex = parentIndex; currentIndex >=0; currentIndex--){
            siftDown(currentIndex,array.size()-1,array);
        }
        return array;
    }

    private void siftUp(int currentIndex, List<Integer> heap){
        if(currentIndex < 0){
            throw new IllegalArgumentException("Invalid Index provided");
        }
        int parentIndex = (currentIndex - 1) / 2;

        //swap until it satisfies the "heap property"
        while(parentIndex > 0 && heap.get(currentIndex) < heap.get(parentIndex)){

            //swap
            int tmp = heap.get(currentIndex);
            heap.set(currentIndex, heap.get(parentIndex));
            heap.set(parentIndex,tmp);


            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }

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

    public void insert(int element){
        //1. Insert element at the back
        heap.add(element);
        //2. Sift the element up.
        siftUp(heap.size()-1, heap);
    }

    public int size(){
        return heap.size();
    }

    public int peek(){
        // As smallest element is always on top.
        return heap.get(0);
    }

}

