package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Controller;

import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.DTO.DTOPeliculas;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Service.Servicepelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Peliculas")
@CrossOrigin
public class ControllerPelicula {
    @Autowired
    private Servicepelicula service;


    @GetMapping
    public List<DTOPeliculas> Obtener(){return service.Listar();}
}
