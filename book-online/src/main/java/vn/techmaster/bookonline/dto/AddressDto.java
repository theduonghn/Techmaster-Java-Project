package vn.techmaster.bookonline.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDto implements Serializable {
    private String id;
    private String address;
    private String userId;
}
