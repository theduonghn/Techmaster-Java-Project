package vn.techmaster.bookonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.bookonline.model.Address;
import vn.techmaster.bookonline.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressRestController {
    @Autowired
    private AddressService addressService;

    // Find by id
    @GetMapping("/{id}")
    public Address findById(@PathVariable("id") String id) {
        return addressService.findById(id);
    }

    // Find all
    @GetMapping()
    public List<Address> findAll() {
        return addressService.findAll();
    }

    // Add instance

    // Update instance

    // Delete by id
}
