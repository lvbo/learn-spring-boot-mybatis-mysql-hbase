package io.github.lvbo.learn.spring.boot.mmh.controller;

import io.github.lvbo.learn.spring.boot.mmh.dao.hbase.RoleMapper;
import io.github.lvbo.learn.spring.boot.mmh.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lvbo
 */
@RequestMapping(value = "/role")
@RestController
public class RoleController {

    @Autowired
    private RoleMapper roleMapper;

    @GetMapping
	public List<Role> getRoles() {
		List<Role> roles= roleMapper.getAll();
		return roles;
	}
	
    @GetMapping("/{id}")
    public Role getRole(@PathVariable Long id) {
    	Role role = roleMapper.getOne(id);
        return role;
    }

    @PostMapping
    public void create(Role role) {
        roleMapper.insert(role);
    }

    @PutMapping
    public void update(Role role) {
        roleMapper.update(role);
    }
    
    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable("id") Long id) {
        roleMapper.delete(id);
    }
    
    
}