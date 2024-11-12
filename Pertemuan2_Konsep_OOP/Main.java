// Abstract class Kendaraan
abstract class Kendaraan {
    private String merek;
    private int tahun;

    // Constructor
    public Kendaraan(String merek, int tahun) {
        this.merek = merek;
        this.tahun = tahun;
    }

    // Getter dan Setter untuk encapsulation
    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    // Method abstract
    abstract void nyalakanMesin();

    // Method untuk menampilkan informasi kendaraan
    public void tampilkanInfo() {
        System.out.println("Merek: " + merek + ", Tahun: " + tahun);
    }
}

// Kelas turunan Mobil yang meng-extend Kendaraan
class Mobil extends Kendaraan {
    private int jumlahPintu;

    // Constructor
    public Mobil(String merek, int tahun, int jumlahPintu) {
        super(merek, tahun);
        this.jumlahPintu = jumlahPintu;
    }

    // Implementasi method abstract
    @Override
    void nyalakanMesin() {
        System.out.println("Mesin mobil " + getMerek() + " dinyalakan. Brum... Brum...");
    }

    // Method untuk menampilkan informasi tambahan tentang mobil
    public void tampilkanInfoMobil() {
        tampilkanInfo();
        System.out.println("Jumlah Pintu: " + jumlahPintu);
    }
}

// Kelas turunan Motor yang meng-extend Kendaraan
class Motor extends Kendaraan {
    private String tipeHandle;

    // Constructor
    public Motor(String merek, int tahun, String tipeHandle) {
        super(merek, tahun);
        this.tipeHandle = tipeHandle;
    }

    // Implementasi method abstract
    @Override
    void nyalakanMesin() {
        System.out.println("Mesin motor " + getMerek() + " dinyalakan. Ngeng... Ngeng...");
    }

    // Method untuk menampilkan informasi tambahan tentang motor
    public void tampilkanInfoMotor() {
        tampilkanInfo();
        System.out.println("Tipe Handle: " + tipeHandle);
    }
}

// Main class untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        // Membuat objek Mobil
        Mobil mobil = new Mobil("Toyota", 2020, 4);
        mobil.nyalakanMesin();           // Polymorphism: Memanggil method nyalakanMesin() milik Mobil
        mobil.tampilkanInfoMobil();

        System.out.println();

        // Membuat objek Motor
        Motor motor = new Motor("Honda", 2018, "Sport");
        motor.nyalakanMesin();           // Polymorphism: Memanggil method nyalakanMesin() milik Motor
        motor.tampilkanInfoMotor();
    }
}
