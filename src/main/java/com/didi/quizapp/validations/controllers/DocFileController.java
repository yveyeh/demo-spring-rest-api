package com.didi.quizapp.validations.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.didi.quizapp.validations.DocFile;
import com.didi.quizapp.validations.services.DocFileService;

@RestController
@RequestMapping("/iam/identities/validations/docfiles")
public class DocFileController {

    public DocFileController() {
        //
    }

    @Autowired
    private DocFileService docFileService;

    @PostMapping("")
    public ResponseEntity<String> createDocFile(@RequestBody DocFile docFile) {
        return docFileService.createDocFile(docFile);
    }

    @GetMapping("")
    public ResponseEntity<List<DocFile>> getAllDocFiles() {
        return docFileService.getAllDocFiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocFile> getDocFileByID(@PathVariable UUID id) {
        return docFileService.getDocFileByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDocFile(@PathVariable UUID id, @RequestBody DocFile updatedDocFile) {
        return docFileService.updateDocFile(id, updatedDocFile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocFile(@PathVariable UUID id) {
        return docFileService.deleteDocFile(id);
    }
}
