package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.services.validation.UserUpdateValid;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@UserUpdateValid
public class UserUpdateDto extends UserDto implements Serializable {
    private static final long serialVersionUID = 1L;
}
