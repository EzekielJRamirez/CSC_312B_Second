import java.util.Vector;

public class ICA_17 {

    public static Vector<Vector<Double>> square_matrix_multiply(Vector<Vector<Double>> inputA,
                                                                Vector<Vector<Double>> inputB) {
        //dummy return statement
        return new Vector<>();
    }

    public static void main(String[] args) {
        Vector<Vector<Double>> myDataA = new Vector<>();
        Vector<Vector<Double>> myDataB = new Vector<>();
        Vector<Vector<Double>> myDataC = new Vector<>();

        Integer n = 31;

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

        System.out.println(myDataA);
        System.out.println(myDataB);
//        myDataC = square_matrix_multiply(myDataA, myDataB);
//        System.out.println(myDataC);
    }
}
