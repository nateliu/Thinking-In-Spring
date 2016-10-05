package org.springframework.samples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.models.Spittle;
import org.springframework.samples.models.Spittler;
import org.springframework.samples.repositories.ISpittleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2016/10/4 0004.
 */
@Controller
public class SpittleController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    private ISpittleRepository spittleRepository;

    public SpittleController() {
    }

    @Autowired
    public SpittleController(ISpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/spittles", method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute("spittleList", spittleRepository.finSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    @RequestMapping(value = "/spittles/{id}", method = RequestMethod.GET)
    public String spittle(@PathVariable long id, Model model) {
        model.addAttribute("spittle", spittleRepository.finOne(id));
        return "spittle";
    }

    @RequestMapping(value = "/spittler/register", method = RequestMethod.GET)
    public String showRegister(Model model) {
        model.addAttribute("spittler", new Spittler());
        return "registerForm";
    }


    @RequestMapping(value = "/spittler/register", method = RequestMethod.POST)
    public String processRegister(@Valid Spittler spittler, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        spittleRepository.save(spittler);
        return "redirect:/spittler/" + spittler.getUserName();
    }

    @RequestMapping(value = "/spittler/{userName}", method = RequestMethod.GET)
    public String spittle(@PathVariable String userName, Model model) {
        Spittler spittler = spittleRepository.finByUserName(userName);
        model.addAttribute("spittler", spittler);
        return "profile";
    }

    @RequestMapping(value = "/pagedSpittles", method = RequestMethod.GET)
    public List<Spittle> pagedSpittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                                       @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.finSpittles(max, count);
    }
}
