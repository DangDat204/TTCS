package com.example.TTCS.repository;
import com.example.TTCS.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
//    List<Cart> findByUserUserId(Long userId);
//    Optional<Cart> findByUserUserIdAndBookBookId(Long userId, Long bookId);
}
