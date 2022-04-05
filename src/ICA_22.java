import java.util.Vector;

/**
 * pages 397 - 403
 */

public class ICA_22 {
    static Vector<Vector<Double>> e;
    static Vector<Vector<Integer>> root;

    public static void optimal_bst(Vector<Double> p, Vector<Double> q, Integer n) {
        // your code here
        for (int i = 1; i < n + 1; i++) {

        }

        for (int l = 1; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                //
                int j = i + l - 1;
                for (int r = i; r < j; r++) {
                    //
                    // if (t < e) {}
                }
            }
        }
    }

    public static void main(String[] args) {
        Vector<Double> p = new Vector<Double>();
        Vector<Double> q = new Vector<Double>();
        Integer n = 5;

        p.addElement(0.0);
        p.addElement(0.15);
        p.addElement(0.10);
        p.addElement(0.05);
        p.addElement(0.10);
        p.addElement(0.20);

        q.addElement(0.05);
        q.addElement(0.10);
        q.addElement(0.05);
        q.addElement(0.05);
        q.addElement(0.05);
        q.addElement(0.10);

        optimal_bst(p, q, n);

        for(int i = 0; i < e.size(); i++) {
            System.out.println(e.elementAt(i));
        }

        for (int i = 0; i < root.size(); i++) {
            System.out.println(root.elementAt(i));
        }
    }
}
