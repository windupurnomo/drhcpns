package id.go.bkn.drhcpns.service;

import id.go.bkn.drhcpns.entity.Education;
import id.go.bkn.drhcpns.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public Education create(Education education) {
        education.setId(UUID.randomUUID().toString());
        Education saved = educationRepository.save(education);
        return saved;
    }

    public Education update(Education education) {
        // get data education where id adalah education.id
        // jika education ditemukan maka ubah nilai nya (address, nama, nik, jenis kelamin)
        // simpan lagi ke database
        Education saved = educationRepository.findById(education.getId()).orElse(null);
        if (saved == null) throw new RuntimeException("Data CPNS tidak ditemukan");
        saved.setName(education.getName());
        saved.setLevel(education.getLevel());
        saved.setName(education.getName());
        saved.setYear(education.getYear());
        educationRepository.save(saved);
        return saved;
    }

    public void delete(String id) {
        educationRepository.deleteById(id);
    }

    public List<Education> findAll() {
        List<Education> educationList = educationRepository.findAll();
        return educationList;
    }

}
