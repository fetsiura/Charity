package pl.charity.core.donation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class DonationServiceImplement implements DonationService{

    private final DonationRepository donationRepository;

    @Override
    public Integer countDonation() {
        return donationRepository.countAllDonations();
    }

    @Override
    public Integer countGivenDonation() {
        return donationRepository.countGivenDonations();
    }

    @Override
    public void add(Donation donation) {
        donationRepository.save(donation);
        log.info("Saved donation {}",donation);
    }

    @Override
    public void changeStatus(Long id) {

    }

    @Override
    public void delete(Long id) {
        donationRepository.deleteById(id);
        log.info("Donation by id {} deleted",id);
    }

    @Override
    public Optional<Donation> findById(Long id) {
        return donationRepository.findById(id);
    }

    @Override
    public List<Donation> findAllByUserId(Long id) {
        return donationRepository.findAllByUserId(id);
    }
}
