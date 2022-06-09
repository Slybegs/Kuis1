package Menu;

public class Transfer {
    public static String norekeningtujuan;
    public static int ValueTF = 0;
    public static String RekSusi = "0213456";
    public static String RekBudi = "0314865";
    //pendeklarasian saldo
    public static int SaldoSusi = 1500000;
    public static int SaldoBudi = 0;

    public static void PenambahanSaldo(){
        SaldoBudi = SaldoBudi + ValueTF;
    }

    public static void PenguranganSaldo(){
        SaldoSusi = SaldoSusi - ValueTF;
    }

}
