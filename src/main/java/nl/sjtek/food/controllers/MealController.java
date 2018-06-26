package nl.sjtek.food.controllers;

import nl.sjtek.food.models.Meal;
import nl.sjtek.food.repository.MealRepository;
import nl.sjtek.food.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/meals")
public class MealController {

    private final MealRepository mealRepository;
    private final TagRepository tagRepository;

    @Autowired
    public MealController(MealRepository mealRepository, TagRepository tagRepository) {
        this.mealRepository = mealRepository;
        this.tagRepository = tagRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Meal> getAll() {
        return mealRepository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Meal add(String name) {
        Meal meal = new Meal(name);
        return mealRepository.save(meal);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Meal get(@PathVariable Long id) {
        return mealRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        mealRepository.delete(id);
    }
}
