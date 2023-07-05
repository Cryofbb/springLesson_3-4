package core.controller;

import core.configs.UsersConfig;
import core.models.User;
import core.other.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users-api")
public class UsersApiController {
    @Value("${users-api-path}")

    String usersApiPath;
    @GetMapping("/users")
    public String getUsers() {
        return FileManager.getMapManager().get(String.format("%susers.json", usersApiPath));
    }

    @Autowired
    UsersConfig usersConfig;

    @GetMapping
    public List<User> getUsersList() {
        return usersConfig.getUsers();
    }
}