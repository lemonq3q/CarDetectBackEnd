package com.example.test.mapper;


import com.example.test.entity.User;

import java.util.List;

public interface UserPermissionMapper {

    public List<User> select(User params);

    public void add(List<User> params);

    public void delete(User params);
}
