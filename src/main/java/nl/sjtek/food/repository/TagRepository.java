package nl.sjtek.food.repository;

import nl.sjtek.food.models.Tag;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wouter on 13-11-16.
 */
public interface TagRepository extends CrudRepository<Tag, Long> {
    Tag findByName(String name);
}
