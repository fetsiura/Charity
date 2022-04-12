package pl.charity.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public String index(Model model){
        model.addAttribute("donationsQuantity",donationService.countDonation());
        model.addAttribute("givenDonationsQuantity",donationService.countGivenDonation());
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


}
