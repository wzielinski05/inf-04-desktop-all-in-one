public class Utwor {
    String artist;
    String album;
    int songsNumber;
    int year;
    int downloadNumber;

    public Utwor(String artist, String album, int songsNumber, int year, int downloadNumber) {
        this.artist = artist;
        this.album = album;
        this.songsNumber = songsNumber;
        this.year = year;
        this.downloadNumber = downloadNumber;
    }

    @Override
    public String toString() {
        return "Utwor{" +
                "artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", songsNumber=" + songsNumber +
                ", year=" + year +
                ", downloadNumber=" + downloadNumber +
                '}';
    }
}
