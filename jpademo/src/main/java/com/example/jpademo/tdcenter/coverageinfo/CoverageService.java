package com.example.jpademo.tdcenter.coverageinfo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CoverageService {

    CoverageRepository coverageRepository;

    public CoverageService(CoverageRepository coverageRepository) {
        this.coverageRepository = coverageRepository;
    }

    public List<CoverageInfo> getCoverageList(){
       return coverageRepository.findAll();
    }

    public CoverageInfo getCoverageById(Integer id){
        return coverageRepository.findById(id).get();
    }

    public List<CoverageInfo> getCoverageByIds(List<Integer> ids){
        return coverageRepository.findAllById(ids);
    }

    public List<CoverageInfo> getCoverageList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return coverageRepository.findAll(pageable).toList();
    }

    public List<CoverageInfo> getCoverageInfoByCriteria(Integer percentage){
        CoverageInfoSpecification coverageInfoSpecification =
                new CoverageInfoSpecification(new SearchCriteria("percentage","<",percentage));
        return coverageRepository.findAll(coverageInfoSpecification);
    }

    public List<CoverageInfo> getCoverageByFileName(String filename){
        return coverageRepository.getCoverageByClassName(filename);
    }
}

