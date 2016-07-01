package com.theironyard.services;

import com.theironyard.entities.Lecturer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by will on 7/1/16.
 */
public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {
}
