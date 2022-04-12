package pl.charity.core.donation;


import java.util.List;

public interface DonationService {

    Integer countDonation();
    Integer countGivenDonation();
    void add(Donation donation);
    void changeStatus(Long id);

    List<Donation> findAllByUserId(Long id);

}
