package ifksp.repository;

import ifksp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select u from User u")
//    List<User> getUsers();
    List<User> findAllByOrderByIdAsc();
}
