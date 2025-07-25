package kg.attractor.demo.service.impl;

import kg.attractor.demo.dao.UserDao;
import kg.attractor.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl {
    private final UserDao userDao;


}
