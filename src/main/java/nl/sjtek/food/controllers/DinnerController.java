package nl.sjtek.food.controllers;

import nl.sjtek.food.models.Dinner;
import nl.sjtek.food.models.Meal;
import nl.sjtek.food.repository.DinnerRepository;
import nl.sjtek.food.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/dinners")
public class DinnerController {

    private final Random random = new Random();
    private final DinnerRepository dinnerRepository;
    private final MealRepository mealRepository;

    @Autowired
    public DinnerController(DinnerRepository dinnerRepository, MealRepository mealRepository) {
        this.dinnerRepository = dinnerRepository;
        this.mealRepository = mealRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Dinner> getAll() {
        return dinnerRepository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Dinner add(@DateTimeFormat(pattern = "yyyyMMdd") Date date, Long mealId) {
        Dinner dinner = new Dinner(date, mealRepository.findOne(mealId));
        return dinnerRepository.save(dinner);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Dinner get(@PathVariable Long id) {
        return dinnerRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        dinnerRepository.delete(id);
    }

    @RequestMapping(value = "/lastweek", method = RequestMethod.GET)
    public Iterable<Dinner> getLastWeek() {
        return dinnerRepository.findLast7ByOrderByDateAsc();
    }

    @RequestMapping(value = "/next", method = RequestMethod.GET)
    public Meal suggestMeal() {
        List<Meal> meals = new ArrayList<>();
        for (Meal meal : mealRepository.findAll()) {
            meals.add(meal);
        }

        Iterable<Dinner> dinners = getLastWeek();

        for (Dinner dinner : dinners) {
            meals.remove(dinner.getMeal());
        }

        return meals.get(random.nextInt(meals.size()));
    }
}
