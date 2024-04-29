package com.example.labotp1.controllers;


import com.example.labotp1.entity.Empresa;
import com.example.labotp1.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping("")
    public ResponseEntity<?> getall(){
       try {
           return ResponseEntity.status(HttpStatus.OK).body(empresaService.findAll());
       }catch(Exception e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente nuevemente.\"}");
       }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.findById(id));
        }catch(Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente nuevemente.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Empresa empresa){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.save(empresa));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevemente.\"}");
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Empresa empresa){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(empresaService.update(id,empresa));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevemente.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(empresaService.delete(id));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevemente.\"}");
        }
    }



}
