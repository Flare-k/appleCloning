package apple.cloneApple.controller;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/")
public class HomeController {

    Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping
    public JSONObject home() {
        log.info("home");

        JSONObject data = new JSONObject();
        data.put("Home", "Hello World");
        data.put("Id", "강연욱");

        return data;
    }

    //@GetMapping("member/favorite")
    //public String getFavor() {
        //model.addAttribute("favorite", "favorite");

      //  return "member/favorite";
    //}
}