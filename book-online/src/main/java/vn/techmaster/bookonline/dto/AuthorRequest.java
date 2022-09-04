package vn.techmaster.bookonline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.techmaster.bookonline.entity.Gender;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest implements Serializable {
    private String id;

    @NotBlank(message = "Full name must not be empty")
    private String fullName;

    private Gender gender;

    private String address;

    private Integer yearOfBirth;

    private Integer yearOfDeath;
}
