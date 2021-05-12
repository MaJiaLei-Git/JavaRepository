package cn.mjl;

import cn.mjl.domain.User;
import cn.mjl.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDatajpaApplication.class)
public class SpringbootDatajpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test01() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
