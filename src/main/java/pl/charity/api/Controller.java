package pl.charity.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.charity.core.institution.InstitutionServiceImplement;
import pl.charity.core.user.UserDto;

@org.springframework.stereotype.Controller
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class Controller {

    private final InstitutionServiceImplement institutionService;
    @GetMapping
    public String index(Model model){

        return "index";
    }

    @GetMapping("/institution")
    public String getInstitution(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        return "institution";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }





    @GetMapping("/createAllForAdmin")
    public String createAllForAdmin(){


        return "redirect:/";
    }
}
