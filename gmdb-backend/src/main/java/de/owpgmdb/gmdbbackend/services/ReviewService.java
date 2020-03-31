package de.owpgmdb.gmdbbackend.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.owpgmdb.gmdbbackend.models.Review;
import de.owpgmdb.gmdbbackend.models.User;
import de.owpgmdb.gmdbbackend.repositories.MovieRepository;
import de.owpgmdb.gmdbbackend.repositories.UserRepository;

/**
 * ReviewService
 */
@Service
public class ReviewService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private MovieRepository movieRepo;

    public Review addReview(Long userId, Long movieId, Review review) {
        if (review == null) {
            throw new IllegalArgumentException("Review must not be null");
        }

        //TODO refactor
        User user = this.userRepo.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
        user.addReview(review);
        userRepo.save(user);

        return null;

        
    }

}