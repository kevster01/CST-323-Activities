package net.codejava;

import java.util.Collection;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//calls jpaRepository methods
public interface UserRepository extends JpaRepository<User, Long> {

	//creates query, finds user by email
	@Query("SELECT u FROM User u WHERE u.email =?1")
	User findByEmail(String email);
}
