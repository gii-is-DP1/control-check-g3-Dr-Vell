package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {

    private static final String VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";

    private final RecoveryRoomService rrtService;

	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
		this.rrtService = recoveryRoomService;
    }


    @GetMapping(value = "/create")
	public String initCreationForm(ModelMap model) {
		model.addAttribute("recoveryRoom", new RecoveryRoom());
        model.addAttribute("recoveryRoomType", rrtService.getAllRecoveryRoomTypes());
		return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
	}



	@PostMapping(value = "/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result) {		
        String view = "welcome";
		if (result.hasErrors()) {
            return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
		}
        rrtService.save(recoveryRoom);
        return view;
	
    }
}
