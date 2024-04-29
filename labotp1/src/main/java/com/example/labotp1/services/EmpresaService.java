package com.example.labotp1.services;

import com.example.labotp1.entity.Empresa;
import com.example.labotp1.entity.Noticia;
import com.example.labotp1.repositories.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements BaseService<Empresa>{

    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    @Transactional
    public List<Empresa> findAll() throws Exception {
        try{
            List<Empresa>entities = empresaRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public Empresa findById(long id) throws Exception {
        try{
            Optional<Empresa> entityOptional= empresaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empresa save(Empresa entity) throws Exception {
        try{
            entity=empresaRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Empresa update(Long id, Empresa entity) throws Exception {
        try{
            Optional<Empresa>EntityOptional = empresaRepository.findById(id);
            Empresa empresa=EntityOptional.get();
            empresa= empresaRepository.save(entity);
            return empresa;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(empresaRepository.existsById(id)){
                empresaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }
    @Transactional
    public boolean eliminarEmpresa(Long id) throws Exception {
        try{
            if(empresaRepository.existsById(id)){
                empresaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }


}
