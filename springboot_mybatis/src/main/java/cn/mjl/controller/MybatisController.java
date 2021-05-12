package cn.mjl.controller;

import cn.mjl.domain.User;
import cn.mjl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author MJL
 * @version 1.0
 * @date 2021/5/11 11:31
 */
@Controller
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/queryUser")
    @ResponseBody
    public List<User> queryUserList() {
        List<User> users = userMapper.queryUserList();
        return users;
    }
}
