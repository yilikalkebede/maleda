package com.delala.maleda.Controller;

import com.delala.maleda.DTO.NannyDTO;
import com.delala.maleda.Service.NannyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NannyController {

    @Autowired
    private NannyService nannyService;

    @GetMapping("/nanny")
    public ResponseEntity<List<NannyDTO>> getAllNannies() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(nannyService.getAllNannies());
    }

    @GetMapping("/nanny/{id}")
    public ResponseEntity<NannyDTO> getNannyById(@PathVariable Integer id) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(nannyService.getNannyById(id));
    }

    @PostMapping("/nanny")
    public ResponseEntity<String> saveNanny(@RequestBody NannyDTO nannyDTO) {

    if(nannyDTO.getId()!=null){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id is auto generated. Please remove the id and try again");
    }

    var nannyCreated = nannyService.saveNanny(nannyDTO);
        return ResponseEntity.status(HttpStatus.OK)
            .body(nannyCreated);

}
    @PutMapping("/nanny")
    public ResponseEntity<String> updateNanny(@RequestBody NannyDTO nannyDTO) {
        if(nannyDTO.getId()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id is required to update nanny. Please remove the id and try again");
        }

        var nannyUpdated = nannyService.updateNanny(nannyDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(nannyUpdated);
    }

    @DeleteMapping("/nanny/{id}")
    public ResponseEntity<String> deleteNanny(@PathVariable Integer id){
        if(id==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id is required to remove nanny");
        }
        var nannyDeleted = nannyService.deleteNanny(id);
        return ResponseEntity.status(HttpStatus.OK).body(nannyDeleted);
    }
}

