package DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Controller;

import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.DTO.DTOPremios;
import DiegoZelaya_JaredSaez_B_G2.DiegoZelaya_JaredSaez_B_G2.Service.ServicePremios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/GetPremios")
@CrossOrigin
public class ControllerPremios {
    @Autowired
    private ServicePremios service;

    @GetMapping("/GetAllPremios")
    public List<DTOPremios> getPremios(){return service.GetAllPremios();}
}
