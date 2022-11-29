package exercise.song_management.service;

import exercise.song_management.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> finALl();
    void save (Song song);
    Song findById(Integer id);
}
