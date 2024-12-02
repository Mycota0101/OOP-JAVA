import java.util.ArrayList;

public class MusicOrganizer {
    private ArrayList<MusicTrack> tracks;
    private MusicPlayer player;

    public MusicOrganizer() {
        tracks = new ArrayList<>();
        player = new MusicPlayer();
    }

    public void addTrack(String title, String artist, int duration) {
        MusicTrack newTrack = new MusicTrack(title, artist, duration);
        tracks.add(newTrack);
        System.out.println("Track added: " + title);
    }

    public void playTrack(int index) {
        if (index >= 0 && index < tracks.size()) {
            MusicTrack track = tracks.get(index);
            player.play(track);
        } else {
            System.out.println("Invalid track index.");
        }
    }

    public void stopPlaying() {
        player.stop();
    }

    public void displayAllTracks() {
        if (tracks.isEmpty()) {
            System.out.println("No tracks in the organizer.");
        } else {
            for (int i = 0; i < tracks.size(); i++) {
                System.out.println("Track " + (i + 1) + ":");
                tracks.get(i).displayTrackInfo();
                System.out.println();
            }
        }
    }

    public int getTrackCount() {
        return tracks.size();
    }

    public void removeTrack(int index) {
        if (index >= 0 && index < tracks.size()) {
            MusicTrack removedTrack = tracks.remove(index);
            System.out.println("Track removed: " + removedTrack.getTitle());
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (MusicTrack track : tracks) {
            if (track.getTitle().equalsIgnoreCase(title)) {
                track.displayTrackInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Track with title '" + title + "' not found.");
        }
    }

    public void searchByArtist(String artist) {
        boolean found = false;
        for (MusicTrack track : tracks) {
            if (track.getArtist().equalsIgnoreCase(artist)) {
                track.displayTrackInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tracks found by artist '" + artist + "'.");
        }
    }
}
