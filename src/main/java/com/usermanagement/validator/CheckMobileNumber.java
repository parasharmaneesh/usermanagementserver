package com.usermanagement.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.usermanagement.annotation.MobileNumber;

public class CheckMobileNumber implements ConstraintValidator<MobileNumber,String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null ) {
            return true;
        }
		
//		if(value.substring(0, 3).equals("+91")) {
//			return value.substring(3).matches("\\d{10}");
//			//return true;
//		}
//		else {
//			return false;
//		}
		
		return value.matches("\\d{10}");
	}

}
