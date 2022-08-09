package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.dto.AddressDto;
import vn.techmaster.bookonline.exception.BadRequestException;
import vn.techmaster.bookonline.exception.NotFoundException;
import vn.techmaster.bookonline.entitiy.Address;
import vn.techmaster.bookonline.entitiy.User;
import vn.techmaster.bookonline.mapper.AddressMapper;
import vn.techmaster.bookonline.repository.AddressRepository;
import vn.techmaster.bookonline.repository.UserRepository;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressMapper addressMapper;

    // Find by id
    public Address findById(String id) {
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException("No address with id = " + id));
    }

    // Find all
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    // Find all DTO
    public List<AddressDto> findAllDto() {
        return addressRepository.findAll().stream().map(entity -> addressMapper.entityToDto(entity)).toList();
    }

    // Add entity
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    // Add instance by request
    public Address add(AddressDto addressDto) {
        User user = userRepository.findById(addressDto.getUserId())
                .orElseThrow(() -> new BadRequestException("No user with id = " + addressDto.getUserId()));
        Address address = addressMapper.dtoToEntity(addressDto);
        return addressRepository.save(address);
    }

    // Update instance
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    // Update instance by request
    public Address update(AddressDto addressDto) {
        User user = userRepository.findById(addressDto.getUserId())
                .orElseThrow(() -> new BadRequestException("No user with id = " + addressDto.getUserId()));
        Address address = addressMapper.dtoToEntity(addressDto);
        return addressRepository.save(address);
    }

    // Delete by id
    public void deleteById(String id) {
        addressRepository.deleteById(id);
    }
}
