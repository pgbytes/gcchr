package com.gcchr.system.dal.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcchr.system.dal.model.Address;
import com.gcchr.system.dal.model.AddressType;
import com.gcchr.system.dal.model.Contact;
import com.gcchr.system.dal.model.Email;
import com.gcchr.system.dal.model.EmailType;
import com.gcchr.system.dal.model.Patient;
import com.gcchr.system.dal.model.Phone;
import com.gcchr.system.dal.model.PhoneType;
import com.gcchr.system.dal.model.User;
import com.gcchr.system.dal.repository.UserRepository;

@Service
public class UserService
{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User findById(String id)
    {
        return this.userRepository.findOne(id);
    }

    public List<User> findAll()
    {
        return this.userRepository.findAll();
    }

    public void saveUser(User user)
    {
        this.userRepository.save(user);
    }

    public void saveSamplePatient()
    {
        String gcchr_id = "patient0";
        String firstName = "Test";
        String lastName = "Patient";
        Date dob = new Date();
        Patient patient = new Patient(gcchr_id, firstName, null, lastName, dob);
        String street = "Street 175";
        String city = "Lucknow";
        int zipcode = 123456;

        Address address = new Address(AddressType.HOME, street, zipcode, city);
        address.setCountry("India");
        Phone phone = new Phone(PhoneType.MOBILE, "07630527818");
        Email email = new Email(EmailType.PERSONAL, "testpatient@domain.com");
        Contact contact = new Contact();
        contact.setAddresses(Arrays.asList(address));
        contact.setPhones(Arrays.asList(phone));
        contact.setEmails(Arrays.asList(email));
        patient.setContact(contact);
        saveUser(patient);
    }
}
