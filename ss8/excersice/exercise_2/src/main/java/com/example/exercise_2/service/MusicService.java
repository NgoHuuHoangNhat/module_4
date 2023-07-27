package com.example.exercise_2.service;

import com.example.exercise_2.model.Music;
import com.example.exercise_2.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService{
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return musicRepository.findAll(pageable);
    }

    @Override
    public void addMusic(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Music findById(Integer id) {
        return musicRepository.findById(id).get();
    }
}
