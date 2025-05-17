package com.example.TTCS.repository;

import com.example.TTCS.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
//    List<Review> findByBookBookId(Long bookId);
//    List<Review> findByIsApprovedFalse();
}
