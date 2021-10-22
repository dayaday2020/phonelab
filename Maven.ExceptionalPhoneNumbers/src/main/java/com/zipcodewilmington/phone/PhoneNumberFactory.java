package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {

        PhoneNumber[] arrayOfPhoneNumbers = new PhoneNumber[phoneNumberCount];
        for (int x =0; x < phoneNumberCount; x++){
            arrayOfPhoneNumbers[x] = createRandomPhoneNumber();
        }
    return arrayOfPhoneNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    //"Hey computer since this is returning a string and we need numbers for the format
    // we gotta create a method to convert ints to strings
    //now that we made it we return te string values" Okay!
    public static PhoneNumber createRandomPhoneNumber()
    {
        int areaCode = RandomNumberFactory.createInteger(100,999);
        int centralOfficeCode  = RandomNumberFactory.createInteger(100,999);
        int phoneLineCode  = RandomNumberFactory.createInteger(1000,9999);

        return createPhoneNumberSafely(areaCode,centralOfficeCode, phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    //"Hey computer heres the format I want you to use to create a number safely,
    // inside is the InvalidPhoneNumberFormatException we used to catch anyone using improper formatting and return null
    //if its the right format it returns a phone number" Okay!
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String number = "(" + areaCode +")" + "-" + centralOfficeCode + "-" + phoneLineCode;
        PhoneNumber phoneNumber;
        try{
            phoneNumber = new PhoneNumber(number);
        } catch(InvalidPhoneNumberFormatException e){
            return null;
        }
        return phoneNumber;
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    //use keyword throws  to instatitiate InvalidPhoneNumberFormatException
    //"Hey computer heres what you use to deny anyone whos not using the correct format" Okay!
    public static PhoneNumber createPhoneNumber(String phoneNumberString)
            throws InvalidPhoneNumberFormatException
    {
        return new PhoneNumber(phoneNumberString);
    }
}
//All test run; a blockage I faced was getting the random numbers to run but i had not used the new names in the return.
// After using the correct names my program rn and now im starting the animal factory labs.