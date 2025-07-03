package com.example.labour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.labour.model.Labour;
import com.example.labour.repository.LabourRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/labour") // ✅ This is important to match frontend URLs
public class LabourController {

    @Autowired
    private LabourRepository labourRepository;

    // ✅ CREATE (POST)
    @PostMapping("/addlabour")
    public String addLabour(@RequestBody Labour lb) {
        labourRepository.save(lb);
        return "Labour added successfully";
    }

    // ✅ READ ALL (GET)
    @GetMapping("/getlab")
    public List<Labour> getAllLabour() {
        System.out.println("Fetching all labours...");
        return labourRepository.findAll();
    }

    // ✅ READ BY ID (GET)
    @GetMapping("/findlab/{id}")
    public Labour getById(@PathVariable Long id) {
        return labourRepository.findById(id).orElse(null);
    }

    // ✅ DELETE BY ID
    @DeleteMapping("/dellab/{id}")
    public String deleteById(@PathVariable Long id) {
        labourRepository.deleteById(id);
        return "Labour deleted successfully";
    }

    // ✅ UPDATE
    @PutMapping("/update/{id}")
    public String updateLabour(@RequestBody Labour labour, @PathVariable Long id) {
        Labour lb = labourRepository.findById(id).orElse(null);
        if (lb != null) {
            lb.setName(labour.getName());
            lb.setAddress(labour.getAddress());
            lb.setSalary(labour.getSalary());
            labourRepository.save(lb);
            return "Updated successfully";
        } else {
            return "Labour not found";
        }
    }

    // ✅ DELETE ALL
    @DeleteMapping("/delall")
    public String deleteAll() {
        labourRepository.deleteAll();
        return "All labours deleted";
    }
}
