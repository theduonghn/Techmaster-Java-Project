package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.exception.NotFoundException;
import vn.techmaster.bookonline.model.Address;
import vn.techmaster.bookonline.repository.AddressRepository;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    // Find by id
    public Address findById(String id) {
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException("No address with id = " + id));
    }

    // Find all
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    // Add instance
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    // Update instance
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    // Delete by id
    public void delete(String id) {
        addressRepository.deleteById(id);
    }
}
