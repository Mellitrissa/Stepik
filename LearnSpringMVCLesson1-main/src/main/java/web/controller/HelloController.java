package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "count", required = false) String count,
                        @RequestParam(value = "repeated", required = false)String repeated, Model model) {
        model.addAttribute("count", count);
        if(count == null){
            repeated = "Hello world!";
        } else {
            int n = Integer.parseInt(count);
            repeated = new String(new char[n]).replace("\0", "Hello world!");}
         model.addAttribute("repeated",repeated);
        return "/pages/hello";
    }

}
