package com.example.labotp1.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="empresa")
@Entity
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "horarioDeAtencion")
    private String horarioDeAtencion;

    @Column(name = "quienesSomos")
    private String quienesSomos;

    @Column(name = "latitud")
    private Double latitud;

    @Column(name = "longitud")
    private Double longitud;

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "email")
    private String email;



   @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Noticia> noticias;


}
