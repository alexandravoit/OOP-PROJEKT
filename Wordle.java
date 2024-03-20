import java.util.Scanner;

public class Wordle {
    public static void main(String[] args) {

        // ALGVÄÄRTUSTUSED
        int guessCounter = 1;
        boolean äraArvatud = false;

        sõnaValija sõnaValija = new sõnaValija(); // sõnaValija klass, et valida suvaline sõna
        String[] sõnaJaTähendus = sõnaValija.valiSõna(); // String[] sõnast ja selle tähendusest
        String otsitavSõna = sõnaJaTähendus[0];
        String otsitavaSõnaTähendus = sõnaJaTähendus[1];
        int mituTähteSõnas = otsitavSõna.length();

        // TEATAB MITU TÄHTE ARVATAVAS SÕNAS ON
        System.out.println("Sõnas on " + mituTähteSõnas + " tähte.");

        // SCANNERI KLASS
        Scanner sk = new Scanner(System.in);


        // ESIMENE PAKKUMINE LOOPIST VÄLJAS
        System.out.print("Sinu " + guessCounter + ". pakkumine: ");
        String arvajaSõna = sk.nextLine().toLowerCase();
        guessCounter ++;


        // LUUAKSE KLASS
        ÕigedTähed misOnÕigedTähed = new ÕigedTähed(arvajaSõna, otsitavSõna);

        // LOON KLASSI ABIL DEFAULT VASTUSEMASSIIVI
        for (int i = 0; i < otsitavSõna.length(); i++) {
            misOnÕigedTähed.lisaTähedMassiivi('_', i);
        }

        if (arvajaSõna.equals(otsitavSõna)) { // ERIJUHT KUI KASUTAJA ARVAB ESIMESE KORRAGA SÕNA ÄRA
            System.out.println("Arvasid sõna ühe korraga ära! Guesswork or genius?!");
            System.out.println("Sõna tähendab " + "'" + otsitavaSõnaTähendus + "'");
        } else {

            // NÄITAB __A__M__ KUJUL SÕNA, KUS _ ON ARVAMATA TÄHT
            misOnÕigedTähed.lisaTähed();
            misOnÕigedTähed.väljastaOlukord();
            väljastaMänguSeis(misOnÕigedTähed);
            System.out.println();


            // SENI KUNI KASUTAJA POLE SÕNA ÄRA ARVANUD
            while (!äraArvatud) {
                System.out.print("Sinu " + guessCounter + ". pakkumine: ");
                arvajaSõna = sk.nextLine().toLowerCase();

                if (arvajaSõna.equals(otsitavSõna)) { // KASUTAJA ARVAB SÕNA ÄRA
                    System.out.println("Arvasid sõna " + "'" + otsitavSõna + "'" + " ära " + guessCounter + ". korraga.");
                    äraArvatud = true;
                    System.out.println("Sõna tähendab " + "'" + otsitavaSõnaTähendus + "'");
                } else {
                    misOnÕigedTähed.setPakutudSõna(arvajaSõna); // UUENDAB SINU GUESSI
                    misOnÕigedTähed.lisaTähed();
                    misOnÕigedTähed.väljastaOlukord();
                    väljastaMänguSeis(misOnÕigedTähed);
                    System.out.println();

                    guessCounter ++;


                }

            }

        }











    }

    public static void väljastaMänguSeis(ÕigedTähed sõna) {
        System.out.println("SÕNA SEIS: ");
        System.out.print(sõna.getVastuseMassiiv());
        System.out.println();
    }
}
