package pl.charity.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.charity.core.donation.DonationServiceImplement;
import pl.charity.core.institution.InstitutionServiceImplement;

@org.springframework.stereotype.Controller
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class Controller {

    private final InstitutionServiceImplement institutionService;
    private final DonationServiceImplement donationService;
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
                                 String username){
        model.addAttribute("institutions", institutionService.findAll());
        if(!username.equals("anonymousUser")){
            return "user/institution";
        }
        return "institution";
    }

    @GetMapping("/contact")
    public String contact(@CurrentSecurityContext(expression="authentication?.name")
                              String username){

        if(!username.equals("anonymousUser")){
            return "user/contact";
        }return "contact";
    }



    @GetMapping("/gift-add")
    public String getGiftAddForm(){

        return "addGift";
    }
}
