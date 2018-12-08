package id.go.bkn.drhcpns.controller;

import id.go.bkn.drhcpns.entity.Education;
import id.go.bkn.drhcpns.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    // apitester.com
    @Autowired
    private EducationService educationService;

    @PostMapping
    public Education create(@RequestBody Education education){
        Education result = educationService.create(education);
        return result;
    }

    @PutMapping
    public Education update(@RequestBody Education education){
        Education result = educationService.update(education);
        return result;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        educationService.delete(id);
    }

    @GetMapping
    public List<Education> findAll(){
        return educationService.findAll();
    }

}
