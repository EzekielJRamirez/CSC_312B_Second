import java.util.Vector;

public class ICA_17 {

    public static Vector<Vector<Double>> square_matrix_multiply(
            Vector<Vector<Double>> inputA,
            Vector<Vector<Double>> inputB) {
        // n = inputA.rows
        Integer n = inputA.size();
        // let C be a new n x n matrix
        Vector<Vector<Double>> outC = new Vector<>();
//        System.out.println(outC + "\n" + outC.size());
        for (int i = 0;  i < n; i++) {
            outC.addElement(new Vector<>());
            for (int j = 0; j < n; j++) {
//                outC.elementAt(i).elementAt(j).set( (double) 0);
//                outC.elementAt(i).set(j, 0.0);
                outC.elementAt(i).add(0.0);
                for (int k = 0; k < n; k++) {
                    double a = inputA.elementAt(i).elementAt(k);
                    double b = inputB.elementAt(k).elementAt(j);
                    outC.elementAt(i).set(j, outC.elementAt(i).elementAt(j) + a * b);
                }
            }
        }
//        System.out.println(outC + "\n" + outC.size());
        return outC;
    }

    public static void main(String[] args) {
        Vector<Vector<Double>> myDataA = new Vector<>();
        Vector<Vector<Double>> myDataB = new Vector<>();
        Vector<Vector<Double>> myDataC = new Vector<>();

        Integer n = 6;

        for (int i = 0; i < n; i++) {
            Vector<Double> tempRow = new Vector<>();
            for (int j = 0; j < n; j++) {
                Double temp = (double) (i + j);
                tempRow.addElement(temp);
            }
            myDataA.addElement(tempRow);
        }

        for (int i = 0; i < n; i++) {
            Vector<Double> tempRow = new Vector<>();
            for (int j = 0; j < n; j++) {
                Double temp = (double) (i * j);
                tempRow.addElement(temp);
            }
            myDataB.addElement(tempRow);
        }

        System.out.println(myDataA + "\nA size: " + myDataA.size());
        System.out.println();
        System.out.println(myDataB + "\nB size: " + myDataB.size());
        System.out.println();
        myDataC = square_matrix_multiply(myDataA, myDataB);
        System.out.println(myDataC + "\nC size: " + myDataC.size());
    }
}
