package com.weblaptop.backend.controllers.admin;

import com.weblaptop.backend.models.DTO.ManufacturerDTO;
import com.weblaptop.backend.security.jwt.JwtUtils;
import com.weblaptop.backend.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
@RestController
@CrossOrigin(origins = "https://laptopre.herokuapp.com")
@RequestMapping("/admin/manufacturer")
public class ManufacturerManagementController {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private ManufacturerService service;
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll(@RequestHeader("Authorization") String token) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return  service.getAll();
    }
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@RequestHeader("Authorization") String token,@Validated @RequestBody ManufacturerDTO dto) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
//        return service.create(dto,imageDTOdto);,@Validated @RequestBody ImageDTO imageDTOdto
        return service.create(dto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@RequestHeader("Authorization") String token,@PathVariable(value = "id") long id) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@RequestHeader("Authorization") String token,@PathVariable(value = "id") long id) {
        if (!jwtUtils.isAdmin(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return    service.delete(id);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Map<String, Object>> update(@RequestBody ProductTypeDTO productTypeDTO)  {
//        return service.update(productTypeDTO);
//    }
}
