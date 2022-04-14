import java.util.Map;
import java.util.PriorityQueue;
import java.util.Vector;

/**
 * ICA 25
 * pages 428 - 435
 */

public class Huffman {
    public static void min_heap_insert(Vector<Node> input, Node key_node) {
        Integer size = input.size();
        input.addElement(new Node("", Integer.MAX_VALUE));
        heap_decrease_key(input, size, key_node);
    }

    public static void heap_decrease_key(Vector<Node> input, Integer i, Node key_node) {
        if (key_node.get_freq() > input.elementAt(i).get_freq()) {
            System.out.println("new key is larger than current key");
            return;
        }
        input.set(i, new Node(key_node));
        while (i > 0 && input.elementAt(parent(i)).get_freq() > input.elementAt(i).get_freq()) {
            Node temp = new Node(input.elementAt(parent(i)));
            input.set(parent(i), new Node(input.elementAt(i)));
            input.set(i, new Node(temp));
            i = parent(i);
        }
    }

    public static Node heap_minimium(Vector<Node> input) {
        return input.elementAt(0);
    }

    public static Node heap_extract_min(Vector<Node> input) {
        if (input.size() < 1 ) {
            System.out.println("heap underflow");
            return new Node(STRING_MIN_VALUE, 0);
        }
        Node min = input.elementAt(0);
        input.set(0, new Node(input.elementAt(input.size() - 1)));
        input.remove(input.size() - 1);
        min_heapify(input, 0);
        return min;
    }

    public static void min_heapify(Vector<Node> input, Integer i) {
        Integer l = left(i);
        Integer r = right(i);
        Integer smallest;

        if (l < input.size() && input.elementAt(l).get_freq() < input.elementAt(i).get_freq()) {
            smallest = l;
        } else {
            smallest = i;
        }
        if (r < input.size() && input.elementAt(r).get_freq() < input.elementAt(i).get_freq()) {
            smallest = r;
        }
        if (!smallest.equals(i)) {
            Node temp = new Node(input.elementAt(i));
            input.set(i, new Node(input.elementAt(smallest)));
            input.set(smallest, new Node(temp));
            min_heapify(input, smallest);
        }
    }

    public static Integer parent(Integer i){
        return i / 2;
    }

    public static Integer left(Integer i){
        return  2 * i;
    }

    public static Integer right(Integer i){
        return 2 * i + 1;
    }

    public static void print_heap(Vector<Node> input){
        Vector<Node> tempHeap = new Vector<Node>();
        while(input.size() > 0){
            Node temp = new Node(heap_extract_min(input));
            temp.print();
            System.out.println(" ");
            min_heap_insert(tempHeap, new Node(temp));
        }
        System.out.println();

        while(tempHeap.size() > 0){
            min_heap_insert(input, heap_extract_min(tempHeap));
        }
    }

    public static void print_heap_data(Vector<Node> input){
        for(int i = 0; i < input.size(); i++){
            input.elementAt(i).print();
            System.out.print("|");
        }
        System.out.println();
    }

    //TODO: make method here that uses map to get frequencies of the string
    // that is passed into huffman method

    public static void freq() {
        System.out.println("test");
    }

    public static Node huffman(String input){
        int n = input.length();
        String Q = input;
//        Vector<Node> que = new Vector<>();
//        que.elementAt(0).set_freq(input.substring(0,1));
//        que.set(0, input.substring(0,1));
//        Node que = new Node();
//        PriorityQueue<String> data = new PriorityQueue<>();

        for(int i = 1; i < n - 1; i++){
            Node z = new Node();
//            Node que = new Node();
//            heap_extract_min(que);
            Node x = heap_extract_min(Q);
            Node y = heap_extract_min(Q);
            z.left = x;
            z.right = y;
            z.freq = x.freq + y.freq;
            min_heap_insert(Q, z); // return the root of the tree
        }
        return heap_extract_min(Q);
    }

    public void print_tree(Node input){
        if(input != null){
            print_tree(input.get_left());
            input.print();
            print_tree(input.get_right());
        }
    }

    public static void main(String[] args) {
        String C = new String("ecabafab");
        Node tree = huffman(C);
        tree.print();
        System.out.println();
        C = new String("ajklfjioeab");
        tree = huffman(C);
        tree.print();
    }

    static String STRING_MAX_VALUE = "{";
    static String STRING_MIN_VALUE = "`";
}

class Node {
    public Node(){
        key = "";
        freq = 0;
        left = null;
        right = null;
    }

    public Node(Node input){
        key = input.get_key();
        freq = input.get_freq();
        left = input.get_left();
        right = input.get_right();
    }

    public Node(String key_input, Integer freq_input){
        key = key_input;
        freq = freq_input;
        left = null;
        right = null;
    }

    public String get_key(){
        return key;
    }

    public void set_key(String input){
        key = input;
    }

    public Integer get_freq(){
        return freq;
    }

    public void set_freq(Integer input){
        freq = input;
    }

    public Node get_left(){
        return left;
    }

    public void set_left(Node input){
        left = input;
    }

    public Node get_right(){
        return right;
    }

    public void set_right(Node input){
        right = input;
    }

    public void print(){
        System.out.print(key +  "," + freq);
    }

    String key;
    Integer freq;
    Node left;
    Node right;
}
