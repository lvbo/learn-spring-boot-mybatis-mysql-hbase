package io.github.lvbo.learn.spring.boot.mmh.dao.hbase;

import io.github.lvbo.learn.spring.boot.mmh.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {

	@Autowired
	private RoleMapper roleMapper;

	@Test
	public void testInsert() throws Exception {
		roleMapper.insert(new Role(1, "a1"));
		roleMapper.insert(new Role(2, "a2"));
		roleMapper.insert(new Role(3, "a3"));
	}

	@Test
	public void testGetAll() throws Exception {
		List<Role> roles = roleMapper.getAll();
		if(roles==null || roles.size()==0){
			System.out.println("is null");
		}else{
			System.out.println(roles.size());
		}
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		Role role = roleMapper.getOne(1L);
		System.out.println(role);
		role.setName("lvbo");
		roleMapper.update(role);
	}

}