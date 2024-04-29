package com.example.labotp1.services;

import com.example.labotp1.entity.Empresa;
import com.example.labotp1.entity.Noticia;
import com.example.labotp1.repositories.NoticiaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService implements BaseService<Noticia> {

    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private NoticiaRepository noticiaRepository;

    @Override
    @Transactional
    public List<Noticia> findAll() throws Exception {
        try{
            List<Noticia>entities = noticiaRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Noticia findById(long id) throws Exception {
        try{
            Optional<Noticia> entityOptional= noticiaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Noticia save(Noticia entity) throws Exception {
        try{

            entity=noticiaRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Noticia update(Long id, Noticia entity) throws Exception {
        try{
            Optional<Noticia>EntityOptional = noticiaRepository.findById(id);
            Noticia noticia=EntityOptional.get();
            noticia= noticiaRepository.save(entity);
            return noticia;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(noticiaRepository.existsById(id)){
                noticiaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }
    @Transactional
    public Noticia saveAempresa(Noticia entity,Long id) throws Exception {
        try{
            Empresa empresa= empresaService.findById(id);
            entity.setEmpresaId(id);
            entity.setEmpresa(empresa);
            entity=noticiaRepository.save(entity);


            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Page<Noticia> buscarNoticias(String texto, Pageable pageable) {
        return noticiaRepository.buscarNoticias(texto, pageable);
    }

}
