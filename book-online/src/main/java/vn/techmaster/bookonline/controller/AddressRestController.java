package vn.techmaster.bookonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.bookonline.dto.AddressDto;
import vn.techmaster.bookonline.entitiy.Address;
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
    public List<AddressDto> findAll() {
        return addressService.findAllDto();
    }

    // Add instance
    @PostMapping
    public Address add(@RequestBody AddressDto addressDto) {
        return addressService.add(addressDto);
    }

    // Update instance
    @PutMapping("/{id}")
    public Address update(@RequestBody AddressDto addressDto, @PathVariable("id") String id) {
        return addressService.update(addressDto);
    }

    // Delete by id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") String id) {
        addressService.deleteById(id);
    }
}
