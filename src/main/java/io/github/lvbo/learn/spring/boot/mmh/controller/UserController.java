package io.github.lvbo.learn.spring.boot.mmh.controller;

import io.github.lvbo.learn.spring.boot.mmh.dao.mysql.UserMapper;
import io.github.lvbo.learn.spring.boot.mmh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lvbo
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping
	public List<User> getUsers() {
		List<User> users= userMapper.getAll();
		return users;
	}
	
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
    	User user= userMapper.getOne(id);
        return user;
    }

    @PostMapping
    public void create(User user) {
        userMapper.insert(user);
    }

    @PutMapping
    public void update(User user) {
        userMapper.update(user);
    }
    
    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }
    
    
}