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

import com.didi.quizapp.validations.DocFileVerification;
import com.didi.quizapp.validations.services.DocFileVerificationService;

@RestController
@RequestMapping("/iam/identities/validations")
public class DocFileVerificationController {

    public DocFileVerificationController() {
        //
    }

    @Autowired
    private DocFileVerificationService docFileVerificationService;

    @PostMapping("/{docFileId}/verifications")
    public ResponseEntity<String> createDocFileVerification(@RequestBody DocFileVerification docFileVerification) {
        return docFileVerificationService.createDocFileVerification(docFileVerification);
    }

    @GetMapping("/{docFileId}/verifications")
    public ResponseEntity<List<DocFileVerification>> getAllDocFiles(@PathVariable UUID docFileId) {
        return docFileVerificationService.getAllDocFileVerifications(docFileId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocFileVerification> getDocFileVerificationByID(@PathVariable UUID id) {
        return docFileVerificationService.getDocFileVerificationByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDocFileVerification(@PathVariable UUID id,
            @RequestBody DocFileVerification updatedDocFileVerification) {
        return docFileVerificationService.updateDocFileVerification(id, updatedDocFileVerification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocFileVerification(@PathVariable UUID id) {
        return docFileVerificationService.deleteDocFileVerification(id);
    }
}
