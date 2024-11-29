package com.gamejiffy.gamejiffy.controller;

import com.gamejiffy.gamejiffy.model.User;
import com.gamejiffy.gamejiffy.service.UserService;
import com.gamejiffy.gamejiffy.model.GameData;
import com.gamejiffy.gamejiffy.model.News;
import com.gamejiffy.gamejiffy.service.GameDataService;
import com.gamejiffy.gamejiffy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private GameDataService gameDataService;

    @Autowired
    private NewsService newsService;

    // Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Signup Page
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    // Handle Signup Submission
    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    // Handle Login Submission
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.loginUser(username, password);
        if (user != null) {
            return "redirect:/host";
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    // Home Page
    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    // Host Page
    @GetMapping("/host")
    public String hostPage() {
        return "host";
    }

    // Game Update Page
    @GetMapping("/gameupdate")
    public String gameupdate() {
        return "gameupdate";
    }

    // Admin Page
    @GetMapping("/admin")
    public String adminPage() {
        return "adminUploader";
    }

    // Handle Game Data Upload
    @PostMapping("/uploadGameData")
    public String uploadGameData(
            @RequestParam("category") String category,
        @RequestParam("gameTitle") String gameTitle,
        @RequestParam("currentScore") String currentScore,
        @RequestParam("playerDetails") String playerDetails,
            Model model) {

        GameData gameData = new GameData();
        gameData.setCategory(category);
        gameData.setGameTitle(gameTitle);
        gameData.setCurrentScore(currentScore);
        gameData.setPlayerDetails(playerDetails);

        gameDataService.saveGameData(gameData);
        model.addAttribute("message", "Game data uploaded successfully!");
        return "adminUploader";
    }

    // Handle News Upload
    @PostMapping("/uploadNews")
    public String uploadNews(
            @RequestParam("newsTitle") String newsTitle,
            @RequestParam("tags") String tags,
            @RequestParam("content") String content,
            Model model) {

        News news = new News();
        news.setNewsTitle(newsTitle);
        news.setTags(tags);
        news.setContent(content);
        newsService.saveNews(news);
        model.addAttribute("message", "News uploaded successfully!");
        return "adminUploader";
    }
}
