package gevak.dao;

import gevak.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDAO extends JpaRepository<User, Integer> {

    @Query("from User u where u.username=:username")
    public User findByUserName(@Param("username") String username);

}
