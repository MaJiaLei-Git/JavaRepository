package cn.mjl;

import cn.mjl.domain.User;
import cn.mjl.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author MJL
 * @version 1.0
 * @date 2021/5/11 12:32
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDatajpaApplication.class)
public class RedisTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() throws JsonProcessingException {
        //1.先从redis中获取数据  数据形式为：字符串
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();
        //2.判断redis中是否存在数据
        System.out.println("1:" + userListJson);
        if (userListJson == null) {
            //3.Redis中没有数据，从数据库查询，并存入Redis中
            List<User> users = userRepository.findAll();
            //将集合转换为json格式的字符串  使用Jackson进行转换
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson = objectMapper.writeValueAsString(users);
            redisTemplate.boundValueOps("user.findAll").set(userListJson);
            System.out.println("=====从数据库中查询的数据=====");
        } else {
            //4.Redis中有数据，直接从Redis中拿数据
            System.out.println("=====从Redis中查询的数据=====");
        }
        System.out.println("2:" + userListJson);
    }
}
