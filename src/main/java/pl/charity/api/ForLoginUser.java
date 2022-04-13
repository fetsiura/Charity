package pl.charity.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.charity.core.donation.DonationServiceImplement;
import pl.charity.core.institution.InstitutionServiceImplement;
import pl.charity.core.user.UserServiceImplement;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Secured("ROLE_USER")
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping()
public class ForLoginUser {

    private final InstitutionServiceImplement institutionService;
    private final DonationServiceImplement donationService;
    private final UserServiceImplement userService;


    @GetMapping("/dashboard")
    public String dashboard(Model model,
                            @CurrentSecurityContext(expression="authentication?.name")
                            String username,
                            HttpSession session){
        if(session.getAttribute("loginSession")==null){
            session.setAttribute("loginSession",userService.findForLogin(username).get().getLogin().toUpperCase(Locale.ROOT));
        }
        model.addAttribute("donations",donationService.findAllByUserId(userService.findByEmail(username).getId()));
        model.addAttribute("donationsQuantity",donationService.countDonation());
        model.addAttribute("givenDonationsQuantity",donationService.countGivenDonation());
        return "user/dashboard";
    }

    @GetMapping("/gift")
    public String gift(Model model,
                            @CurrentSecurityContext(expression="authentication?.name")
                            String username){

        model.addAttribute("donations",donationService.findAllByUserId(userService.findByEmail(username).getId()));
        model.addAttribute("donationsQuantity",donationService.countDonation());
        model.addAttribute("givenDonationsQuantity",donationService.countGivenDonation());
        return "user/gift";
    }




    @PostMapping("/gift/edit")
    public String editGiftForm(@RequestParam Long id,
                               Model model){
        model.addAttribute("donationsQuantity",donationService.countDonation());
        model.addAttribute("givenDonationsQuantity",donationService.countGivenDonation());
        model.addAttribute("donation",donationService.findById(id));
        return "user/editGift";
    }
    @PostMapping("/gift/delete")
    public String deleteGift(@RequestParam Long id){

        donationService.delete(id);
        return "redirect:/gift";
    }




}
