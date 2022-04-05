import java.lang.invoke.VolatileCallSite;
import java.util.Vector;

/**
 * pages 397 - 403
 */

public class ICA_22 {
    static Vector<Vector<Double>> e;
    static Vector<Vector<Integer>> root;

    public static void optimal_bst(Vector<Double> p, Vector<Double> q, Integer n) {
        // your code here
        Double Maxy = Double.MAX_VALUE;
        e = new Vector<>();
        root = new Vector<>();
        Vector<Vector<Double>> w = new Vector<>();
        for (int i = 0; i < n; i++) {
            e.addElement(new Vector<>());
            root.addElement(new Vector<>());
            w.addElement(new Vector<>());
            for (int j = 0; j < n; j++) {
                e.elementAt(i).addElement( 0.0);
                root.elementAt(i).addElement(0);
                w.elementAt(i).addElement(0.0);
            }
        }

//        for (int i = 1; i < n + 1; i++) {
//            e.elementAt(i - 1).set(i - 1, q.elementAt(i - 1));
//            w.elementAt(i - 1).set(i - 1, q.elementAt(i - 1));
//        }

        for (int i = 0; i < n; i++) {
            e.elementAt(i).set(i, q.elementAt(i));
            w.elementAt(i).set(i, q.elementAt(i));
        }

        for (int l = 1; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                //
                int j = i + l - 1;
                e.elementAt(i - 1).set(j, Maxy);
                w.elementAt(i - 1).set(j, w.elementAt(i - 1).elementAt(j) +
                        p.elementAt(j) + q.elementAt(j));
                for (int r = i; r < j; r++) {
                    //
                    Double t = e.elementAt(i - 1).elementAt(r - 1)
                            + e.elementAt(r + 1).elementAt(j)
                            + w.elementAt(i - 1).elementAt(j);
                    // if (t < e) {}
                    if (t < e.elementAt(i).elementAt(j)) {
                        e.elementAt(i - 1).set(j, t);
                        root.elementAt(i - 1).set(j, r);
                    }
                }
            }
        }
        // return is handled by having the data be global
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
