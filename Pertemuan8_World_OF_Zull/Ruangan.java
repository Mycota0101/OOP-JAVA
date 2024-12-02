import java.util.HashMap;

public class Ruangan {
    private String deskripsi;
    private HashMap<String, Ruangan> pintuKeluar;
    private String rintangan;
    private Item item;

    public Ruangan(String deskripsi) {
        this.deskripsi = deskripsi;
        pintuKeluar = new HashMap<>();
    }

    public void setPintuKeluar(String arah, Ruangan tetangga) {
        pintuKeluar.put(arah, tetangga);
    }

    public void setRintangan(String rintangan) {
        this.rintangan = rintangan;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getDeskripsiSingkat() {
        return deskripsi;
    }

    public String getDaftarPintuKeluar() {
        StringBuilder daftarPintu = new StringBuilder("Pintu keluar:");
        for (String arah : pintuKeluar.keySet()) {
            daftarPintu.append(" ").append(arah);
        }
        return daftarPintu.toString();
    }

    public Ruangan getPintuKeluar(String arah) {
        return pintuKeluar.get(arah);
    }

    public String getRintangan() {
        return rintangan;
    }

    public Item getItem() {
        return item;
    }

    public boolean adaRintangan() {
        return rintangan != null;
    }
}
