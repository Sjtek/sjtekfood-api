package nl.sjtek.food.controllers;

import nl.sjtek.food.models.Dinner;
import nl.sjtek.food.models.Meal;
import nl.sjtek.food.models.NextMeal;
import nl.sjtek.food.repository.DinnerRepository;
import nl.sjtek.food.repository.MealRepository;
import nl.sjtek.food.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wouter on 13-11-16.
 */

@RestController
@RequestMapping("/next")
public class NextController {

    private final MealRepository mealRepository;
    private final DinnerRepository dinnerRepository;
    private final TagRepository tagRepository;

    private final Random random = new Random();
    private NextMeal nextMeal = new NextMeal();

    @Autowired
    public NextController(MealRepository mealRepository, DinnerRepository dinnerRepository, TagRepository tagRepository) {
        this.mealRepository = mealRepository;
        this.dinnerRepository = dinnerRepository;
        this.tagRepository = tagRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public NextMeal get() {
        return nextMeal;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public NextMeal refresh(@RequestParam(value = "tags") String[] tags) {
        List<Meal> meals = new ArrayList<>();
        for (Meal meal : mealRepository.findAll()) {
            meals.add(meal);
        }

        Iterable<Dinner> dinners = dinnerRepository.findLast7ByOrderByDateAsc();

        for (Dinner dinner : dinners) {
            meals.remove(dinner.getMeal());
        }

        return nextMeal.set(meals.get(random.nextInt(meals.size())));
    }
}
