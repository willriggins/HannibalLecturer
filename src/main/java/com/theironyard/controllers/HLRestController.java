package com.theironyard.controllers;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.sql.SQLException;

/**
 * Created by will on 7/1/16.
 */
@RestController
public class HLRestController {
    @Autowired
    LecturerRepository lecturers;

    @Autowired
    ReviewRepository reviews;

    @PostConstruct
    public void init() throws SQLException {
        Server.createWebServer().start();
    }

    //post routes should be void?

    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public void lecturer(String name, String topic, String image) {
        Lecturer lecturer = new Lecturer(name, topic, image);
        lecturers.save(lecturer);
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void review(String author, String text, int lecturerId, boolean isGood) {
        Lecturer lecturer = lecturers.findOne(lecturerId);
        Review review = new Review(author, text, lecturerId, isGood);
        reviews.save(review);
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public Iterable<Lecturer> getLecturers() {
        return lecturers.findAll();
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> getReviews() {
        return reviews.findAll();
    }



}
