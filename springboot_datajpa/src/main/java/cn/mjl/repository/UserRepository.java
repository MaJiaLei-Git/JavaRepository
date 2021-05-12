package cn.mjl.repository;

import cn.mjl.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author MJL
 * @version 1.0
 * @date 2021/5/11 12:14
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAll();
}
