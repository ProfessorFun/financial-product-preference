package com.example.financialproductpreference.service;

import com.example.financialproductpreference.entity.LikeList;
import com.example.financialproductpreference.repository.LikeListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeListService {
    @Autowired
    private LikeListRepository likeListRepository;

    public LikeList addLikeList(LikeList likeList) {
        return likeListRepository.save(likeList);
    }

    public List<LikeList> getAllLikeLists() {
        return likeListRepository.findAll();
    }

    public LikeList updateLikeList(Long sn, LikeList likeListDetails) {
        LikeList likeList = likeListRepository.findById(sn).orElseThrow(() -> new ResourceNotFoundException("LikeList not found"));
        likeList.setOrderName(likeListDetails.getOrderName());
        likeList.setAccount(likeListDetails.getAccount());
        likeList.setTotalFee(likeListDetails.getTotalFee());
        likeList.setTotalAmount(likeListDetails.getTotalAmount());
        return likeListRepository.save(likeList);
    }

    public void deleteLikeList(Long sn) {
        LikeList likeList = likeListRepository.findById(sn).orElseThrow(() -> new ResourceNotFoundException("LikeList not found"));
        likeListRepository.delete(likeList);
    }
}
