package service;

import annotation.Bean;
import annotation.DependInjection;
import dao.UserMapper;

@Bean
public class UserServiceImpl implements UserService {

    @DependInjection
    UserMapper userMapper;
}
