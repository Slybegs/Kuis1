import java.util.Scanner;
import java.util.ArrayList;
import Menu.Transfer;

public class App {
    public static void main(String[] args) throws Exception {
        //Array Nama
        String[] pemilikrek = new String[2];
        pemilikrek[0] = "Susi";
        pemilikrek[1] = "Budi";

        //ArrayList Nomor Rekening
        ArrayList <Akun> DataNasabah = new ArrayList <Akun>();
        DataNasabah.add(new Akun("Budi", "0314865"));

        //deklarasi
        int idx = 0;
        int[] mutasi = new int[100];
        int pil = 0;
        String yn = "y";

        //Scanner keyboard
        Scanner keyboard = new Scanner(System.in);

        //Menu
        do{
            System.out.println("Menu Bank XYZ");
            System.out.println("1. Transfer Uang");
            System.out.println("2. Cek Mutasi Rekening");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda (1 / 2 / 3) : ");

            //Input User
            pil = keyboard.nextInt();

            //Percabangan
            if (pil == 1){
                clearscreen();
                System.out.println("Menu Transfer Uang");
                System.out.print("Silahkan Masukkan Nomor Rekening Tujuan (Max. 7) : ");
                Transfer.norekeningtujuan = keyboard.next();

                for (Akun akun : DataNasabah) {
                    if (akun.norekening.equals(Transfer.norekeningtujuan)){
                        do {
                            System.out.print("Masukkan Jumlah Yang Ingin Di Transfer (tidak pakai titik maupun spasi) : ");
                            Transfer.ValueTF = keyboard.nextInt();
                            clearscreen();
                            System.out.println("Anda Akan Mengirimkan Dana Sebesar "+ Transfer.ValueTF +" Ke Rekening "+ Transfer.norekeningtujuan +"\nAtas Nama "+ pemilikrek[1] +"");
                                if (Transfer.ValueTF > Transfer.SaldoSusi){
                                    System.out.println("Maaf, Saldo Anda Tidak Mencukupi");
                                }
                                else{
                                    System.out.println("Selamat, Transaksi Anda Telah Berhasil");
                                }
                        }while(Transfer.ValueTF > Transfer.SaldoSusi);
                        Transfer.PenambahanSaldo();
                        Transfer.PenguranganSaldo();
                        mutasi[idx] = Transfer.ValueTF;
                        idx++;
                    } else {
                        System.out.println("Nomor Rekening Yang Anda Masukkan Tidak Terdaftar");
                    }
                }
            }
            else if (pil == 2){
                clearscreen();
                System.out.println("Menu Cek Mutasi Rekening");
                System.out.println("Rekening : "+ Transfer.RekSusi +" \nNama : "+ pemilikrek[0]+ "");
                System.out.println("==================================================");
                for (int i = 0; i < idx; i++){
                    System.out.println("Transfer Kepada Rekening "+ Transfer.RekBudi +" Sebesar "+ mutasi[i]+"");
                    System.out.println("==================================================");
                }
                if (idx == 0){
                    System.out.println("Belum Terdapat Transaksi Saat Ini");
                }
                System.out.println("Saldo Anda Sekarang Adalah "+ Transfer.SaldoSusi+"");
            }
            else if (pil == 3) break;

        //terima input pilihan y/n (string)
            System.out.print("Apakah anda ingin kembali ke menu utama (y/n)? ");
            yn = keyboard.next();
            clearscreen();
        
        }while(yn.equalsIgnoreCase("y"));
        keyboard.close();
        }
    
    //clearscreen
    public static void clearscreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }   
}
