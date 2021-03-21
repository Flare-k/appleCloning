package apple.cloneApple.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("member/favorite")
    public String getFavor(Model model) {
        model.addAttribute("favorite", "favorite");

        return "member/favorite";
    }
}