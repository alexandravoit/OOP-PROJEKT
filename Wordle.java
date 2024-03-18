import java.util.Scanner;

public class Wordle {
    public static void main(String[] args) {

        // ALGVÄÄRTUSTUSED
        int guessCounter = 1;
        boolean äraArvatud = false;
        String sõna = "moonisai"; // 8 characteri

        // SCANNERI KLASS
        Scanner sk = new Scanner(System.in);

        // ESIMENE PAKKUMINE LOOPIST VÄLJAS
        System.out.print("Sinu " + guessCounter + ". pakkumine: ");
        String arvajaSõna = sk.nextLine();
        guessCounter ++;

        // LUUAKSE KLASS
        ÕigedTähed misOnÕigedTähed = new ÕigedTähed(arvajaSõna, sõna);

        // LOON KLASSI ABIL DEFAULT VASTUSEMASSIIVI
        for (int i = 0; i < sõna.length(); i++) {
            misOnÕigedTähed.lisaTähedMassiivi('_', i);
        }

        if (arvajaSõna.equals(sõna)) { // ERIJUHT KUI KASUTAJA ARVAB ESIMESE KORRAGA SÕNA ÄRA
            System.out.println("Arvasid sõna ühe korraga ära! Guesswork or genius?!");
        } else {

            // NÄITAB __A__M__ KUJUL SÕNA, KUS _ ON ARVAMATA TÄHT
            misOnÕigedTähed.lisaTähed();
            misOnÕigedTähed.väljastaOlukord();
            väljastaMänguSeis(misOnÕigedTähed);
            System.out.println();


            // SENI KUNI KASUTAJA POLE SÕNA ÄRA ARVANUD
            while (!äraArvatud) {
                System.out.print("Sinu " + guessCounter + ". pakkumine: ");
                arvajaSõna = sk.nextLine();

                if (arvajaSõna.equals(sõna)) { // KASUTAJA ARVAB SÕNA ÄRA
                    System.out.println("Arvasid sõna " + "'" + sõna + "'" + " ära " + guessCounter + ". korraga.");
                    äraArvatud = true;
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
