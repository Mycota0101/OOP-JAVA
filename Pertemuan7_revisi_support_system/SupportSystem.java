import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class SupportSystem {
    private InputReader reader;
    private Responder responder;

    public SupportSystem() {
        reader = new InputReader();
        responder = new Responder();
    }

    public void start() {
        System.out.println("Selamat datang di support system instalasi Windows.");
        System.out.println("Ketik 'bye' untuk keluar dari sistem.");

        boolean finished = false;
        while (!finished) {
            String input = reader.getInput();  // Dapatkan input dari pengguna
            if (input.equalsIgnoreCase("bye")) {
                finished = true;
            } else {
                String response = responder.generateResponse(input);  // Generate response input
                System.out.println(response);
            }
        }
        System.out.println("Goodbyee .... !");
    }

    public static void main(String[] args) {
        SupportSystem system = new SupportSystem();
        system.start();
    }

    // Kelas InputReader sebagai inner class
    private class InputReader {
        private Scanner scanner;

        public InputReader() {
            scanner = new Scanner(System.in);
        }

        public String getInput() {
            System.out.print("> ");  // Menampilkan prompt input
            return scanner.nextLine();  // Mengembalikan input dari pengguna
        }
    }

    // Kelas Responder sebagai inner class
    private class Responder {
        private HashMap<String, String> responses;
        private Random random;

        public Responder() {
            responses = new HashMap<>();
            fillResponses();  // Mengisi daftar respon yang tersedia
            random = new Random();
        }

        private void fillResponses() {
            responses.put("lupaakun", "Jika Anda lupa akun, coba gunakan akun administrator untuk masuk, atau pulihkan akun melalui opsi pemulihan.");
            responses.put("lupapassword", "Jika Anda lupa password, gunakan fitur 'Lupa Password' di layar login atau reset password melalui perangkat lain.");
            responses.put("koneksi", "Pastikan kabel ethernet tersambung atau Wi-Fi aktif untuk koneksi internet selama instalasi.");
            responses.put("partisi", "Pilih partisi yang ingin Anda gunakan untuk menginstal Windows. Hati-hati, ini dapat menghapus data pada partisi yang dipilih.");
            responses.put("driver", "Jika perangkat keras tidak terdeteksi, Anda mungkin perlu menginstal driver terbaru dari situs produsen.");
            responses.put("lisensi", "Masukkan kunci lisensi Windows Anda selama instalasi. Jika tidak, Anda bisa melanjutkan dengan memilih opsi 'Saya tidak memiliki kunci produk'.");
            responses.put("boot", "Pastikan USB atau DVD instalasi dipilih sebagai prioritas pertama di BIOS agar proses instalasi Windows bisa dimulai.");
        }

        public String generateResponse(String input) {
            // Loop melalui semua kunci dalam HashMap
            for (String keyword : responses.keySet()) {
                // Jika input pengguna mengandung kata kunci sebagai substring
                if (input.toLowerCase().contains(keyword.toLowerCase())) {
                    return responses.get(keyword);
                }
            }
            // Mengembalikan respon acak jika tidak ada kecocokan
            return generateRandomResponse();
        }

        private String generateRandomResponse() {
            String[] defaultResponses = {
                "Saya kurang paham maksudnya, bisa jelaskan lagi?",
                "Maaf, saya tidak yakin bagaimana menjawab itu. Coba periksa panduan instalasi."
            };
            int index = random.nextInt(defaultResponses.length);
            return defaultResponses[index];
        }
    }
}
