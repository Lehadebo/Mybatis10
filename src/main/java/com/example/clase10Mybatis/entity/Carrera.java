
package com.example.clase10Mybatis.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera implements Serializable {
    private int idcarrera;
    private String nombre;
}
