package com.theironyard.services;

import com.theironyard.entities.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by will on 7/1/16.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
