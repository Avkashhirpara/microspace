package com.example.jpademo.tdcenter.coverageinfo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoverageController {

    CoverageService coverageService;

    public CoverageController(CoverageService coverageService) {
        this.coverageService = coverageService;
    }
    @RequestMapping("/coverageList")
    public List<CoverageInfo> getCoverageList(@RequestParam(required = false) Integer page,
                                              @RequestParam(required = false) Integer size){
        Long before = System.currentTimeMillis();
        if(page == null){
            page = 1;
        }
        if (size == null){
            size = 10;
        }

        List<CoverageInfo> list= coverageService.getCoverageList(page,size);
        Long after = System.currentTimeMillis();
        System.out.println((after-before));
        return list;
    }

    @RequestMapping("/coveragebyid")
    public CoverageInfo getCoverageById(@RequestParam(required = false) Integer id){
        if(id == null){
            id = 1;
        }
        Long before = System.currentTimeMillis();
        CoverageInfo ci =  coverageService.getCoverageById(id);
        Long after = System.currentTimeMillis();
        System.out.println((after-before));
        return ci;
    }
    @RequestMapping("/coveragebyids")
    public List<CoverageInfo> getCoverageByIds(@RequestParam(required = false) List<Integer> id){
        Long before = System.currentTimeMillis();
        List<CoverageInfo> list= coverageService.getCoverageByIds(id);
        Long after = System.currentTimeMillis();
        System.out.println((after-before));
        return list;
    }
    @RequestMapping("/coverageLessThen")
    public List<CoverageInfo> getCoverageByIds(@RequestParam(required = false) Integer pecentage){
        Long before = System.currentTimeMillis();
        List<CoverageInfo> list= coverageService.getCoverageInfoByCriteria(pecentage);
        Long after = System.currentTimeMillis();
        System.out.println(list.size()+"===========================================");
        System.out.println((after-before));
        return list;
    }
    @RequestMapping("/coveragebyfilename")
    public List<CoverageInfo> getCoverageByFilename(@RequestParam(required = false) String filename){
        if(filename == null){
            filename = "";
        }
        Long before = System.currentTimeMillis();
        List<CoverageInfo> ci =  coverageService.getCoverageByFileName(filename);
        Long after = System.currentTimeMillis();
        System.out.println((after-before));
        return ci;
    }
}
