package com.example.exercise_2.service;


import com.example.exercise_2.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {

    Page<Music> findAll(Pageable pageable);

    void addMusic(Music music);

    Music findById(Integer id);
}
