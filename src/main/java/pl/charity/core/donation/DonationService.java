package pl.charity.core.donation;


import java.util.List;
import java.util.Optional;

public interface DonationService {

    Integer countDonation();
    Integer countGivenDonation();
    void add(Donation donation);
    void changeStatus(Long id);

    void delete(Long id);

    Optional<Donation> findById(Long id);

    List<Donation> findAllByUserId(Long id);

}
