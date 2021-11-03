
package com.example.clase10Mybatis.controller;

import com.example.clase10Mybatis.entity.Alumno;
import com.example.clase10Mybatis.entity.Carrera;
import com.example.clase10Mybatis.repository.AlumnoMybatisRepository;
import com.example.clase10Mybatis.repository.CarreraMybatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



    @Controller
public class AlumnoController {

    @Autowired
    private CarreraMybatisRepository carreraMybatisRepository;
    @Autowired
    private AlumnoMybatisRepository alumnoMybatisRepository;

    @RequestMapping("/alumno")
    public String alumno(Model model) {
        model.addAttribute("alumno", alumnoMybatisRepository.findAll());
        return "alumno/alumno";
    }

    @RequestMapping("/form")
    public String create(Model model) {
        model.addAttribute("cars", carreraMybatisRepository.findAll());
        return "alumno/add";
    }

    @RequestMapping("/add")
    public String guardar(@RequestParam String nombre, @RequestParam String telefono, @RequestParam String correo, @RequestParam int idcar, Model model) {
        Alumno alum = new Alumno();
       
        alum.setNombre(nombre);
        alum.setTelefono(telefono);
        alum.setCorreo(correo);
        alum.setIdcarrera(idcar);
        alumnoMybatisRepository.insert(alum);
        return "redirect:/alumno";
    }

    @RequestMapping("/del/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        alumnoMybatisRepository.deleteById(id);
        return "redirect:/alumno";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("cars", carreraMybatisRepository.findAll());
        model.addAttribute("alum", alumnoMybatisRepository.readAlumno(id));
        return "alumno/edit";
    }

    @RequestMapping("/update")
    public String update(@RequestParam int idalumno, @RequestParam String nombre,
            @RequestParam String telefono, @RequestParam String correo, @RequestParam int idcarrera) {
        System.out.println(idalumno+"/"+nombre+"/"+telefono+"/"+correo+"/"+idcarrera);
        Alumno alum = alumnoMybatisRepository.readAlumno(idalumno);
        
        alum.setNombre(nombre);
        alum.setTelefono(telefono);
        alum.setCorreo(correo);
        alum.setIdcarrera(idcarrera);
        alumnoMybatisRepository.update(alum);
        return "redirect:/alumno";
    }
}

