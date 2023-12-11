package com.cadastro.desafio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="TB_USUARIO")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cd_usuario")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name = "ds_nome")
    private String nome;
    @Column(name = "ds_email")
    private String email;
    @Column(name = "ds_senha")
    private String senha;
}
