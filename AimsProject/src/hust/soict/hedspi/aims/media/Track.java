package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.LimitExceedMediaException;
import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
	
    private String title;
    private int length;
    
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    
    public boolean equals(Object obj) {
        if (this == obj) {  
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        return ((Track)obj).getTitle() == this.getTitle() && ((Track)obj).getLength() == this.getLength();
    }
    
}
