package com.api.work.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DynamicValidtor implements ConstraintValidator<DynamicField, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
     return value !=null && value.matches("^[a-zA-Z]*$");
        }
    }

//        for(char c : value.toCharArray()){
//            if(Character.isDigit(c)){
//                return false;
//            }
//        }
//        //value = basiot123
//        // Regular expression to check for digits
////        String regex = ".*\\d.*";
////        boolean isValid = value.matches(regex);
////        if (!isValid) {
////            context.disableDefaultConstraintViolation();
////            context.buildConstraintViolationWithTemplate("The field must not contain any numeric characters.")
////                    .addConstraintViolation();
////        }
////
////        return isValid;
//        return true;
//    }
//}
