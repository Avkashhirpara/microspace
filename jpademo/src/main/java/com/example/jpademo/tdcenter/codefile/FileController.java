package com.example.jpademo.tdcenter.codefile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileController {

    CodeFileService codeFileService;

    public FileController(CodeFileService codeFileService) {
        this.codeFileService = codeFileService;
    }

    @RequestMapping("/listFiles")
    public List<CodeFileModel> getAllFiles(){
        return codeFileService.getFileList();
    }
}
