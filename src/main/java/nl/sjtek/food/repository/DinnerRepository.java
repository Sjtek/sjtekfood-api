package nl.sjtek.food.repository;

import nl.sjtek.food.models.Dinner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DinnerRepository extends CrudRepository<Dinner, Long> {
    Iterable<Dinner> findLast7ByOrderByDateAsc();
}
