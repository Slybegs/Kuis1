package Menu;

public class Transfer {
    public static int norekeningtujuan = 0;
    public static int ValueTF = 0;
    public static int RekSusi = 297012345;
    public static int RekBudi = 297067891;
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
