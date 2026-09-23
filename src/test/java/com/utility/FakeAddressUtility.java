package com.utility;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {
	
	public static void main(String[] args) {
		getFakeAddress();
	}
	
	public static AddressPOJO getFakeAddress() {
		Faker faker = new Faker(Locale.US); //faker creates US based address
		
		AddressPOJO addressPOJO = 
				
				new AddressPOJO(faker.company().name(),faker.address().buildingNumber(),
						faker.address().streetAddress(),faker.address().city(),faker.numerify("#####"),
						faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(),"other","office address",
						"5");
		
		return addressPOJO;
	}

}
