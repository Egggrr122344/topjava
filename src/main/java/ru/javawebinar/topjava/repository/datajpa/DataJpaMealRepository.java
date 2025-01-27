package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DataJpaMealRepository implements MealRepository {

    private final CrudMealRepository crudRepository;

    private final CrudUserRepository crudUserRepository;

    public DataJpaMealRepository(CrudMealRepository crudRepository, CrudUserRepository crudUserRepository) {
        this.crudRepository = crudRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public Meal save(Meal meal, int userId) {
        meal.setUser(crudUserRepository.getReferenceById(userId));
        if (meal.isNew()) {
            crudRepository.save(meal);
        }

        return get(meal.id(), userId) != null ? meal : null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return get(id, userId) != null && crudRepository.delete(id, userId);
    }

    @Override
    public Meal get(int id, int userId) {
        Meal current = crudRepository.findById(id).orElse(null);

        return current != null && current.getUser().getId() == userId ? current : null;
    }

    @Override
    public List<Meal> getAll(int userId) {
        return List.of();
    }

    @Override
    public List<Meal> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return List.of();
    }
}
