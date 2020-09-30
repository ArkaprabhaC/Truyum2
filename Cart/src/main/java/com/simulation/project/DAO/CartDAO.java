package com.simulation.project.DAO;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simulation.project.model.Cart;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {
	
	Optional<List<Cart>> findByUserId(int userId);
	
	@Transactional
	@Modifying
	@Query(value = "delete from Cart where userId=?1 and pid=?2")
	void deleteCartItemByUserIdAndPid(int userId, int pid);

}
