package com.example.financialproductpreference.controller;

import com.example.financialproductpreference.entity.LikeList;
import com.example.financialproductpreference.service.LikeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likelists")
public class LikeListController {
    @Autowired
    private LikeListService likeListService;

    @PostMapping
    public ResponseEntity<LikeList> addLikeList(@RequestBody LikeList likeList) {
        return new ResponseEntity<>(likeListService.addLikeList(likeList), HttpStatus.CREATED);
    }

    @GetMapping
    public List<LikeList> getAllLikeLists() {
        return likeListService.getAllLikeLists();
    }

    @PutMapping("/{sn}")
    public ResponseEntity<LikeList> updateLikeList(@PathVariable Long sn, @RequestBody LikeList likeListDetails) {
        return new ResponseEntity<>(likeListService.updateLikeList(sn, likeListDetails), HttpStatus.OK);
    }

    @DeleteMapping("/{sn}")
    public ResponseEntity<Void> deleteLikeList(@PathVariable Long sn) {
        likeListService.deleteLikeList(sn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
