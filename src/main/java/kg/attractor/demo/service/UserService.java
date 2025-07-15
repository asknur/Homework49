package kg.attractor.demo.service;

import kg.attractor.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final List<User> users;

    public UserService(List<User> users) {
        this.users = users;
    }

    public User save(User user) {
        return user;
    }

    public User getUserById(int userid) {
        return users.stream().filter(m -> m.getId() == userid).findAny().orElseThrow();
    }
}
