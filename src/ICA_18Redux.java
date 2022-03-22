import java.util.Vector;

public class ICA_18Redux {
    public static Vector<Vector<Double>> matrixAdd(Vector <Vector<Double>> inputA,
                                                   Vector<Vector<Double>> inputB) {
        //add notes here
        Vector<Vector<Double>> ret = new Vector<>();

        int n = inputA.size();

        for (int i = 0; i < n; i++) {
            Vector<Double> tempRow = new Vector<>();
            for (int j = 0; j < n; j++) {
                tempRow.addElement(inputA.elementAt(i).elementAt(j) + inputB.elementAt(i).elementAt(j));
            }
            ret.addElement(tempRow);
        }

        return ret;
    }

    public static void squareMM_Helper(int initI, int conditionI, int initJ, int conditionJ,
                                       Vector<Vector<Double>> input,
                                       Vector<Vector<Double>> sub) {
        for (int i = initI; i < conditionI; i++) {
            // fill in a sec
            Vector<Double> tempRow = new Vector<>();
            for (int j = initJ; j < conditionJ; j++) {
                tempRow.addElement(input.elementAt(i).elementAt(j));
            }
            sub.addElement(tempRow);
        }
    }

    public static Vector<Vector<Double>> squareMatrixMultiplyRecursive(
            Vector<Vector<Double>> inputA,
            Vector<Vector<Double>> inputB) {

        // start here
        Integer n = inputA.size();
        Vector<Vector<Double>> ret = new Vector<Vector<Double>>();

        for (int i = 0; i < n; i++) {
            Vector<Double> tempRow = new Vector<Double>();
            for (int j = 0; j < n; j++) {
                tempRow.addElement(0.0);
            }
            ret.addElement(tempRow);
        }

        if (n == 1) {
            ret.elementAt(0).set(0, inputA.elementAt(0).elementAt(0)
                    * inputB.elementAt(0).elementAt(0));
        } else {
            Vector<Vector<Double>> A11 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> A12 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> A21 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> A22 = new Vector<Vector<Double>>();

            //special--> works try to reduce lines used and make easier to read!!
            // NOTE with this method you only init the last value stated not all values in the line!!
//            Vector<Vector<Double>> A33, A34, A35 = new Vector<>();

            Vector<Vector<Double>> B11 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> B12 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> B21 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> B22 = new Vector<Vector<Double>>();

            Vector<Vector<Double>> C11, C12, C21, C22;


            squareMM_Helper(0, n / 2, 0, n / 2, inputA, A11);

            squareMM_Helper(0, n / 2, n/2, n, inputA, A12);

            squareMM_Helper(n/2, n, 0, n/2, inputA, A21);

            squareMM_Helper(n/2, n, n/2, n, inputA, A22);

            squareMM_Helper(0, n / 2, 0, n / 2, inputB, B11);

            squareMM_Helper(0, n / 2, n/2, n, inputB, B12);

            squareMM_Helper(n/2, n, 0, n/2, inputB, B21);

            squareMM_Helper(n/2, n, n/2, n, inputB, B22);

            C11 = matrixAdd(squareMatrixMultiplyRecursive(A11, B11), squareMatrixMultiplyRecursive(A12, B21));
            C12 = matrixAdd(squareMatrixMultiplyRecursive(A11, B12), squareMatrixMultiplyRecursive(A12, B22));
            C21 = matrixAdd(squareMatrixMultiplyRecursive(A21, B11), squareMatrixMultiplyRecursive(A22, B21));
            C22 = matrixAdd(squareMatrixMultiplyRecursive(A21, B12), squareMatrixMultiplyRecursive(A22, B22));

            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    ret.elementAt(i).set(j, C11.elementAt(i).elementAt(j));
                }
            }

            for (int i = 0; i < n / 2; i++) {
                for (int j = n / 2; j < n; j++) {
                    ret.elementAt(i).set(j, C12.elementAt(i).elementAt(j - (n / 2)));
                }
            }

            for (int i = n / 2; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    ret.elementAt(i).set(j, C21.elementAt(i - (n/ 2)).elementAt(j));
                }
            }

            for (int i = n / 2; i < n; i++) {
                for (int j = n / 2; j < n; j++) {
                    ret.elementAt(i).set(j, C22.elementAt(i - (n /2)).elementAt(j - (n / 2)));
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Vector<Vector<Double>> myDataA = new Vector<Vector<Double>>();
        Vector<Vector<Double>> myDataB = new Vector<Vector<Double>>();
        Vector<Vector<Double>> myDataC = new Vector<Vector<Double>>();

        Integer n = 16; // must be pow of 2

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

//        System.out.println(myDataA + "\nA size: " + myDataA.size());
//        System.out.println();
//        System.out.println(myDataB + "\nB size: " + myDataB.size());
//        System.out.println();
//        myDataC = squareMatrixMultiplyRecursive(myDataA, myDataB);
//        System.out.println(myDataC + "\nC size: " + myDataC.size());

        System.out.println(myDataA);
        System.out.println("A-rows: " + myDataA.size() + "\nA-cols: "
                + myDataA.elementAt(0).size());
        System.out.println();
        System.out.println(myDataB);
        System.out.println("B-rows: " + myDataB.size() + "\nB-cols: "
                + myDataB.elementAt(0).size());
        System.out.println();
        myDataC = squareMatrixMultiplyRecursive(myDataA,myDataB);
        System.out.println(myDataC);
        System.out.println("C-rows: " + myDataC.size() + "\nC-cols: "
                + myDataC.elementAt(0).size());
    }
}