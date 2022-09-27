package ru.uuserless.pp_3_1_1.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.uuserless.pp_3_1_1.springboot.model.User;
import ru.uuserless.pp_3_1_1.springboot.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "/pages/allUsers";
    }

    @GetMapping("/new")
    public String getNewUserForm(@ModelAttribute("user") User user) {
        return "pages/new";
    }

    @PostMapping("/new")
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/pages/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findOneUser(id));
        return "/pages/show";
    }

    @GetMapping("/pages/{id}/edit")
    private String getUpdatedUserData(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findOneUser(id));
        return "/pages/edit";
    }

    @PutMapping("/pages/{id}/edit")
    public String updatedUserData(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/pages/{id}";
    }

    @DeleteMapping("pages/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}