package com.example.labotp1.repositories;

import com.example.labotp1.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

}
