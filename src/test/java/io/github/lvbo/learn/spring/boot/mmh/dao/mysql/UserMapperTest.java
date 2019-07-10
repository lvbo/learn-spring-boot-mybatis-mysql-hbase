package io.github.lvbo.learn.spring.boot.mmh.dao.mysql;

import io.github.lvbo.learn.spring.boot.mmh.enums.UserSexEnum;
import io.github.lvbo.learn.spring.boot.mmh.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		userMapper.insert(new User("aammxd", "a123456", UserSexEnum.MAN, "a1"));
		userMapper.insert(new User("bbmmxd", "b123456", UserSexEnum.WOMAN, "a2"));
		userMapper.insert(new User("ccmmxd", "b123456", UserSexEnum.WOMAN, "a3"));
	}

	@Test
	public void testGetAll() throws Exception {
		List<User> users = userMapper.getAll();
		if(users==null || users.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(users.size());
		}
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		User user = userMapper.getOne(30L);
		System.out.println(user.toString());
		user.setNickName("lvbo");
		userMapper.update(user);
	}

}