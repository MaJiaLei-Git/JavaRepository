package cn.mjl.mapper;

import cn.mjl.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MJL
 * @version 1.0
 * @date 2021/5/11 11:19
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> queryUserList();
}
