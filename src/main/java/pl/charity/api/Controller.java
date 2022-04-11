package pl.charity.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
@Slf4j
public class Controller {


    @GetMapping
    public String index(Model model){

        return "index";
    }

}
