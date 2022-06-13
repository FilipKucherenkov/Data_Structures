import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
//        Integer[] arr = new Integer[]{9,8,7,6,5,4,3,2,1010};
//        MaxHeap heap = new MaxHeap(new ArrayList<>(Arrays.asList(arr)));
//        heap.insert(1);
//        heap.insert(-111);
//        // Heap sort demonstration ( Only printing ).
//        while(heap.size() > 0){
//            System.out.println(heap.remove());
//        }

        SinglyLinkedList<Integer> lst = new SinglyLinkedList<>();
        lst.addLast(2);
        lst.addFirst(5);
        lst.addFirst(4);
        lst.addFirst(3);
        lst.addLast(33);
        if (lst.size() != 5) throw new AssertionError();

        lst.removeFirst();
        lst.removeFirst();
        if (lst.size() != 3) throw new AssertionError();
        lst.printList();

    }
}
