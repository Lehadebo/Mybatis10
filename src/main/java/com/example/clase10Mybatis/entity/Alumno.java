
package com.example.clase10Mybatis.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno implements Serializable{
    private static final long serialVersionUID = 3754851399214200439L;
	private int idalumno;
	private String nombre;
	private String telefono;
	private String correo;	
	private int idcarrera;
}
