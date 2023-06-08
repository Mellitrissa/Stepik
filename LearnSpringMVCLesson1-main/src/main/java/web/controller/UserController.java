package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @GetMapping("/user")
    public String user(@RequestParam("name") String name,
                      @RequestParam("surname") String surname,
                      Model model){
        model.addAttribute("name", name);
        model.addAttribute("surname",surname);
        return "/pages/user";
    }
}
