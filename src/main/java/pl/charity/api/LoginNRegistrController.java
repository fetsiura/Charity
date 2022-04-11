package pl.charity.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.charity.core.user.UserDto;
import pl.charity.core.user.UserServiceImplement;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class LoginNRegistrController {

    private final UserServiceImplement userService;


    @GetMapping("/registration")
    public String getRegistration(Model model){
        model.addAttribute("userDto",new UserDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String postRegistration(Model model,@ModelAttribute("userDto") @Valid UserDto userDto,
                                   BindingResult result){

        if(result.hasErrors()){
            return "registration";
        }
        if(!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            model.addAttribute("errorConf", "Password not confirm");
            return "registration"; }

        userService.saveUser(userDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(@CurrentSecurityContext(expression="authentication?.name")
                                String username){

        if(!username.equals("anonymousUser")){
            return "redirect:/dashboard";
        }
        return "login";
    }
}
