package io.github.lvbo.learn.spring.boot.mmh.dao.mysql;

import io.github.lvbo.learn.spring.boot.mmh.model.User;

import java.util.List;

/**
 * @author lvbo
 */
public interface UserMapper {
	
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);

}