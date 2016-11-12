package nl.sjtek.food.repository;

import nl.sjtek.food.models.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MealRepository extends CrudRepository<Meal, Long> {
}
