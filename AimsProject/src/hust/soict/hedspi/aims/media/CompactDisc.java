package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.exception.PlayerException;

import java.util.*;

public class CompactDisc extends Disc implements Playable {
	
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }
    
    public String toString() {
        return this.getId() + " - CD: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Artist" + this.getArtist() +
                " - Length: " + this.getLength() + " seconds" + 
                " - Cost: " + this.getCost() + "$";
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track: " + track.getTitle() + " has been added to: " + this.getTitle());
        } else {
            System.out.println("Track already exists.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track: " +track.getTitle() + " has been removed from: " + this.getTitle());
        } else {
            System.out.println("Track not found.");
        }
    }
    
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

        Iterator<Track> iter = tracks.iterator();
        while (iter.hasNext()) {
            Track nextTrack = iter.next();
            try {
                nextTrack.play();  // track cũng đã được cập nhật để ném PlayerException nếu length <= 0
            } catch (PlayerException e) {
                System.err.println(e.getMessage()); // In ra lỗi nếu muốn
                throw e; // Ném lại lỗi để toàn bộ CD cũng bị coi là lỗi khi play
            }
        }

        System.out.println("Finished playing CD: " + this.getTitle());
    }



}
