package id.go.bkn.drhcpns.service;

import id.go.bkn.drhcpns.entity.Cpns;
import id.go.bkn.drhcpns.repository.CpnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CpnsService {

    @Autowired
    private CpnsRepository cpnsRepository;

    public Cpns create(Cpns cpns){
        cpns.setId(UUID.randomUUID().toString());
        Cpns saved = cpnsRepository.save(cpns);
        return saved;
    }

    public Cpns update(Cpns cpns){
        // get data cpns where id adalah cpns.id
        // jika cpns ditemukan maka ubah nilai nya (address, nama, nik, jenis kelamin)
        // simpan lagi ke database
        Cpns saved = cpnsRepository.findById(cpns.getId()).orElse(null);
        if (saved == null) throw new RuntimeException("Data CPNS tidak ditemukan");
        saved.setName(cpns.getName());
        saved.setAddress(cpns.getAddress());
        saved.setBirthDate(cpns.getBirthDate());
        saved.setBirthPlace(cpns.getBirthPlace());
        saved.setMarriageStatus(cpns.getMarriageStatus());
        saved.setNik(cpns.getNik());
        saved.setPhone(cpns.getPhone());
        saved.setReligion(cpns.getReligion());
        saved.setSex(cpns.getSex());
        cpnsRepository.save(saved);
        return saved;
    }

    public void delete(String id){
        cpnsRepository.deleteById(id);
    }

    public List<Cpns> findAll(){
        List<Cpns> cpnsList = cpnsRepository.findAll();
        return cpnsList;
    }

    public List<Cpns> findBySex(int i){
        return cpnsRepository.findBySex(i);
    }

    public List<Cpns> getNik(String term){
        term = "%" + term + "%";
        return cpnsRepository.getNik(term);
    }


}
