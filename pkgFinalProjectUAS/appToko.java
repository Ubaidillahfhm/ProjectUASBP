package pkgFinalProjectUAS;
import java.util.Scanner;

public class appToko {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //data barang yang dijual
        cBarang brg1 = new cBarang("Tas",100000);
        cBarang brg2 = new cBarang("Sandal",50000);
        cBarang brg3 = new cBarang("Sepatu",150000);
        cBarang brg4 = new cBarang("Kemeja",180000);
        cBarang brg5 = new cBarang("Celana",200000);
        
        //data member toko
        int id1 = 10, pwd1 = 111;
        int id2 = 11, pwd2 = 222;
        int id3 = 12, pwd3 = 333;
        int id,pin;
        int pinbaru1, pinbaru2, pinbaru3;
        
        //data admin
        String pwdadmin = "admin123";
        String admin;
        
        //data pemilik
        String pwdpemilik = "pemilik123";
        String pemilik;
        
        //daftar antrian transaksi yang masuk ke toko
        cDaftarTransaksi jual = new cDaftarTransaksi();
        int pilih=0,pilih2=0,pilih3=0;
        int kode=100,jumlah;
        
        do {
            System.out.println("\nAplikasi Toko Maju Sejahtera");
            System.out.println("1. Pembeli");
            System.out.println("2. Anggota");
            System.out.println("3. Admin");
            System.out.println("4. Pemilik");
            System.out.println("5. Exit");
            System.out.print("Pilih = ");
            pilih = sc.nextInt();
            switch(pilih){
                case 1:
                    //Pembeli
                    kode++;
                    cDaftarTransaksi beli = new cDaftarTransaksi();
                    System.out.print("Masukkan Nama = ");
                    String nama=sc.next();
                    do {
                        System.out.println("Akun Pembeli");
                        System.out.println("1. Tambah");
                        System.out.println("2. Hapus");
                        System.out.println("3. Lihat");
                        System.out.println("4. Kembali");
                        System.out.print("Pilih = ");
                        pilih2=sc.nextInt();
                        switch(pilih2){
                            case 1:
                                cTransaksi br=null;
                                System.out.println("Daftar Barang : ");
                                System.out.println("1. Tas");
                                System.out.println("2. Sandal");
                                System.out.println("3. Sepatu");
                                System.out.println("4. Kemeja");
                                System.out.println("5. Celana");
                                System.out.print("Pilih = ");
                                pilih3=sc.nextInt();
                                System.out.print("Jumlah = ");
                                jumlah=sc.nextInt();
                                if(pilih3==1){
                                    br = new cTransaksi(String.valueOf(kode),nama,brg1,jumlah,0);
                                }else if(pilih3==2){
                                    br = new cTransaksi(String.valueOf(kode),nama,brg2,jumlah,0);
                                }else if(pilih3==3){
                                    br = new cTransaksi(String.valueOf(kode),nama,brg3,jumlah,0);
                                }else if(pilih3==4){
                                    br = new cTransaksi(String.valueOf(kode),nama,brg4,jumlah,0);
                                }else if(pilih3==5){
                                    br = new cTransaksi(String.valueOf(kode),nama,brg5,jumlah,0);
                                }
                                beli.tambahTransaksi(br);
                                
                                break;
                            case 2:
                                //hapus transaksi
                                beli.lihatTransaksi();
                                System.out.println("Hapus Nomor = ");
                                int hapus = sc.nextInt();
                                beli.hapusTransaksi(hapus);
                                break;
                            case 3:
                                beli.lihatTransaksi();
                                break;
                            case 4:
                                //selesai. sambungkan transaksi pembeli
                                //ke antrian transaksi toko
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                System.out.println("Selamat Datang kembali...");
                                break;
                        }
                    } while (pilih2!=4);
                    
                    break;
                case 2:
                    //Anggota
                    System.out.println("Menu Member");
                    System.out.println("1. Lanjut");
                    System.out.println("2. Ubah Pin");
                    System.out.println("3. Exit");
                    System.out.print("Pilih = ");
                    pilih = sc.nextInt();
                    switch(pilih){
                        case 1:
                           boolean valid=false;
                            do{
                                System.out.print("ID = ");
                                id=sc.nextInt();
                                System.out.print("PIN = ");
                                pin=sc.nextInt();

                                if(id==id1 && pin==pwd1){
                                    valid=true;
                                }else if(id==id2 && pin==pwd2){
                                    valid=true;
                                }else if(id==id3 && pin==pwd3){
                                    valid=true;
                                }

                                if(valid==false){
                                    System.out.println("ID/PIN Salah!");
                                }else{ 
                                    break;
                                }

                            }while(valid==false);  

                            if(valid==true){
                                System.out.println("Selamat Datang Member");
                                kode++;
                                beli = new cDaftarTransaksi();
                                do {
                                    System.out.println("Akun Member");
                                    System.out.println("1. Tambah");
                                    System.out.println("2. Hapus");
                                    System.out.println("3. Lihat");
                                    System.out.println("4. Kembali");
                                    System.out.print("Pilih = ");
                                    pilih2=sc.nextInt();
                                    switch(pilih2){
                                        case 1:
                                            cTransaksi br=null;
                                            System.out.println("Daftar Barang : ");
                                            System.out.println("1. Tas");
                                            System.out.println("2. Sandal");
                                            System.out.println("3. Sepatu");
                                            System.out.println("4. Kemeja");
                                            System.out.println("5. Celana");
                                            System.out.print("Pilih = ");
                                            pilih3=sc.nextInt();
                                            System.out.print("Jumlah = ");
                                            jumlah=sc.nextInt();
                                            if(pilih3==1){
                                                br = new cTransaksi(String.valueOf(kode),String.valueOf(id),brg1,jumlah,0);
                                            }else if(pilih3==2){
                                                br = new cTransaksi(String.valueOf(kode),String.valueOf(id),brg2,jumlah,0);
                                            }else if(pilih3==3){
                                                br = new cTransaksi(String.valueOf(kode),String.valueOf(id),brg3,jumlah,0);
                                            }else if(pilih3==4){
                                                br = new cTransaksi(String.valueOf(kode),String.valueOf(id),brg4,jumlah,0);
                                            }else if(pilih3==5){
                                                br = new cTransaksi(String.valueOf(kode),String.valueOf(id),brg5,jumlah,0);
                                            }
                                            beli.tambahTransaksi(br);

                                            break;
                                        case 2:
                                            //hapus transaksi
                                            beli.lihatTransaksi();
                                            System.out.println("Hapus Nomor = ");
                                            int hapus = sc.nextInt();
                                            beli.hapusTransaksi(hapus);
                                            break;
                                        case 3:
                                            //menampilkan daftar belanja dan diskon
                                            beli.lihatTransaksiMember();
                                            break;
                                        case 4:
                                            //selesai. sambungkan transaksi pembeli
                                            //ke antrian transaksi toko
                                            jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                            System.out.println("Selamat Datang kembali...");
                                            break;
                                    }
                                } while (pilih2!=4);
                                break;
                            }
                            break;
                            
                            case 2:
                            valid = false;
                            do {
                                System.out.print("ID = ");
                                id = sc.nextInt();
                                System.out.print("PIN Lama = ");
                                pin = sc.nextInt();
                                if (id == id1 && pin == pwd1) {

                                    System.out.print("Pin baru : ");
                                    pinbaru1 = sc.nextInt();
                                    pwd1 = pinbaru1;

                                    valid = true;
                                } else if (id == id2 && pin == pwd2) {

                                    System.out.print("Pin baru : ");
                                    pinbaru2 = sc.nextInt();
                                    pwd2 = pinbaru2;

                                    valid = true;
                                } else if (id == id3 && pin == pwd3) {

                                    System.out.print("Pin baru : ");
                                    pinbaru3 = sc.nextInt();
                                    pwd3 = pinbaru3;
                                    valid = true;
                                }
                                if (valid == true) {
                                    System.out.println("Pin berhasil di perbarui");
                                } else {
                                    break;
                                }
                                break;
                            } while (valid == true);

                            break;
                        case 3:
                            System.out.println("Selamat Datang kembali...");
                            break;

                    }

                    break;
                            
                            
                case 3:
                    //Admin
                    boolean valid=false;
                    System.out.println("Akun Admin");
                    
                    do{
                        System.out.print("Masukkan Password : ");
                        admin = sc.next();
                        
                        if(admin.compareTo(pwdadmin)==0){
                            valid=true;
                        }

                        if(valid==false){
                            System.out.println("Password Salah!");
                        }else{ 
                            break;
                        }
                        
                    }while(valid==false);
                    
                    jual.lihatTransaksi();
                    //memproses setiap transasksi yang belum diproses
                    cTransaksi t=jual.getFront();
                    do{
                        if(t.getStatus()==0){
                            System.out.println("Kode    : "+t.getKode());
                            System.out.println("Pembeli : "+t.getPembeli());
                            System.out.println("Barang  : "+t.getBarang().getNama());
                            System.out.println("Jumlah  : "+t.getJumlah());
                            System.out.println("");
                            System.out.println("Jumlah Transaksi yang Belum Diproses    : " + jual.lihatBelumDiproses());
                            System.out.println("Total Transaksi yang Belum Diproses     : " + jual.lihatUnpemasukan());
                            System.out.println("-Pilih Aksi-");
                            System.out.println("1. Diproses");
                            System.out.println("2. Selesai");
                            System.out.print("Pilih = ");
                            int aksi=sc.nextInt();
                            if(aksi==1){
                                jual.prosesTransaksi(t);
                                System.out.println("Berhasil diproses..");
                            }else{
                                break;
                            }
                        }
                        t=t.next;
                    }while(t!=null);
                    break;
                case 4:
                    //Pemilik
                     valid=false;
                    System.out.println("Akun Pemilik");
                    
                    do{
                        System.out.print("Masukkan Password : ");
                        pemilik = sc.next();
                        
                        if(pemilik.compareTo(pwdpemilik)==0){
                            valid=true;
                        }

                        if(valid==false){
                            System.out.println("Password Salah!");
                        }else{ 
                            break;
                        }
                        
                    }while(valid==false);

                    System.out.println("Jumlah Transaksi yang Sudah Diproses    : "+jual.lihatDiproses());
                    System.out.println("JUmlah Pemasukkan                       : "+jual.lihatPemasukan());
                    System.out.println("");
                    System.out.println("1. Ubah Harga");
                    System.out.println("2. Laporan Penjualan Barang");
                    System.out.println("3. Laporan Pembelian Member");
                    System.out.println("4. Grafik Penjualan");
                    System.out.println("5. Exit");
                    System.out.print("Pilih = ");
                    pilih = sc.nextInt();
                    
                    switch(pilih){
                        case 1 :
                            break;
                        case 2 :
                            break;
                        case 3 :
                            break;
                        case 4 :
                            break;
                        case 5v :
                            break;
                    }
                    
                    break;
                case 5:
                    System.out.println("Terima Kasih..");
                    break;         
            }
        } while (pilih!=5);
        
    }
}
