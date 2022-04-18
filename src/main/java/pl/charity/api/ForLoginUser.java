package pl.charity.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.charity.core.category.CategoryServiceImplement;
import pl.charity.core.donation.Donation;
import pl.charity.core.donation.DonationServiceImplement;
import pl.charity.core.institution.InstitutionServiceImplement;
import pl.charity.core.user.UserServiceImplement;

import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Optional;

@Secured("ROLE_USER")
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping()
public class ForLoginUser {

    private final InstitutionServiceImplement institutionService;
    private final DonationServiceImplement donationService;
    private final UserServiceImplement userService;
    private final CategoryServiceImplement categoryService;


    @GetMapping("/dashboard")
    public String dashboard(Model model,
                            @CurrentSecurityContext(expression="authentication?.name")
                            String username,
                            HttpSession session){
        setSessionUserName(session,username);
        model.addAttribute("donations",donationService.findAll());
        model.addAttribute("donationsQuantity",donationService.countDonation());
        model.addAttribute("givenDonationsQuantity",donationService.countGivenDonation());
        return "user/dashboard";
    }

    @GetMapping("/donation")
    public String gift(Model model,
                            @CurrentSecurityContext(expression="authentication?.name")
                            String username,
                       HttpSession session){
        setSessionUserName(session,username);

        model.addAttribute("donations",donationService.findAllByUserId(userService.findByEmail(username).getId()));
        model.addAttribute("donationsQuantity",donationService.countDonation());
        model.addAttribute("givenDonationsQuantity",donationService.countGivenDonation());
        return "user/donation";
    }




    @PostMapping("/donation/edit")
    public String editGiftForm(@RequestParam Long id,
                               Model model,
                               @CurrentSecurityContext(expression="authentication?.name")
                                   String username){
        System.out.println(userService.findByEmail(username));
        model.addAttribute("institutions",institutionService.findAll());
        model.addAttribute("categories",categoryService.allCategories());
        model.addAttribute("user",userService.findByEmail(username));
        model.addAttribute("donationsQuantity",donationService.countDonation());
        model.addAttribute("givenDonationsQuantity",donationService.countGivenDonation());
        model.addAttribute("donation",donationService.findById(id));
        return "user/editDonation";
    }

    @PostMapping("/donation/update")
    public String donationUpdate(@ModelAttribute Donation donation){

        log.error(donation.toString());

        donationService.update(donation);
        return "redirect:/donation";
    }
    @PostMapping("/donation/delete")
    public String deleteGift(@RequestParam Long id){

        donationService.delete(id);
        return "redirect:/donation";
    }
    @PostMapping("/donation/changeStatus")
    public String changeStatus(@RequestParam Long id){

        Optional<Donation> byId = donationService.findById(id);

        byId.get().setDelivered(true);
        donationService.update(byId.get());

        return "redirect:/donation";
    }




    public void setSessionUserName(HttpSession session,
                                   String username){
        if(session.getAttribute("loginSession")==null){
            session.setAttribute("loginSession",userService.findForLogin(username).get().getLogin().toUpperCase(Locale.ROOT));
        }
    }


}
