package pl.charity.core.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {


    @Query(nativeQuery = true,
            value = "SELECT COUNT(*) FROM DONATION")
    Integer countAllDonations();

    @Query(nativeQuery = true,
            value = "SELECT COUNT(*) FROM DONATION where delivered=true ")
    Integer countGivenDonations();

    List<Donation> findAllByUserId(Long id);

    List<Donation> findAll();
}
