import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{9,8,7,6,5,4,3,2,1010};
        MinHeap heap = new MinHeap(new ArrayList<>(Arrays.asList(arr)));
        heap.insert(1);
        heap.insert(-111);
        // Heap sort demonstration ( Only printing ).
        while(heap.size() > 0){
            System.out.println(heap.remove());
        }
    }
}
