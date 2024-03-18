public class test {
    public static void main(String[] args) {
        sõnaValija sõnaValija = new sõnaValija();
        String[] sõnapaar = sõnaValija.valiSõna();
        System.out.println("pakutav sõna: " + sõnapaar[0]);
        System.out.println("sõna tähendus: " + sõnapaar[1]);
    }
}
