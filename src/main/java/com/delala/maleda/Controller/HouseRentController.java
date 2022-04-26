package com.delala.maleda.Controller;

import com.delala.maleda.DTO.HouseRentDTO;
import com.delala.maleda.Service.HouseRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HouseRentController {
    @Autowired
    private HouseRentService houseRentService;

    @GetMapping("/house-rent")
    public ResponseEntity<List<HouseRentDTO>> getAllRentHouses(){
         return ResponseEntity.status(HttpStatus.OK)
                .body(houseRentService.getAllHouseRents());
    }

    @GetMapping("/house-rent/{id}")
    public ResponseEntity<HouseRentDTO> getRentHouseById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(houseRentService.getHouseRentById(id));
    }

    @PostMapping("/house-rent")
    public void saveHouseRent(@RequestBody HouseRentDTO houseRentDTO){
        houseRentService.saveHouseRent(houseRentDTO);
    }

    @PutMapping("/house-rent")
    public void updateHouseRent(@RequestBody HouseRentDTO houseRentDTO) {

        houseRentService.updateHouseRent(houseRentDTO);
    }

    @DeleteMapping("/house-rent/{id}")
    public void deleteHouseRent(@PathVariable Integer id){
        houseRentService.deleteHouseRent(id);
    }
}

