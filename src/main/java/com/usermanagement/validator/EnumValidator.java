package com.usermanagement.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.usermanagement.annotation.EnumValue;

public class EnumValidator implements ConstraintValidator<EnumValue, String>{

	private Class<? extends Enum> enumClass;
	
	@Override
	public void initialize(EnumValue constraintAnnotation) {
		this.enumClass = constraintAnnotation.enumClass();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null ) {
            return true;
        }
		
        Object[] enumValues = enumClass.getEnumConstants();
        for(Object enumValue:enumValues)
        {
            if(value.equals(enumValue.toString()))
            {
                return true;
            }
        }
         
        return false;
	}
	

}
