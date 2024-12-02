public class MusicPlayer {
    public void play(MusicTrack track) {
        System.out.println("Now playing: " + track.getTitle() + " by " + track.getArtist());
    }

    public void stop() {
        System.out.println("Music stopped.");
    }
}