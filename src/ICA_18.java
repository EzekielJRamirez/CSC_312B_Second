import java.util.Vector;

public class ICA_18 {
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

            Vector<Vector<Double>> B11 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> B12 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> B21 = new Vector<Vector<Double>>();
            Vector<Vector<Double>> B22 = new Vector<Vector<Double>>();

            Vector<Vector<Double>> C11, C12, C21, C22;

            for (int i = 0; i < n / 2; i++) {
                // fill in a sec
                Vector<Double> tempRow = new Vector<>();
                for (int j = 0; j < n / 2; j++) {
                    tempRow.addElement(inputA.elementAt(i).elementAt(j));
                }
                A11.addElement(tempRow);
            }

            for (int i = 0; i < n / 2; i++) {
                // fill in a sec
                Vector<Double> tempRow = new Vector<>();
                for (int j = n / 2; j < n; j++) {
                    tempRow.addElement(inputA.elementAt(i).elementAt(j));
                }
                A12.addElement(tempRow);
            }

            for (int i = n / 2; i < n; i++) {
                Vector<Double> tempRow = new Vector<>();
                for (int j = 0; j < n / 2; j++) {
                    tempRow.addElement(inputA.elementAt(i).elementAt(j));
                }
                A21.addElement(tempRow);
            }

            for (int i = n / 2; i < n; i++) {
                Vector<Double> tempRow = new Vector<>();
                for (int j = n / 2; j < n; j++) {
                    tempRow.addElement(inputA.elementAt(i).elementAt(j));
                }
                A22.addElement(tempRow);
            }

            for (int i = 0; i < n / 2; i++) {
                Vector<Double> tempRow = new Vector<>();
                for (int j = 0; j < n / 2; j++) {
                    tempRow.addElement(inputB.elementAt(i).elementAt(j));
                }
                B11.addElement(tempRow);
            }

            for (int i = 0; i < n / 2; i++) {
                Vector<Double> tempRow = new Vector<>();
                for (int j = n / 2; j < n; j++) {
                    tempRow.addElement(inputB.elementAt(i).elementAt(j));
                }
                B12.addElement(tempRow);
            }

            for (int i = n / 2; i < n; i++) {
                Vector<Double> tempRow = new Vector<>();
                for (int j = 0; j < n / 2; j++) {
                    tempRow.addElement(inputB.elementAt(i).elementAt(j));
                }
                B21.addElement(tempRow);
            }

            for (int i = n / 2; i < n; i++) {
                Vector<Double> tempRow = new Vector<>();
                for (int j = n / 2; j < n; j++) {
                    tempRow.addElement(inputB.elementAt(i).elementAt(j));
                }
                B22.addElement(tempRow);
            }

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

        System.out.println(myDataA + "\n" + "A-rows: " + myDataA.size() + "\nA-cols: "
                + myDataA.elementAt(0).size() + "\n");
        System.out.println(myDataB + "\n" + "B-rows: " + myDataB.size() + "\nB-cols: "
                + myDataB.elementAt(0).size() + "\n");
        myDataC = squareMatrixMultiplyRecursive(myDataA, myDataB);
        System.out.println(myDataC + "\n" + "C-rows: " + myDataC.size() + "\nC-cols: "
                + myDataC.elementAt(0).size());
    }
}
