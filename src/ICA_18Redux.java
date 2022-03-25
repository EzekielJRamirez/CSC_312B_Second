import java.util.Vector;

public class ICA_18Redux {
    public static Vector<Vector<Double>> matrixAdd(Vector<Vector<Double>> inputA,
                                                   Vector<Vector<Double>> inputB) {
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

    public static Vector<Vector<Double>> matrixSubtract(Vector<Vector<Double>> inputA,
                                                        Vector<Vector<Double>> inputB) {
        Vector<Vector<Double>> ret = new Vector<>();

        int n = inputA.size();

        for (int i = 0; i < n; i++) {
            Vector<Double> tempRow = new Vector<>();
            for (int j = 0; j < n; j++) {
                tempRow.addElement(inputA.elementAt(i).elementAt(j) - inputB.elementAt(i).elementAt(j));
            }
            ret.addElement(tempRow);
        }

        return ret;
    }

    public static void squareMM_Helper(int initI, int conditionI, int initJ, int conditionJ,
                                       Vector<Vector<Double>> input,
                                       Vector<Vector<Double>> sub) {
        for (int i = initI; i < conditionI; i++) {
            Vector<Double> tempRow = new Vector<>();
            for (int j = initJ; j < conditionJ; j++) {
                tempRow.addElement(input.elementAt(i).elementAt(j));
            }
            sub.addElement(tempRow);
        }
    }

    public static Vector <Vector<Double>> strassensMMRecursive(Vector<Vector<Double>> inputA,
                                                               Vector<Vector<Double>> inputB) {
        Integer n = inputA.size();
        Vector<Vector<Double>> ret = new Vector<Vector<Double>>();

        for (int i = 0; i < n; i++) {
            Vector<Double> tempRow = new Vector<Double>();
            for (int j = 0; j < n; j++) {
                tempRow.addElement(0.0);
            }
            ret.addElement(tempRow);
        }

        //n == 1 OR n == 2
        if (n == 1) {
            ret.elementAt(0).set(0, inputA.elementAt(0).elementAt(0)
                    * inputB.elementAt(0).elementAt(0));
        } else {
            Vector<Vector<Double>> A11 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> A12 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> A21 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> A22 = new Vector<Vector<Double>>();

            Vector<Vector<Double>> B11 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> B12 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> B21 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> B22 = new Vector<Vector<Double>>();

            Vector<Vector<Double>> C11, C12, C21, C22;

            // setting values for A matrices
            squareMM_Helper(0, n / 2, 0, n / 2, inputA, A11);
            squareMM_Helper(0, n / 2, n / 2, n, inputA, A12);
            squareMM_Helper(n / 2, n, 0, n / 2, inputA, A21);
            squareMM_Helper(n / 2, n, n / 2, n, inputA, A22);

            // setting values for B matrices
            squareMM_Helper(0, n / 2, 0, n / 2, inputB, B11);
            squareMM_Helper(0, n / 2, n / 2, n, inputB, B12);
            squareMM_Helper(n / 2, n, 0, n / 2, inputB, B21);
            squareMM_Helper(n / 2, n, n / 2, n, inputB, B22);

            Vector<Vector<Double>> s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;

            s1 = matrixSubtract(B12, B22);
            s2 = matrixAdd(A11, A12);
            s3 = matrixAdd(A21, A22);
            s4 = matrixSubtract(B21, B11);
            s5 = matrixAdd(A11, A22);
            s6 = matrixAdd(B11, B22);
            s7 = matrixSubtract(A12, A22);
            s8 = matrixAdd(B21, B22);
            s9 = matrixSubtract(A11, A21);
            s10 = matrixAdd(B11, B12);

            Vector<Vector<Double>> p1, p2, p3, p4, p5, p6, p7;

            p1 = strassensMMRecursive(A11, s1);
            p2 = strassensMMRecursive(s2, B22);
            p3 = strassensMMRecursive(s3, B11);
            p4 = strassensMMRecursive(A22, s4);
            p5 = strassensMMRecursive(s5, s6);
            p6 = strassensMMRecursive(s7, s8);
            p7 = strassensMMRecursive(s9, s10);

            // setting values for C matrices
            C11 = matrixAdd(p5, p4);
            C11 = matrixSubtract(C11, p2);
            C11 = matrixAdd(C11, p6);

            C12 = matrixAdd(p1, p2);
            C21 = matrixAdd(p3, p4);

            C22 = matrixAdd(p5, p1);
            C22 = matrixSubtract(C22, p3);
            C22 = matrixSubtract(C22, p7);

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
                    ret.elementAt(i).set(j, C21.elementAt(i - (n / 2)).elementAt(j));
                }
            }

            for (int i = n / 2; i < n; i++) {
                for (int j = n / 2; j < n; j++) {
                    ret.elementAt(i).set(j, C22.elementAt(i - (n / 2)).elementAt(j - (n / 2)));
                }
            }
        }

        return ret;
    }

    public static Vector<Vector<Double>> squareMatrixMultiplyRecursive(
            Vector<Vector<Double>> inputA,
            Vector<Vector<Double>> inputB) {

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
            squareMM_Helper(0, n / 2, n / 2, n, inputA, A12);
            squareMM_Helper(n / 2, n, 0, n / 2, inputA, A21);
            squareMM_Helper(n / 2, n, n / 2, n, inputA, A22);

            squareMM_Helper(0, n / 2, 0, n / 2, inputB, B11);
            squareMM_Helper(0, n / 2, n / 2, n, inputB, B12);
            squareMM_Helper(n / 2, n, 0, n / 2, inputB, B21);
            squareMM_Helper(n / 2, n, n / 2, n, inputB, B22);

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
                    ret.elementAt(i).set(j, C21.elementAt(i - (n / 2)).elementAt(j));
                }
            }

            for (int i = n / 2; i < n; i++) {
                for (int j = n / 2; j < n; j++) {
                    ret.elementAt(i).set(j, C22.elementAt(i - (n / 2)).elementAt(j - (n / 2)));
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Vector<Vector<Double>> myDataA = new Vector<Vector<Double>>();
        Vector<Vector<Double>> myDataB = new Vector<Vector<Double>>();
        Vector<Vector<Double>> myDataC = new Vector<Vector<Double>>();

        Integer n = 4; // must be pow of 2

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

        System.out.println(myDataA + "\n" + "A-rows: " + myDataA.size() + "\nA-cols: "
                + myDataA.elementAt(0).size() + "\n");
        System.out.println(myDataB + "\n" + "B-rows: " + myDataB.size() + "\nB-cols: "
                + myDataB.elementAt(0).size() + "\n");
//        myDataC = squareMatrixMultiplyRecursive(myDataA, myDataB);
        myDataC = strassensMMRecursive(myDataA, myDataB);
        System.out.println(myDataC + "\n" + "C-rows: " + myDataC.size() + "\nC-cols: "
                + myDataC.elementAt(0).size());
    }
}
