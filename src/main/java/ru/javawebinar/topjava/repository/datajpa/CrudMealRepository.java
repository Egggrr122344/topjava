package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {


    @Transactional
    @Modifying
    @Query("DELETE FROM Meal m WHERE m.user.id = :userId AND m.id = :id")
    boolean delete(@Param("userId") int userId, @Param("id") int id);


    @Query("SELECT m from Meal m WHERE m.id =:id AND m.user.id =:userId")
    Meal get(@Param("id") int id, @Param("userId") int userId);


    @Query("SELECT m FROM Meal m WHERE m.user.id =: user_id ORDER BY m.dateTime DESC ")
    List<Meal> findAllForUserSorted(@Param("user_id") int user_id);

    @Query("SELECT m FROM Meal m WHERE m.user.id =: user_id AND m.dateTime BETWEEN :startTime AND :endTime")
    List<Meal> getBetween(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime, @Param("user_id")int user_id);

}
