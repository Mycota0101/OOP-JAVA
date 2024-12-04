// Abstract Class
abstract class MakhlukHidup {
    // Method abstrak
    public abstract void makan();
    public abstract void bergerak();

    // Method konkrit
    public void bernapas() {
        System.out.println("Makhluk hidup bernapas.");
    }
}

// Subclass Manusia
class Manusia extends MakhlukHidup {
    @Override
    public void makan() {
        System.out.println("Manusia makan dengan tangan atau alat makan.");
    }

    @Override
    public void bergerak() {
        System.out.println("Manusia bergerak dengan berjalan atau berlari.");
    }
}

// Subclass Hewan
class Hewan extends MakhlukHidup {
    @Override
    public void makan() {
        System.out.println("Hewan makan dengan mulut atau paruh.");
    }

    @Override
    public void bergerak() {
        System.out.println("Hewan bergerak dengan berlari, terbang, atau berenang.");
    }
}

// Subclass Tumbuhan
class Tumbuhan extends MakhlukHidup {
    @Override
    public void makan() {
        System.out.println("Tumbuhan melakukan fotosintesis untuk makan.");
    }

    @Override
    public void bergerak() {
        System.out.println("Tumbuhan bergerak mengikuti arah cahaya matahari.");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Polimorfisme dengan Abstract Class
        MakhlukHidup manusia = new Manusia();
        MakhlukHidup hewan = new Hewan();
        MakhlukHidup tumbuhan = new Tumbuhan();

        // Demonstrasi fungsi
        System.out.println("Manusia:");
        manusia.bernapas();
        manusia.makan();
        manusia.bergerak();

        System.out.println("\nHewan:");
        hewan.bernapas();
        hewan.makan();
        hewan.bergerak();

        System.out.println("\nTumbuhan:");
        tumbuhan.bernapas();
        tumbuhan.makan();
        tumbuhan.bergerak();
    }
}
