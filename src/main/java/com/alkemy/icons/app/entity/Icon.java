package com.alkemy.icons.app.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "icon")
//@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id=?")
//@Where(clause = "deleted=false")
@Getter
@Setter
public class Icon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCracion;

    private Long altura;

    private String historia;

    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<Pais> paises = new ArrayList<>();

    public void addPais(Pais pais){this.paises.add(pais);}

    public void removePais(Pais pais){this.paises.remove(pais);}

}
