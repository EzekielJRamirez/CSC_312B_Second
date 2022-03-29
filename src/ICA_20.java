import java.util.Vector;
import java.util.Random;

public class ICA_20 {

    static Integer m;
    static Random myRandomNum;

    public static Integer h(Integer k, Integer i) {
        return (k % i);
    }

    public static Integer hashInsert(Vector<Integer> input, Integer k) {
        int i = 0;

        return null;
    }

    public static Integer hashSearch(Vector<Integer> input, Integer k) {
        return null;
    }

    public static void main(String[] args) {
        m = 128;
        Vector<Integer> myTable = new Vector<>();
        Vector<Integer> myNums = new Vector<>();

        for (int i = 0; i < m; i++) {
            myTable.addElement(null);
        }

        myRandomNum = new Random();

        for(int i = 0; i < m; i++) {
            Integer toInsert = myRandomNum.nextInt(3 * m);
            Integer location = hashInsert(myTable, toInsert);
            myNums.addElement(toInsert);
        }

        for(int i = 0; i < myNums.size(); i++) {
            System.out.println(myNums.elementAt(i) + ", " +
                    hashSearch(myTable, myNums.elementAt(i) ) + "; ");
        }
    }
}
