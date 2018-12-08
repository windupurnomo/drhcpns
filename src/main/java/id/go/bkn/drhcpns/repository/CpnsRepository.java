package id.go.bkn.drhcpns.repository;

import id.go.bkn.drhcpns.entity.Cpns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CpnsRepository extends JpaRepository<Cpns, String> {
    List<Cpns> findBySex(int i);
    List<Cpns> findByNameAndReligion(String name, int religion);
    List<Cpns> findByReligionAndAddress(int religion, String address);

    @Query(value = "select * from cpns where nik like ?1", nativeQuery = true)
    List<Cpns> getNik(String term);
}
