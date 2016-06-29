package com.theironyard.services;

import com.sun.tools.javac.util.List;
import com.theironyard.entities.Beer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by zach on 11/10/15.
 */
public interface BeerRepository extends CrudRepository<Beer, Integer> {
    public Iterable<Beer> findByType(String type);
    public Iterable<Beer> findByTypeAndCalories(String type, Integer calories);
    public Iterable<Beer> findByTypeAndCaloriesIsLessThanEqual(String type, Integer calories);

    public Beer findFirstByType(String type);
    public int countByType(String type);
    public Iterable<Beer> findByTypeOrderByNameAsc(String type);

    @Query("SELECT b FROM Beer b WHERE LOWER(name) LIKE '%' || LOWER(?) || '%'")
    Iterable<Beer> searchByName(String name);
}
