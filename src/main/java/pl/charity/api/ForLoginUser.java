package pl.charity.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.charity.core.donation.DonationServiceImplement;
import pl.charity.core.institution.InstitutionServiceImplement;
import pl.charity.core.user.UserServiceImplement;

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
                            String username){
        model.addAttribute("donations",donationService.findAllByUserId(userService.findByEmail(username).getId()));
        model.addAttribute("donationsQuantity",donationService.countDonation());
        model.addAttribute("givenDonationsQuantity",donationService.countGivenDonation());
        return "dashboard";
    }
}
