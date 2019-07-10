package io.github.lvbo.learn.spring.boot.mmh.dao.hbase;

import io.github.lvbo.learn.spring.boot.mmh.model.Role;

import java.util.List;

/**
 * @author lvbo
 */
public interface RoleMapper {
	
	List<Role> getAll();
	
	Role getOne(Long id);

	void insert(Role user);

	void update(Role user);

	void delete(Long id);

}