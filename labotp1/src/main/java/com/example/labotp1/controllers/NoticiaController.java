package com.example.labotp1.controllers;
import com.example.labotp1.entity.Noticia;
import com.example.labotp1.services.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/Noticias")
public class NoticiaController {

    @Autowired
    NoticiaService noticiaService;

    @GetMapping("")
    public ResponseEntity<?> getall(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(noticiaService.findAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente nuevemente.\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(noticiaService.findById(id)); //la clave foranea a la cual pertenece cada noticia en este caso  a la empresa que pertenece
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente nuevemente.\"}");
        }
    }

  //  @PostMapping("")
    //public ResponseEntity<?> save(@RequestBody Noticia noticia){
      //  try{
        //    return ResponseEntity.status(HttpStatus.OK).body(noticiaService.save(noticia));
        //}catch(Exception e) {
          //  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevemente.\"}");
        //}
    //}

    @PostMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Noticia noticia, @PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(noticiaService.update(id,noticia));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevemente.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(noticiaService.delete(id));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevemente.\"}");
        }
    }

    @PostMapping("/guardar/{id}")
    public ResponseEntity<?> guardarNoticia(@RequestBody Noticia noticia,@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(noticiaService.saveAempresa(noticia,id));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente nuevemente.\"}");
        }
    }

    @GetMapping("/buscar/{text}")
    public ResponseEntity<?> buscarNoticia(@PathVariable String text,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        try{
            Pageable pageable= PageRequest.of(page,size);
            return ResponseEntity.status(HttpStatus.OK).body(noticiaService.buscarNoticias(text,pageable)); //la clave foranea a la cual pertenece cada noticia en este caso  a la empresa que pertenece
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente nuevemente.\"}");
        }
    }
}
