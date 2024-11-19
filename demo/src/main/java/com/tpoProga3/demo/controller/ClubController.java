package com.tpoProga3.demo.controller;

import com.tpoProga3.demo.model.ClubEntity;
import com.tpoProga3.demo.repository.ClubRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clubs")
public class ClubController {
    private final ClubRepository clubRepository;
    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
    //method implementations with walkthroughs below

    @PutMapping
    Mono<ClubEntity> createOrUpdateMovie(@RequestBody ClubEntity newMovie) {
        return clubRepository.save(newMovie);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<ClubEntity> getMovies() {
        return clubRepository.findAll();
    }



}
