import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicOrganizer organizer = new MusicOrganizer();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Music Organizer Menu ===");
            System.out.println("1. Add Track");
            System.out.println("2. View All Tracks");
            System.out.println("3. Play Track");
            System.out.println("4. Stop Playing");
            System.out.println("5. Search Track by Title");
            System.out.println("6. Search Track by Artist");
            System.out.println("7. Remove Track");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter duration (in seconds): ");
                    int duration = scanner.nextInt();
                    organizer.addTrack(title, artist, duration);
                    break;
                case 2:
                    System.out.println("\nAll Tracks:");
                    organizer.displayAllTracks();
                    break;
                case 3:
                    System.out.print("Enter track number to play: ");
                    int trackNumber = scanner.nextInt();
                    organizer.playTrack(trackNumber - 1);  
                    break;
                case 4:
                    organizer.stopPlaying();
                    break;
                case 5:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    organizer.searchByTitle(searchTitle);
                    break;
                case 6:
                    System.out.print("Enter artist to search: ");
                    String searchArtist = scanner.nextLine();
                    organizer.searchByArtist(searchArtist);
                    break;
                case 7:
                    System.out.print("Enter track number to remove: ");
                    int removeTrackNumber = scanner.nextInt();
                    organizer.removeTrack(removeTrackNumber - 1);  // -1 for zero-based index
                    break;
                case 8:
                    System.out.println("Exiting Music Organizer...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (choice != 8);

        scanner.close();
    }
}