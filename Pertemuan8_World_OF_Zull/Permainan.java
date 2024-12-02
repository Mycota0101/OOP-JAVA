import java.util.HashMap;
import java.util.Scanner;

public class Permainan {
    private Ruangan ruanganSaatIni;
    private HashMap<String, Item> inventaris;

    public Permainan() {
        inventaris = new HashMap<>();
        buatRuangan();
    }

    private void buatRuangan() {
        Ruangan ruangTamu, dapur, kamarTidur, taman;
        Item kunci;

        ruangTamu = new Ruangan("di ruang tamu");
        dapur = new Ruangan("di dapur");
        kamarTidur = new Ruangan("di kamar tidur");
        taman = new Ruangan("di taman");
        kunci = new Item("kunci", "Sebuah kunci yang dapat membuka pintu taman.");

        ruangTamu.setPintuKeluar("utara", dapur);
        ruangTamu.setPintuKeluar("timur", kamarTidur);
        dapur.setPintuKeluar("selatan", ruangTamu);
        kamarTidur.setPintuKeluar("barat", ruangTamu);
        kamarTidur.setPintuKeluar("utara", taman);

        kamarTidur.setItem(kunci);
        taman.setRintangan("Pintu taman terkunci. Anda membutuhkan kunci untuk membukanya.");

        ruanganSaatIni = ruangTamu; // Pemain mulai di ruang tamu
    }

    public void mainkan() {
        tampilkanSelamatDatang();

        boolean selesai = false;
        Scanner scanner = new Scanner(System.in);
        while (!selesai) {
            System.out.print("> ");
            String perintah = scanner.nextLine();
            selesai = prosesPerintah(perintah);
        }
        System.out.println("Terima kasih sudah bermain. Sampai jumpa!");
        scanner.close();
    }

    private void tampilkanSelamatDatang() {
        System.out.println("Selamat datang di Dunia Zuul!");
        System.out.println("Ini adalah permainan petualangan berbasis teks dengan teka-teki.");
        System.out.println("Ketik 'bantuan' jika Anda membutuhkan bantuan.");
        System.out.println();
        System.out.println(ruanganSaatIni.getDeskripsiSingkat());
        System.out.println(ruanganSaatIni.getDaftarPintuKeluar());
    }

    private boolean prosesPerintah(String perintah) {
        String[] kata = perintah.split(" ");
        String kataPerintah = kata[0];

        switch (kataPerintah) {
            case "pergi":
                if (kata.length < 2) {
                    System.out.println("Pergi ke mana?");
                } else {
                    pergiKeRuangan(kata[1]);
                }
                break;
            case "ambil":
                ambilItem();
                break;
            case "bantuan":
                tampilkanBantuan();
                break;
            case "inventaris":
                tampilkanInventaris();
                break;
            case "keluar":
                return true;
            default:
                System.out.println("Saya tidak mengerti apa yang Anda maksud...");
        }
        return false;
    }

    private void tampilkanBantuan() {
        System.out.println("Perintah yang tersedia:");
        System.out.println("   pergi <arah> ambil inventaris bantuan keluar");
    }

    private void pergiKeRuangan(String arah) {
        Ruangan ruanganBerikutnya = ruanganSaatIni.getPintuKeluar(arah);
    
        if (ruanganBerikutnya == null) {
            System.out.println("Tidak ada pintu di arah tersebut!");
        } else if (ruanganBerikutnya.adaRintangan() && !inventaris.containsKey("kunci")) {
            System.out.println(ruanganBerikutnya.getRintangan());
        } else {
            ruanganSaatIni = ruanganBerikutnya;
            System.out.println(ruanganSaatIni.getDeskripsiSingkat());
            System.out.println(ruanganSaatIni.getDaftarPintuKeluar());
    
            // Tambahkan logika untuk memeriksa kemenangan
            if (ruanganSaatIni.getDeskripsiSingkat().equals("di taman")) {
                System.out.println("Selamat, Anda berhasil menyelesaikan permainan!");
            }
        }
    }
    

    private void ambilItem() {
        Item item = ruanganSaatIni.getItem();
        if (item != null) {
            inventaris.put(item.getNama(), item);
            System.out.println("Anda mengambil: " + item.getDeskripsi());
            ruanganSaatIni.setItem(null);
        } else {
            System.out.println("Tidak ada item di ruangan ini.");
        }
    }

    private void tampilkanInventaris() {
        System.out.println("Inventaris Anda:");
        if (inventaris.isEmpty()) {
            System.out.println("Kosong.");
        } else {
            for (String namaItem : inventaris.keySet()) {
                System.out.println("- " + namaItem);
            }
        }
    }

    public static void main(String[] args) {
        Permainan permainan = new Permainan();
        permainan.mainkan();
    }
}
