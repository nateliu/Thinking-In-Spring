package org.springframework.samples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.repositories.ISpittleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/10/4 0004.
 */
@Controller
public class SpittleController {

    private ISpittleRepository spittleRepository;

    public SpittleController() {
    }

    @Autowired
    public SpittleController(ISpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/spittles",method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute("spittleList", spittleRepository.finSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }
}
