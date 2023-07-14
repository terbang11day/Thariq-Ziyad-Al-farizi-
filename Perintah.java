
import java.awt.Dimension;

/**
 * 
 * Perintah.java
 * <br><br>
 * Class {@code Perintah} merepresentasikan perintah-perintah umum yang 
 * dapat diberikan kepada kura-kura. Termasuk dalam class ini adalah
 * proses untuk membaca input (saat ini baru melalui satu baris perintah)
 * dan memanggil method yang berkesesuaian.
 * Dalam kelas ini juga disediakan method-method yang merupakan kumpulan-kumpulan
 * perintah berurutan yang dapat diterima oleh kurakura dan menghasilkan gambar 
 * tertentu. 
 * <br><br>
 * Tugas anda pada file ini: <br>
 * - Lengkapi javadoc comment pada tiap deklarasi method.<br>
 * - Lengkapi inline comment untuk tiap baris perintah yang penting.<br>
 * - Perbaiki method {@code lakukan} agar tidak menimbulkan error bila input salah<br>
 * - Buat (1) perintah {@code mundur <x>}" agar kura-kura bisa mundur sebanyak x pixel satuan.
 * - Buat (2) perintah {@code hadap kanan} dan {@code hadap kiri} yang akan membuat kura-kura 
 *   menghadap ke kanan (rotasi 90) dan ke kiri (rotasi -90) 
 * - Dapatkah anda membuat (3) kura-kura mengenali perintah 
 *   {@code loop 10 perintah-perintah} <br>
 *   yang artinya melakukan perintah-perintah sebanyak 10 kali? <br>
 *   contoh: "loop 10 rotasi 30 maju 30" <br>
 *           yang artinya akan melakukan perintah "rotasi 30", dilanjutkan <br>
 *           perintah "maju 30", secara berulang-ulang sebanyak 10 kali<br>
 *   contoh: "loop 5 maju 20 hadap kanan maju 30" <br>
 *           yang artinya akan melakukan perintah "maju 20", dilanjutkan <br>
 *           "hadap kanan", kemudian perintah "maju 10", <br> 
 *           secara berulang-ulang sebanyak 5 kali<br>
 * 
 * @author Ade Azurat for DPBO 2008 @ Fasilkom UI
 * @author Ade Azurat for DDP2 2023 @ Fasilkom UI
 */
public class Perintah {
    Canvas canvas;
    Kurakura kurakuraku; 
    
    /** Creates a new instance of Perintah */
    public Perintah(Kurakura k, Canvas canvas) {
        kurakuraku = k;
        this.canvas = canvas;
    }

    // Dapatkan anda membuat method ini lebih baik dan lebih mudah ditambahkan
    // atau di ubah? 
    public String lakukan(String inputPerintah){
        String[] in = inputPerintah.split(" ");
        if (in[0].equalsIgnoreCase("selesai"))
            System.exit(0);
        else if (in[0].equalsIgnoreCase("reset"))
            kurakuraku.reset();
        else if (in[0].equalsIgnoreCase("maju"))
            kurakuraku.maju(Integer.parseInt(in[1]));
        else if (in[0].equalsIgnoreCase("mundur"))
                kurakuraku.mundur(Integer.parseInt(in[1]));
        else if (in[0].equalsIgnoreCase("rotasi"))
                kurakuraku.rotasi(Integer.parseInt(in[1]));
        else if (in[0].equalsIgnoreCase("kotak"))
                buatKotak(Integer.parseInt(in[1]));
        else if (in[0].equalsIgnoreCase("persegi"))
                buatPersegi(Integer.parseInt(in[1]),Integer.parseInt(in[2])); 
        else if (in[0].equalsIgnoreCase("boxes"))
                boxes(Integer.parseInt(in[1]));  
        else if (in[0].equalsIgnoreCase("segitiga"))
                buatSegitiga(Integer.parseInt(in[1]));
        else if (in[0].equalsIgnoreCase("sierpinski"))
                buatsierpinski();
        else if (in[0].equalsIgnoreCase("segitigasiku"))
                buatSegitigasiku(Integer.parseInt(in[1]),Integer.parseInt(in[2]));  
        else if (in[0].equalsIgnoreCase("pohon"))
                buatPohon();   
        else if (in[0].equalsIgnoreCase("ketupat"))
                buatketupat();       
        else if (in[0].equalsIgnoreCase("jejak"))
                kurakuraku.setJejak(Boolean.parseBoolean(in[1]));
        else if (in[0].equalsIgnoreCase("pindah"))
                kurakuraku.setPosition(new Dimension(Integer.parseInt(in[1]),Integer.parseInt(in[2])));

        else{
                canvas.repaint(); 
                return "Perintah tidak dipahamiads.";
            }
        canvas.repaint();    
        return "Perintah sudah dilaksanakan.";
    }
    
    public void buatKotak(int ukuran ){        
        for (int i=0;i<4;i++){
            kurakuraku.maju(ukuran);
            kurakuraku.rotasi(90);
        }
    }
/*
 * looping sebanyak 2 kali dengan nilai i yang terus bertambah
 * kura kura maju sesuai panjang
 * kura kura melakukan rotasi 90 derajat
 * kura kura maju sesuai panjang 
 * kura kura melakukan rotasi 90
 */
    public void buatPersegi(int panjang,int lebar ){        
        for (int i=0;i<2;i++){
            kurakuraku.maju(panjang);
            kurakuraku.rotasi(90);
            kurakuraku.maju(lebar);
            kurakuraku.rotasi(90);
        }
    }
/*buat boxes secara rekursif
 * base case ukuran lebih besar dari 0
 * memanggil methood buat kotak dengan ukuran yang dimasukan
 * menghilangkan jejak kura kura
 * melakukan perpindah kura kura
 * maju sejauh 10
 * rotasi 90 derajat
 * maju sejauh 10
 * rotasi -90 sehingga kura kura menghadap kedepan 
 * memanggil methood boxes dengan nilai ukuran yang dikurangi 20
 */
    public void boxes(int ukuran){
        if (ukuran >= 0) {
            buatKotak(ukuran);
            kurakuraku.setJejak(false);
            kurakuraku.maju(10);
            kurakuraku.rotasi(90);
            kurakuraku.maju(10);
            kurakuraku.rotasi(-90);
            kurakuraku.setJejak(true);
            boxes(ukuran-20);      
        }
    }

/**
 * sett posisi awal ketupat
 * memanggil methood buat ketupan dengan 
 */
    public void buatketupat(){
        buatketupat(4, 50);
    }

/**
 * mirip seperti membuat pohon
 * diubah nilai perputaran sudur sebesar +/-90* sehingga mendapatkan 4 seisi dalam pesegi
 * 
 * @param ukuran
 * @param tinggi
 */
    private void buatketupat(int ukuran, int tinggi){
        if (ukuran>0){  
            kurakuraku.setJejak(true);
            kurakuraku.maju(tinggi);                        
            kurakuraku.rotasi(-90);
            Dimension posAwal = kurakuraku.getPosition();
            double arah = kurakuraku.getArah();
            double sudut = arah;
            for(int i=0;i<4;i++){
                buatketupat(ukuran-1,(int)(tinggi/1.5));
                kurakuraku.setJejak(false);
                kurakuraku.setPosition(posAwal);
                kurakuraku.setArah(arah);                
                sudut+=90;
                kurakuraku.rotasi(sudut);  
                
            }     
        }
  
    }



/*membuat segitiga sama kaki
 *melakukan looping sesuai sisi segitiga 
 *melakukan rotasi sesuai sudut segitiga
 */
    public void buatSegitiga(double ukuran){
        for(int i=0;i<3;i++){  
            kurakuraku.maju(ukuran);
            kurakuraku.rotasi(-180+60);
    }   
    }
/**
 * membuat sierpinski
 * buat segitiga dengan ukuran 100
 * kemudian maju setengah dari 100
 * kemudian memanggil methood sierpinski rekursif
*/
    public void buatsierpinski(){
        buatSegitiga(200);
        kurakuraku.maju(50);
        buatsierpinskirekursif(50);
    }
/**
 * methood rekursif sierpinski
 * base case untuk seberapa banyak bentuk yang akan dibuat
 * menghilangkan jejak untuk perpindahan
 * rotasi sebanyak -60* 
 * mangaktifkan jejak 
 * segitiga akan terbentuk secara terbalik dengan ukuran setengah
 * mematikan jejak
 * rotasi 60* sehingga kura kura sejajar dengan garis
 * menyimpan koordinat
 * kura kura maju dengan jarak setengah dari ukuran
 * memanggil rekursif 
 * setting kura kura ada koordinat yang ditentukan tadi  (bila kondisi rekursif sudah tidak memenuhi)
 * kura kura mundur setengah dari ukuran untuk memnuhi posisi segitiga kiri
 * setting koordinat (bila kondisi rekursif diatasny tidak terpenuhi lagi)
 * rotasi -60* 
 * maju sesuai panjang ukuran
 * rotasis 120*
 * maju setengah dari ukuran
 * rotasi 180* sehingga kura kura sejajar dengan garis
 * memanggil rekursif untuk membuat bagian atas
 * singkatnya alur program adalah membuat segtitiga di kanan, kemudian kiri dan yang terkhir atas sampai basecase terpenuhi
 * @ukuran ukuran
 */

    public void buatsierpinskirekursif(double ukuran){
        if (ukuran>10){
            kurakuraku.setJejak(false);
            kurakuraku.rotasi(-60);
            kurakuraku.setJejak(true);
            buatSegitiga(ukuran);
            kurakuraku.setJejak(false);
            kurakuraku.rotasi(60);
            Dimension pos = kurakuraku.getPosition();
            kurakuraku.maju(ukuran/2);
            buatsierpinskirekursif(ukuran/2); // rekursif kanan
            kurakuraku.setPosition(pos);
            kurakuraku.mundur(ukuran/2);
            buatsierpinskirekursif(ukuran/2); // rekursif kiri
            kurakuraku.setPosition(pos);
            kurakuraku.rotasi(-60);
            kurakuraku.maju(ukuran);
            kurakuraku.rotasi(-120);
            kurakuraku.maju(ukuran/2);
            kurakuraku.rotasi(180);
            buatsierpinskirekursif(ukuran/2); // rekursif atas
        }
    }
/*
 * meminta niali alas dan tinggi
 * mencari sisi miring dengan pitagoras
 * kura kura maju sesau dengan panjang alas
 * kura kura rotasi 90 derajat
 * kura kura naik sesuai tinggi
 * kura kura berotasi sesuai besar sudut
 * kura kura maju seusai nilai dari kemiringan
 */
    public void buatSegitigasiku(int alas,int tinggi){
            double pyth = (alas*alas) + (tinggi*tinggi);
            double miring = Math.sqrt(pyth);
            double sudut = Math.toDegrees(Math.atan ((double)(alas / tinggi))); // menyari nilai rotasi cos
            kurakuraku.maju(tinggi);
            kurakuraku.rotasi(90);
            kurakuraku.maju(alas);
            kurakuraku.rotasi(180-sudut);
            kurakuraku.maju(miring);

    }   
    
    public void buatPohon(){        
        kurakuraku.setJejak(false);
        kurakuraku.reset();
        kurakuraku.rotasi(90);
        kurakuraku.maju(100);
        kurakuraku.rotasi(180);
        buatPohon(6,50);        
        kurakuraku.reset();
    }
 /*membuat pohon
  */    
    private void buatPohon(int ukuran, int tinggi){
        if (ukuran>0){  
            kurakuraku.setJejak(true);
            kurakuraku.maju(tinggi);                        
            kurakuraku.rotasi(-45);
            Dimension posAwal = kurakuraku.getPosition();
            double arah = kurakuraku.getArah();
            double sudut = arah;
            for(int i=0;i<3;i++){
                if (ukuran == 1){ // membuat kotak-kotak di ujung pohon
                    kurakuraku.setPosition(posAwal);
                    buatKotak(5);
                }  
                buatPohon(ukuran-1,(int)(tinggi/1.5));
                kurakuraku.setJejak(false);
                kurakuraku.setPosition(posAwal);
                kurakuraku.setArah(arah);                
                sudut+=45;
                kurakuraku.rotasi(sudut);  
                
                
                
            }     
        }
        kurakuraku.reset();
    }
}
