package pl.charity.core.donation;


import java.util.List;
import java.util.Optional;

public interface DonationService {

    List<Donation> findAll();
    Integer countDonation();
    Integer countGivenDonation();
    void add(Donation donation);
    void changeStatus(Long id);
    void update(Donation donation);
    void delete(Long id);

    Optional<Donation> findById(Long id);

    List<Donation> findAllByUserId(Long id);

}
