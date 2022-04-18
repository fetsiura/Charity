package pl.charity.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.charity.core.category.CategoryServiceImplement;
import pl.charity.core.donation.Donation;
import pl.charity.core.donation.DonationServiceImplement;
import pl.charity.core.institution.InstitutionServiceImplement;
import pl.charity.core.user.UserServiceImplement;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Locale;

@org.springframework.stereotype.Controller
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class Controller {

    private final InstitutionServiceImplement institutionService;
    private final DonationServiceImplement donationService;
    private final CategoryServiceImplement categoryService;
    private final UserServiceImplement userService;
    @GetMapping
    public String index(Model model,
                        @CurrentSecurityContext(expression="authentication?.name")
                        String username){

        if(!username.equals("anonymousUser")){
            return "redirect:/dashboard";
        }

        model.addAttribute("donationsQuantity",donationService.countDonation());
        model.addAttribute("givenDonationsQuantity",donationService.countGivenDonation());
        return "index";
    }

    @GetMapping("/institution")
    public String getInstitution(Model model,
                                 @CurrentSecurityContext(expression="authentication?.name")
                                 String username,
                                 HttpSession session){
        model.addAttribute("institutions", institutionService.findAll());
        if(!username.equals("anonymousUser")){
            setSessionUserName(session,username);
            return "user/institution";
        }
        return "institution";
    }

    @GetMapping("/contact")
    public String contact(@CurrentSecurityContext(expression="authentication?.name")
                              String username,
                          HttpSession session){

        if(!username.equals("anonymousUser")){
            setSessionUserName(session,username);
            return "user/contact";
        }

        return "contact";
    }



    @GetMapping("/add-donation")
    public String getGiftAddForm(Model model,
                                 @CurrentSecurityContext(expression="authentication?.name")
                                 String username,
                                 HttpSession session){
        model.addAttribute("user",userService.findByEmail(username));
        model.addAttribute("institutions",institutionService.findAll());
        model.addAttribute("donation",new Donation());
        model.addAttribute("categories",categoryService.allCategories());
        if(!username.equals("anonymousUser")){
            setSessionUserName(session,username);
            return "user/addDonation";
        }
        return "addDonation";
    }

    @PostMapping("/add-donation")
    public String postDonation(Donation donation,
                               @CurrentSecurityContext(expression="authentication?.name")
                                   String username){

        donationService.add(donation);
        if(!username.equals("anonymousUser")){
            return "redirect:/donation";
        }
        return "redirect:/";
    }


    public void setSessionUserName(HttpSession session,
                                   String username){
        if(session.getAttribute("loginSession")==null){
            session.setAttribute("loginSession",userService.findForLogin(username).get().getLogin().toUpperCase(Locale.ROOT));
        }
    }
}
