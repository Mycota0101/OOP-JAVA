// TicketMachine.java
public class TicketMachine {
    private int price; // harga per tiket
    private int balance; // saldo yang dimasukkan oleh pengguna
    private int total; // total pendapatan mesin tiket

    // Constructor
    public TicketMachine(int ticketPrice) {
        price = ticketPrice;
        balance = 0;
        total = 0;
    }

    // Method untuk menampilkan harga tiket
    public int getPrice() {
        return price;
    }

    // Method untuk memasukkan uang ke mesin tiket
    public void insertMoney(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Anda telah memasukkan: " + amount + " rupiah.");
        } else {
            System.out.println("Masukkan jumlah yang valid.");
        }
    }

    // Method untuk mencetak tiket jika saldo mencukupi
    public void printTicket() {
        if (balance >= price) {
            System.out.println("### Tiket Dinyatakan ###");
            System.out.println("Harga tiket: " + price + " rupiah.");
            balance -= price; // kurangi saldo
            total += price; // tambahkan ke total pendapatan
            System.out.println("Sisa saldo: " + balance + " rupiah.");
        } else {
            System.out.println("Saldo tidak mencukupi. Masukkan lebih banyak uang.");
        }
    }

    // Method untuk mengembalikan saldo
    public int refundBalance() {
        int refund = balance;
        balance = 0;
        return refund;
    }

    // Method untuk melihat total pendapatan mesin tiket
    public int getTotal() {
        return total;
    }

    // Main method untuk testing
    public static void main(String[] args) {
        TicketMachine machine = new TicketMachine(5000); // harga tiket 5000 rupiah

        // Pengguna memasukkan uang dan membeli tiket
        machine.insertMoney(2000);
        machine.printTicket(); // Tidak mencetak tiket karena saldo tidak cukup

        machine.insertMoney(3000);
        machine.printTicket(); // Tiket tercetak

        // Pengguna meminta pengembalian saldo
        System.out.println("Pengembalian saldo: " + machine.refundBalance() + " rupiah.");
    }
}
