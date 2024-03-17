import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;



class sõnaValija {

    public static void main(String[] args) {
        String[][] sõnadJaTähendused = new String[5][2];

        try {
            File f = new File("/Users/user/Koolivärk/Teine semester/Objektorienteeritud programmeerimine/backupWordle/src/sõnad");
            Scanner myReader = new Scanner(f);
            int i = 0; //indeks
            while (myReader.hasNextLine()) {
                sõnadJaTähendused[i] = myReader.nextLine().split(";");
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Midagi läks katki!");
            e.printStackTrace();
        }
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        String valitudSõna = sõnadJaTähendused[randomNumber][0];
        String valitudSõnaTähendus = sõnadJaTähendused[randomNumber][1];

        System.out.println(valitudSõna);
        System.out.println(valitudSõnaTähendus);


    } // main
}//sõnaValija