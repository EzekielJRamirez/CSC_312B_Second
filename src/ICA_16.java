import java.util.Vector;

public class ICA_16 {

    public static Vector<Vector<Double>> matrix_multiply (Vector<Vector<Double>> inputA,
                                                          Vector<Vector<Double>> inputB) {
        // dummy return statement
        return new Vector<>();
    }

    public static void main(String[] args) {
        Vector<Vector<Double>> myDataA = new Vector<>();
        Vector<Vector<Double>> myDataB = new Vector<>();
        Vector<Vector<Double>> myDataC = new Vector<>();

        Integer aCols = 8;
        Integer aRows = 11;
        Integer bCols = aRows;
        Integer bRows = aCols;

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
        System.out.println(myDataB);
//        myDataC = matrix_multiply(myDataA,myDataB);
//        System.out.println(myDataC);
    }
}
