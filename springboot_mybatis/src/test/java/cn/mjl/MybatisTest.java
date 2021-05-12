package cn.mjl;

import cn.mjl.domain.User;
import cn.mjl.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author MJL
 * @version 1.0
 * @date 2021/5/11 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        List<User> users = userMapper.queryUserList();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
