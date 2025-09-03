class MyLinkedList {

    public class Node {
        private int val; 
        private Node next; 
        
        public Node (){}
        
        public Node (int value) {
            val = value; 
            next = null; 
        }
    }

    private Node head; 
    private Node tail; 
    private int size; 

    public MyLinkedList() {
        head = null;
        tail = null; 
        size = 0;
    }
    
    public int get(int index) {
        if (index >= size) return -1;
        Node curr = head;
        for (int i = 0; i < index; i++){
            curr = curr.next; 
        }
        return curr.val; 
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val); 
        if (tail == null) {
            tail = newNode; 
            head = newNode;
        }else {
            tail.next = newNode; 
            tail = newNode;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) { 
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node newNode = new Node(val);
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node nextNode = temp.next;
        temp.next = newNode;
        newNode.next = nextNode; 
        if (newNode.next == null) {
            tail = newNode;
        }
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index >= size) { 
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        if (temp.next == null) {
            tail = temp;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
