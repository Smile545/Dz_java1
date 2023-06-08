import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class program {

    
    public static int randomNum(int min, int max) {
        int num = (int) (Math.random() * ((max - min) + 1)) + min;
        return num;
    }

   
    public static int seniorBit(int i) {
        int binLen = Integer.toBinaryString(i).length();
        return binLen;
    }

    public static ArrayList<Integer> arrayMult(int i, int n, int max) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = i + 1; j <= max; j++) {
            if (j % n == 0) {
                list.add(j);
            }
        }
        return list;
    }

    public static ArrayList<Integer> arrayNotMult(int i, int n, int min) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = i - 1; j >= min; j--) {
            if (j % n != 0) {
                list.add(j);
            }
        }
        return list;
    }

    public static void saveArray(ArrayList<Integer> arr, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Integer c : arr) {
                writer.write(c + "\t");
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int min = 1, max = 10_000;
        int i = randomNum(min, max);
        System.out.println("integer between " + min + " and " + max + ": i = " + i);
        int n = seniorBit(i);
        System.out.println("number of the senior bit from i: n = " + n);
        ArrayList<Integer> m1 = arrayMult(i, n, max);
        ArrayList<Integer> m2 = arrayNotMult(i, n, min);;
        saveArray(m1, "home1/m1.txt");
        saveArray(m2, "home1/m2.txt");
    }
}