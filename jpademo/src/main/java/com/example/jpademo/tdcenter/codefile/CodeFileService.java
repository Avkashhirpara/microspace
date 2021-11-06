package com.example.jpademo.tdcenter.codefile;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeFileService {

    CodeFileRepository codeFileRepository;

    public CodeFileService(CodeFileRepository codeFileRepository) {
        this.codeFileRepository = codeFileRepository;
    }

    public List<CodeFileModel> getFileList(){
        return codeFileRepository.findAll();
    }
}
