package com.example.TTCS.repository;

import com.example.TTCS.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
//    List<Review> findByBookBookId(Long bookId);
//    List<Review> findByIsApprovedFalse();
}
