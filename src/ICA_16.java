import java.util.Vector;

public class ICA_16 {

    public static Vector<Vector<Double>> matrix_multiply
            (Vector<Vector<Double>> inputA,
             Vector<Vector<Double>> inputB) {
        // inputA.size() is number of rows
        // inputA.element(k).size() is number of cols
        Vector<Vector<Double>> outC = new Vector<>();
        if (inputA.elementAt(0).size() != inputB.size()) {
            // throw error "incompatible dimensions"
            throw new IllegalArgumentException("Incompatible dimensions");
        } else {
            // let C be new A.rows X B.cols matrix
            // check line 10
//            Vector<Vector<Double>> outC = new Vector<>();
            for (int i = 0; i < inputA.size(); i++) {
                outC.addElement(new Vector<>());
                for (int j = 0; j < inputB.elementAt(0).size(); j++) {
                    // I was having trouble making the for loop be dynamic
                    // I wanted to use a variable to check the columns
                    // rather than hard code for the zeroth index everytime
                    outC.elementAt(i).add(0.0);
                    for (int k = 0; k < inputA.elementAt(k).size(); k++) {
                        double a = inputA.elementAt(i).elementAt(k);
                        double b = inputB.elementAt(k).elementAt(j);
                        outC.elementAt(i).set(j, outC.elementAt(i).elementAt(j) + a * b);
                    }
                }
            }
        }
        return outC;
    }

    public static void main(String[] args) {
        Vector<Vector<Double>> myDataA = new Vector<>();
        Vector<Vector<Double>> myDataB = new Vector<>();
        Vector<Vector<Double>> myDataC = new Vector<>();

        // original cols = 8, rows = 11
        Integer aCols = 8;
        Integer aRows = 11;
        Integer bCols = aRows;
        Integer bRows = aCols;
        // test values on next two lines
//        Integer bCols = 3;
//        Integer bRows = 4;

        for (int i = 0; i < aRows; i++) {
            Vector<Double> tempRow = new Vector<>();
            for (int j = 0; j < aCols; j++) {
                Double temp = (double) (i +j);
                tempRow.addElement(temp);
            }
            myDataA.addElement(tempRow);
        }

        for (int i = 0; i < bRows; i++) {
            Vector<Double> tempRow = new Vector<>();
            for (int j = 0; j < bCols; j++) {
                Double temp = (double) (i * j);
                tempRow.addElement(temp);
            }
            myDataB.addElement(tempRow);
        }

        System.out.println(myDataA);
        System.out.println("A-rows: " + myDataA.size() + "\nA-cols: "
                + myDataA.elementAt(0).size());
        System.out.println(myDataB);
        System.out.println("B-rows: " + myDataB.size() + "\nB-cols: "
                + myDataB.elementAt(0).size());
        System.out.println();
        myDataC = matrix_multiply(myDataA,myDataB);
        System.out.println(myDataC);
        System.out.println("C-rows: " + myDataC.size() + "\nC-cols: "
                + myDataC.elementAt(0).size());
    }
}
