package com.jhops10.poi.controller;

import com.jhops10.poi.controller.dto.CreatePointOfInterest;
import com.jhops10.poi.entity.PointOfInterest;
import com.jhops10.poi.repository.PointOfInterestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PointOfInterestController {

    private final PointOfInterestRepository repository;

    public PointOfInterestController(PointOfInterestRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/points-of-interest")
    public ResponseEntity<Void> createPoi(@RequestBody CreatePointOfInterest body) {

        repository.save(new PointOfInterest(body.name(), body.x(), body.y()));

        return ResponseEntity.ok().build();
    }

    @GetMapping("/points-of-interest")
    public ResponseEntity<Page<PointOfInterest>> listPoi(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        var body = repository.findAll(PageRequest.of(page, pageSize));

        return ResponseEntity.ok(body);
    }
}
