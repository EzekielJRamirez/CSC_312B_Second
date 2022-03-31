import java.util.Vector;
import java.util.Random;

/**
 * pages 269-276
 */

public class ICA_20 {
    static Integer m;
    static Random myRandomNum;

    public static Integer h(Integer k, Integer i) {
        if (i.equals(0)) {
            return 0;
        }

        return (k % i);
    }

    public static Integer hashInsert(Vector<Integer> input, Integer k) {
//        System.out.println(input);
        // something else needs work
        // insert is fine

        int i = 0;
        while (i != m) {
            Integer j = h(k, i);
            if (input.elementAt(j).equals(-1)) {
                input.set(j, k);
                return j;
            } else {
                i += 1;
            }
        }
        return -1;
    }

    public static Integer hashSearch(Vector<Integer> input, Integer k) {
//        System.out.println(input);
        int i = 0;
        Integer j = h(k, i);
        while ((i <= m) && (input.elementAt(j) != -1)) {
            j = h(k, i);
            if (input.elementAt(j).equals(k)) {
                return j;
            }
            i += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        m = 128;
        Vector<Integer> myTable = new Vector<>();
        Vector<Integer> myNums = new Vector<>();

        for (int i = 0; i < m; i++) {
            myTable.addElement(-1);
        }

        myRandomNum = new Random();

        for (int i = 0; i < m; i++) {
            // because we multiply by 3, we will only find values
            // of three in the vector
//            Integer toInsert = i * 3;
            // with the random insert, we are filling the vector with
            // a random number from 0 to 3 * m. m = 128 per the
            // original code
            Integer toInsert = myRandomNum.nextInt(3 * m);
            // location is never called elsewhere, but it is used to
            // insert non-negative values into the myTable Vector
            Integer location = hashInsert(myTable, toInsert);
            myNums.addElement(toInsert);
        }


        System.out.println(myTable);
        for (int i = 0; i < m; i++) {
            System.out.print("searching: " + i + ", " +
                    hashSearch(myTable, i) + ";\t\t");
        }
    }
}
