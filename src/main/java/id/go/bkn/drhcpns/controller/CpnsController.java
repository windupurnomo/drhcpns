package id.go.bkn.drhcpns.controller;

import id.go.bkn.drhcpns.entity.Cpns;
import id.go.bkn.drhcpns.service.CpnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cpns")
public class CpnsController {
    // apitester.com
    @Autowired
    private CpnsService cpnsService;

    @PostMapping
    public Cpns create(@RequestBody Cpns cpns){
        Cpns result = cpnsService.create(cpns);
        return result;
    }

    @PutMapping
    public Cpns update(@RequestBody Cpns cpns){
        Cpns result = cpnsService.update(cpns);
        return result;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        cpnsService.delete(id);
    }

    @GetMapping
    public List<Cpns> findAll(){
        return cpnsService.findAll();
    }

    @GetMapping("/laki")
    public List<Cpns> findMen(){
        return cpnsService.findBySex(1);
    }

    @GetMapping("/perempuan")
    public List<Cpns> findWomen(){
        return cpnsService.findBySex(2);
    }

    @GetMapping("/nik/{keyword}")
    public List<Cpns> findByNik(@PathVariable("keyword") String term){
        return cpnsService.getNik(term);
    }
}
