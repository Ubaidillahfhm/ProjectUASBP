package pkgFinalProjectUAS;

public class cDaftarTransaksi {
    cTransaksi front,rear;
    int jumlah;
    cDaftarTransaksi(){
        front=rear=null;
        jumlah=0;
    }
    
    public cTransaksi getFront(){
        return front;
    }
    
    public cTransaksi getRear(){
        return rear;
    }
    
    public void tambahTransaksi(cTransaksi baru){
        if(rear==null){
            front=rear=baru;
        }else{
           rear.next=baru;
           rear=baru;
        }
        System.out.println("Penambahan Sukses....");
    }
    
    public void lihatTransaksi(){
        int i=1;
        System.out.println("Daftar Transaksi :");
        for(cTransaksi t=front; t!=null; t=t.next){
            System.out.print(i+".");
            System.out.print(t.getKode()+"-");
            System.out.print(t.getPembeli()+"-");
            System.out.print(t.getBarang().getNama()+"-");
            System.out.print(t.getJumlah()+"-");
            System.out.println(t.getStatus());
            i++;
        }
    }
    
    public void lihatTransaksiMember(){
        int i=1;
        double total=0,diskon;
        System.out.println("Daftar Transaksi Member :");
        for(cTransaksi t=front; t!=null; t=t.next){
            System.out.print(i+".");
            System.out.print(t.getKode()+"-");
            System.out.print(t.getPembeli()+"-");
            System.out.print(t.getBarang().getNama()+"-");
            System.out.print(t.getJumlah()+"-");
            System.out.println(t.getStatus());
            i++;
            total=total+(t.getBarang().getHarga()*t.getJumlah());
        }
        System.out.println("Total Belanja   : "+total);
        System.out.println("Diskon          : "+(0.1*total));
        System.out.println("Jumlah Dibayar  : "+(total-(0.1*total)));
    }
    
    public void hapusTransaksi(int nomor){
        cTransaksi t=front;
        cTransaksi prev=null; 
        int i=1;
        if(nomor==1){ //hapus posisi terdepan
            if(t.next==null){
                front=rear=null;
            }else{
                front=front.next;
                t.next=null;
            }
            System.out.println("["+t.getBarang().getNama()+"] dihapus");
        }else{
            for(; t!=null; t=t.next){
                if(i==nomor){
                    break;
                }
                i++;
                prev=t;
            }
            //yang dihapus diujung belakang
            if(t.next==null){
                rear=prev;
                rear.next=null;
            }else{
                prev.next=t.next;
                t.next=null;
            }
            System.out.println("["+t.getBarang().getNama()+"] dihapus");
        }
    }
    
    public void sambungTransaksi(cTransaksi depan,cTransaksi belakang){
        //sambungkan transaksi
        if(rear==null){ //transaksi toko masih kosong
            front=depan;
            rear=belakang;
        }else{
        rear.next=depan;
        //update posisi rear 
        rear=belakang;
        }   
    }
    
    public void prosesTransaksi(cTransaksi t){
        //cek member
        t.setStatus(1);
    }
    
    public void prosesTransaksiMember(cTransaksi t){
        //mendapatkan diskon
    }
    
    public int lihatDiproses(){
        cTransaksi t=front;
        int proses=0;
        for(;t!=null; t=t.next){
            if(t.getStatus()==1){
                proses++;
            }
        }
        return proses;
    }
    
    public int lihatBelumDiproses(){
        cTransaksi t=front;
        int belumDiproses=0;
        for(; t!=null; t=t.next){
            if(t.getStatus()==0){
                belumDiproses++;
            }
        }
        return belumDiproses;
    }
    
    public double lihatPemasukan(){
       cTransaksi t=front;
        double nominal=0;
        for(;t!=null; t=t.next){
            if(t.getStatus()==1){
                //cek member berdasarkan data/kode pembeli
                nominal=nominal+t.getBarang().getHarga()*t.getJumlah();
                if(t.getPembeli().compareToIgnoreCase("10")==0 || t.getPembeli().compareToIgnoreCase("11")==0 || t.getPembeli().compareToIgnoreCase("12")==0){
                    nominal=nominal-(0.1*nominal);
                }   
            }
        }
        return nominal; 
    }
    
    public double lihatUnpemasukan(){
       cTransaksi t=front;
        double nominal=0;
        for(;t!=null; t=t.next){
            if(t.getStatus()==0){
                //cek member berdasarkan data/kode pembeli
                nominal=nominal+t.getBarang().getHarga()*t.getJumlah();
                if(t.getPembeli().compareToIgnoreCase("10")==0 || t.getPembeli().compareToIgnoreCase("11")==0 || t.getPembeli().compareToIgnoreCase("12")==0){
                    nominal=nominal-(0.1*nominal);
                }   
            } 
        }
        return nominal;
    }
}
