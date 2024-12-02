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
        System.out.println("Selamat datang di support system.");
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
            responses.put("halo", "Halo bro, apa kabar?");
            responses.put("makan", "Sudah makan belum?");
            responses.put("tidur", "Tidur itu penting, (optional)");
            responses.put("belajar", "Semangat belajarnya! Kalau capek jangan lupa istirahat.");
            responses.put("kerja", "Lagi kerja apa nih? Jangan lupa istirahat sebentar.");
        }

        public String generateResponse(String input) {
            // Cek apakah input pengguna ada dalam daftar respon
            if (responses.containsKey(input.toLowerCase())) {
                return responses.get(input.toLowerCase());
            } else {
                return generateRandomResponse();  // Mengembalikan respon acak jika tidak ada kecocokan
            }
        }

        private String generateRandomResponse() {
            String[] defaultResponses = {
                "Saya kurang paham maksudnya, bisa jelaskan lagi?",
                "Maaf saya kurang paham"
            };
            int index = random.nextInt(defaultResponses.length);
            return defaultResponses[index];
        }
    }
}
