package kg.attractor.demo.service.impl;

import kg.attractor.demo.dao.UserDao;
import kg.attractor.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserServiceImpl {

    private final List<User> users;
    private final UserDao userDao;

    public User save(User user) {
        return user;
    }

    public User getUserById(int userid) {
        return users.stream().filter(m -> m.getId() == userid).findAny().orElseThrow();
    }

    public List<User> findByUserName(String name) {
        return userDao.getByName(name);
    }

    public List<User> findByUserPhone(String phone) {
        return userDao.getByPhone(phone);
    }

    public List<User> findByUserEmail(String email) {
        return userDao.getByEmail(email);
    }

    public boolean getCheckByEmail(String email) {
        return userDao.existsByEmail(email);
    }


}
