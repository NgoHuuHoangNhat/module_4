package com.example.exercise_2.controller;

import com.example.exercise_2.dto.MusicDto;
import com.example.exercise_2.model.Music;
import com.example.exercise_2.service.IMusicService;
import com.example.exercise_2.service.MusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;
    @GetMapping("/list")
    public ModelAndView showList(@RequestParam(defaultValue = "0") Integer page){
        ModelAndView modelAndView = new ModelAndView("list");
        Pageable pageable = PageRequest.of(page,2, Sort.by("name"));
        Page<Music> musicPage = musicService.findAll(pageable);
        modelAndView.addObject("musicPage",musicPage);
        return modelAndView;
    }
    @GetMapping("/create-form")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("musicDto",new MusicDto());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createMusic(@Valid @ModelAttribute MusicDto musicDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){
        new MusicDto().validate(musicDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto,music);
        musicService.addMusic(music);
        redirectAttributes.addFlashAttribute("msg","Create successfully");
        return "redirect:/music/list";
    }
    @GetMapping("/edit-form/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("edit");
        Music music = musicService.findById(id);
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music,musicDto);
        modelAndView.addObject("musicDto",musicDto);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editMusic(@Valid @ModelAttribute MusicDto musicDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){
        new MusicDto().validate(musicDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "edit";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto,music);
        musicService.addMusic(music);
        redirectAttributes.addFlashAttribute("msg","Edit successfully");
        return "redirect:/music/list";
    }
}
