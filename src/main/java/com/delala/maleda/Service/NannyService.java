package com.delala.maleda.Service;

import com.delala.maleda.DTO.HouseRentDTO;
import com.delala.maleda.DTO.NannyDTO;
import com.delala.maleda.Model.Address;
import com.delala.maleda.Model.Contact;
import com.delala.maleda.Model.HouseRent;
import com.delala.maleda.Model.Nanny;
import com.delala.maleda.Repository.AddressRepository;
import com.delala.maleda.Repository.ContactRepository;
import com.delala.maleda.Repository.HouseRentRepository;
import com.delala.maleda.Repository.NannyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NannyService {
    @Autowired
    private NannyRepository nannyRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;



    public List<NannyDTO> getAllNannies() {
        List<Nanny> lstNanny = nannyRepository.findAll();
        NannyDTO nannyDTO = new NannyDTO();
        List<NannyDTO> lstNannyDTO = new ArrayList<>();

        for(Nanny nanny:lstNanny){
            nannyDTO.setFirstName(nanny.getFirstName());
            nannyDTO.setLastName(nanny.getLastName());
            nannyDTO.setExpInYrs(nanny.getExpInYrs());
            nannyDTO.setAvailableDate(nanny.getAvailableDate());
            nannyDTO.setExpectedSalary(nanny.getExpectedSalary());
            nannyDTO.setPreferredLanguage(nanny.getPreferredLanguage());
            nannyDTO.setPreferredSchedule(nanny.getPreferredSchedule());
            nannyDTO.setPreferredCity(nanny.getPreferredCity());
            nannyDTO.setPreferredState(nanny.getPreferredState());
            nannyDTO.setCreatedDate(nanny.getCreatedDate());
            nannyDTO.setPrimaryPhone(nanny.getContact().getPrimaryPhone());
            nannyDTO.setSecondaryPhone(nanny.getContact().getSecondaryPhone());
            nannyDTO.setEmail(nanny.getContact().getEmail());

            lstNannyDTO.add(nannyDTO);

        }
        return lstNannyDTO;
    }

    public NannyDTO getNannyById(Integer id) {
        NannyDTO nannyDTO = new NannyDTO();
        Optional<Nanny> nanny = nannyRepository.findById(id);

        nannyDTO.setFirstName(nanny.get().getFirstName());
        nannyDTO.setLastName(nanny.get().getLastName());
        nannyDTO.setExpInYrs(nanny.get().getExpInYrs());
        nannyDTO.setAvailableDate(nanny.get().getAvailableDate());
        nannyDTO.setExpectedSalary(nanny.get().getExpectedSalary());
        nannyDTO.setPreferredLanguage(nanny.get().getPreferredLanguage());
        nannyDTO.setPreferredSchedule(nanny.get().getPreferredSchedule());
        nannyDTO.setPreferredCity(nanny.get().getPreferredCity());
        nannyDTO.setPreferredState(nanny.get().getPreferredState());
        nannyDTO.setCreatedDate(nanny.get().getCreatedDate());

        return nannyDTO;
    }

    public String saveNanny(NannyDTO nannyDTO) {

        buildNanny(nannyDTO,buildContact(nannyDTO));
        return "Nanny created";
    }


    public void buildNanny(NannyDTO nannyDTO, Contact contact){
        Nanny nanny = new Nanny();

        nanny.setFirstName(nannyDTO.getFirstName());
        nanny.setLastName(nannyDTO.getLastName());
        nanny.setExpInYrs(nannyDTO.getExpInYrs());
        nanny.setAvailableDate(nannyDTO.getAvailableDate());
        nanny.setExpectedSalary(nannyDTO.getExpectedSalary());
        nanny.setPreferredLanguage(nannyDTO.getPreferredLanguage());
        nanny.setPreferredSchedule(nannyDTO.getPreferredSchedule());
        nanny.setPreferredCity(nannyDTO.getPreferredCity());
        nanny.setPreferredState(nannyDTO.getPreferredState());
        nanny.setCreatedDate(nannyDTO.getCreatedDate());
        nanny.setContact(contact);
        nannyRepository.save(nanny);

    }

    public Contact buildContact(NannyDTO nannyDTO) {
        Contact contact = new Contact();

        contact.setPrimaryPhone(nannyDTO.getPrimaryPhone());
        contact.setSecondaryPhone(nannyDTO.getSecondaryPhone());
        contact.setEmail(nannyDTO.getEmail());
        contactRepository.save(contact);

        return contact;
    }


    public String updateNanny(NannyDTO nannyDTO) {
        Optional<Nanny> nanny = nannyRepository.findById(nannyDTO.getId());

        nanny.get().setFirstName(nannyDTO.getFirstName());

        nanny.get().setLastName(nannyDTO.getLastName());
        nanny.get().setExpInYrs(nannyDTO.getExpInYrs());
        nanny.get().setAvailableDate(nannyDTO.getAvailableDate());
        nanny.get().setExpectedSalary(nannyDTO.getExpectedSalary());
        nanny.get().setPreferredLanguage(nannyDTO.getPreferredLanguage());
        nanny.get().setPreferredSchedule(nannyDTO.getPreferredSchedule());
        nanny.get().setPreferredCity(nannyDTO.getPreferredCity());
        nanny.get().setPreferredState(nannyDTO.getPreferredState());
        nanny.get().setCreatedDate(nannyDTO.getCreatedDate());
        nannyRepository.save(nanny.get());

        nanny.get().getContact().setPrimaryPhone(nannyDTO.getPrimaryPhone());
        nanny.get().getContact().setSecondaryPhone(nannyDTO.getSecondaryPhone());
        nanny.get().getContact().setEmail(nannyDTO.getEmail());
        contactRepository.save(nanny.get().getContact());

        return "nanny updated";
    }

    public String deleteNanny(Integer id) {
        Optional<Nanny> nanny = nannyRepository.findById(id);

        nannyRepository.delete(nanny.get());
        contactRepository.delete(nanny.get().getContact());
        return "nanny deleted.";

    }
}
