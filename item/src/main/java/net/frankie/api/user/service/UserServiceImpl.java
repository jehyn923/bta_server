package net.frankie.api.user.service;

import lombok.RequiredArgsConstructor;
import net.frankie.api.user.domain.User;
import net.frankie.api.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public boolean existByUsername(String username) { return userRepository.existsByUsername(username); }

    @Override
    public Optional<User> findByUsername(String username) { return userRepository.findByUsername(username); }

    @Override
    public User signin(String username, String password) { return userRepository.signin(username,password); }

    @Override
    public List<User> findAll() { return userRepository.findAll(); }

    @Override
    public User getById(long id) { return userRepository.getById(id); }

    @Override
    public void save(User user) { userRepository.save(user); }

    @Override
    public void count() { userRepository.count(); }

    @Override
    public void deleteById(long id) { userRepository.deleteById(id); }
}
