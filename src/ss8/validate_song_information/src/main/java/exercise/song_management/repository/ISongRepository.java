package exercise.song_management.repository;

import exercise.song_management.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {

}
