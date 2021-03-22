package apple.cloneApple.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class FavoriteController {

    @GetMapping("/cartList")
    public String getFavList(HttpSession session, Model model) throws Exception {
        logger.info("get cart list");

        //session에 저장해두었던 userId
        String userId = (String)session.getAttribute("member");

        // DB에 저장되어있던 favList
        //List<Favorite> favList = service.cartList(userId);

        model.addAttribute("favList", favList);

        return "/favList";
    }

}