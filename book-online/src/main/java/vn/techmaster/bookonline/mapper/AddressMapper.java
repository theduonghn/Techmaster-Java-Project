package vn.techmaster.bookonline.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.techmaster.bookonline.dto.AddressDto;
import vn.techmaster.bookonline.entitiy.Address;

import java.util.Objects;

@Component
public class AddressMapper {
    @Autowired
    private ModelMapper modelMapper;

    public AddressDto entityToDto(Address address) {
        return Objects.isNull(address) ? null : modelMapper.map(address, AddressDto.class);
    }

    public Address dtoToEntity(AddressDto addressDto) {
        return Objects.isNull(addressDto) ? null : modelMapper.map(addressDto, Address.class);
    }
}
