
public class SinglyLinkedList<E>{
    private static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> nextNode){
            this.data = data;
            this.next = nextNode;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    // O(n)
    public void printList(){
        Node<E> current = head;
        while(current != null){
            System.out.println(current.getData());
            current = current.next;
        }
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // O(1)
    public E first(){
        return head.getData();
    }

    // O(1)
    public E last(){
        return tail.getData();
    }

    // O(1)
    public void addFirst(E element){
        if(isEmpty()){
            Node<E> newNode = new Node<>(element, null);
            head = newNode;
            tail = newNode;
        }else{
            head = new Node<>(element, head);
        }
        size++;
    }

    // O(1)
    public void addLast(E element){
        if(isEmpty()){
            Node<E> newNode = new Node<>(element, null);
            head = newNode;
            tail = newNode;
        }else{
            Node<E> newNode = new Node<>(element, null);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public E removeFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("There are no elements to remove.");
        }
        Node<E> toBeDeleted = head;
        head = toBeDeleted.getNext();
        size--;
        return toBeDeleted.getData();
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
