package com.example.labotp1.repositories;

import com.example.labotp1.entity.Noticia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia,Long>{

    @Query("SELECT n FROM Noticia n WHERE lower(n.tituloNoticia) LIKE lower(concat('%', :texto, '%')) OR lower(n.resumenNoticia) LIKE lower(concat('%', :texto, '%')) ORDER BY n.fecha DESC")
    Page<Noticia> buscarNoticias(String texto, Pageable pageable);

}
