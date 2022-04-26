package com.delala.maleda.Service;

import com.delala.maleda.DTO.HouseRentDTO;
import com.delala.maleda.Model.Address;
import com.delala.maleda.Model.Contact;
import com.delala.maleda.Model.HouseRent;
import com.delala.maleda.Repository.AddressRepository;
import com.delala.maleda.Repository.ContactRepository;
import com.delala.maleda.Repository.HouseRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HouseRentService {
    @Autowired
    private HouseRentRepository houseRentRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;



    public List<HouseRentDTO> getAllHouseRents() {
        List<HouseRent> lstHouseRent = houseRentRepository.findAll();
        HouseRentDTO houseRentDTO = new HouseRentDTO();
        List<HouseRentDTO> lstHouseRentDTO = new ArrayList<>();

        for(HouseRent houseRent:lstHouseRent){
            houseRentDTO.setFirstName(houseRent.getFirstName());
            houseRentDTO.setLastName(houseRent.getLastName());
            houseRentDTO.setBathroomType(houseRent.getBathroomType());
            houseRentDTO.setBedroomType(houseRent.getBedroomType());
            houseRentDTO.setExitType(houseRent.getExitType());
            houseRentDTO.setKitchenType(houseRent.getKitchenType());
            houseRentDTO.setTenantType(houseRent.getTenantType());
            houseRentDTO.setStreetName(houseRent.getAddress().getStreetName());
            houseRentDTO.setCity(houseRent.getAddress().getCity());
            houseRentDTO.setState(houseRent.getAddress().getState());
            houseRentDTO.setCountry(houseRent.getAddress().getCountry());
            houseRentDTO.setCounty(houseRent.getAddress().getCounty());
            houseRentDTO.setZipCode(houseRent.getAddress().getZipCode());
            houseRentDTO.setPrimaryPhone(houseRent.getContact().getPrimaryPhone());
            houseRentDTO.setSecondaryPhone(houseRent.getContact().getSecondaryPhone());
            houseRentDTO.setEmail(houseRent.getContact().getEmail());

            lstHouseRentDTO.add(houseRentDTO);
        }
        return lstHouseRentDTO;
    }

    public HouseRentDTO getHouseRentById(Integer id) {
        HouseRentDTO houseRentDTO = new HouseRentDTO();
        Optional<HouseRent> houseRent= houseRentRepository.findById(id);

        houseRentDTO.setFirstName(houseRent.get().getFirstName());
        houseRentDTO.setLastName(houseRent.get().getLastName());
        houseRentDTO.setBathroomType(houseRent.get().getBathroomType());
        houseRentDTO.setBedroomType(houseRent.get().getBedroomType());
        houseRentDTO.setExitType(houseRent.get().getExitType());
        houseRentDTO.setKitchenType(houseRent.get().getKitchenType());
        houseRentDTO.setTenantType(houseRent.get().getTenantType());
        houseRentDTO.setStreetName(houseRent.get().getAddress().getStreetName());
        houseRentDTO.setCity(houseRent.get().getAddress().getCity());
        houseRentDTO.setState(houseRent.get().getAddress().getState());
        houseRentDTO.setCountry(houseRent.get().getAddress().getCountry());
        houseRentDTO.setZipCode(houseRent.get().getAddress().getZipCode());
        houseRentDTO.setCounty(houseRent.get().getAddress().getCounty());
        houseRentDTO.setPrimaryPhone(houseRent.get().getContact().getPrimaryPhone());
        houseRentDTO.setSecondaryPhone(houseRent.get().getContact().getSecondaryPhone());
        houseRentDTO.setEmail(houseRent.get().getContact().getEmail());
        return houseRentDTO;
    }

    public void saveHouseRent(HouseRentDTO houseRentDTO) {

        buildHouse(houseRentDTO,buildContact(houseRentDTO), buildAddress(houseRentDTO));
    }


   public void buildHouse(HouseRentDTO houseRentDTO, Contact contact, Address address){
        HouseRent houseRent = new HouseRent();

        houseRent.setFirstName(houseRentDTO.getFirstName());
        houseRent.setLastName(houseRentDTO.getLastName());
        houseRent.setBathroomType(houseRentDTO.getBathroomType());
        houseRent.setBedroomType(houseRentDTO.getBedroomType());
        houseRent.setExitType(houseRentDTO.getExitType());
        houseRent.setKitchenType(houseRentDTO.getKitchenType());
        houseRent.setTenantType(houseRentDTO.getTenantType());
        houseRent.setAddress(address);
        houseRent.setContact(contact);
        houseRentRepository.save(houseRent);

    }

    public Contact buildContact(HouseRentDTO houseRentDTO) {
        Contact contact = new Contact();

        contact.setPrimaryPhone(houseRentDTO.getPrimaryPhone());
        contact.setSecondaryPhone(houseRentDTO.getSecondaryPhone());
        contact.setEmail(houseRentDTO.getEmail());
        contactRepository.save(contact);

        return contact;
    }

    public Address buildAddress(HouseRentDTO houseRentDTO) {
        Address address = new Address();

        address.setCity(houseRentDTO.getCity());
        address.setState(houseRentDTO.getState());
        address.setCountry(houseRentDTO.getCountry());
        address.setCounty(houseRentDTO.getCounty());
        address.setZipCode(houseRentDTO.getZipCode());
        addressRepository.save(address);

        return address;
    }

    public void updateHouseRent(HouseRentDTO houseRentDTO) {
       Optional<HouseRent> houseRent = houseRentRepository.findById(houseRentDTO.getId());

        houseRent.get().setFirstName(houseRentDTO.getFirstName());
        houseRent.get().setLastName(houseRentDTO.getLastName());
        houseRent.get().setBedroomType(houseRentDTO.getBedroomType());
        houseRent.get().setBathroomType(houseRentDTO.getBathroomType());
        houseRent.get().setKitchenType(houseRentDTO.getKitchenType());
        houseRent.get().setTenantType(houseRentDTO.getTenantType());
        houseRent.get().setExitType(houseRentDTO.getExitType());
        houseRentRepository.save(houseRent.get());

        houseRent.get().getAddress().setStreetName(houseRentDTO.getStreetName());
        houseRent.get().getAddress().setCity(houseRentDTO.getCity());
        houseRent.get().getAddress().setState(houseRentDTO.getState());
        houseRent.get().getAddress().setCountry(houseRentDTO.getCountry());
        houseRent.get().getAddress().setZipCode(houseRentDTO.getZipCode());
        houseRent.get().getAddress().setCounty(houseRentDTO.getCounty());
        addressRepository.save(houseRent.get().getAddress());

        houseRent.get().getContact().setPrimaryPhone(houseRentDTO.getPrimaryPhone());
        houseRent.get().getContact().setSecondaryPhone(houseRentDTO.getSecondaryPhone());
        houseRent.get().getContact().setEmail(houseRentDTO.getEmail());
        contactRepository.save(houseRent.get().getContact());

    }

    public void deleteHouseRent(Integer id) {
        Optional<HouseRent> houseRent = houseRentRepository.findById(id);

        houseRentRepository.delete(houseRent.get());
        contactRepository.delete(houseRent.get().getContact());
        addressRepository.delete(houseRent.get().getAddress());

    }
}
