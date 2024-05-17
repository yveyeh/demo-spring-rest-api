package com.didi.quizapp.validations.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.didi.quizapp.validations.DocFileVerification;
import com.didi.quizapp.validations.data.DocFileVerificationDTO;

@Service
public class DocFileVerificationService {

    public DocFileVerificationService() {
        //
    }

    @Autowired
    DocFileVerificationDTO docFileVerificationDTO;

    public ResponseEntity<String> createDocFileVerification(DocFileVerification docFileVerification) {
        try {
            docFileVerificationDTO.save(docFileVerification);
            return new ResponseEntity<>("Doc file verification created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<DocFileVerification>> getAllDocFileVerifications(UUID docFileId) {
        try {
            return new ResponseEntity<>(docFileVerificationDTO.findByDocFileId(docFileId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<DocFileVerification> getDocFileVerificationByID(UUID id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            return docFileVerificationDTO.findById(id)
                    .map(docFile -> new ResponseEntity<>(docFile, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateDocFileVerification(UUID id, DocFileVerification updatedDocFileVerification) {
        try {
            Optional<DocFileVerification> optionalDocFileVerification = docFileVerificationDTO.findById(id);
            if (optionalDocFileVerification.isPresent()) {
                DocFileVerification docFileVerificationToUpdate = optionalDocFileVerification.get();
                docFileVerificationToUpdate.setId(id);
                docFileVerificationToUpdate.setVerifiedAt(updatedDocFileVerification.getVerifiedAt());
                docFileVerificationToUpdate.setVerifiedBy(updatedDocFileVerification.getVerifiedBy());
                docFileVerificationToUpdate.setVerificationStatus(updatedDocFileVerification.getVerificationStatus());
                docFileVerificationToUpdate.setCallMade(updatedDocFileVerification.isCallMade());
                docFileVerificationToUpdate.setRejectReasonId(updatedDocFileVerification.getRejectReasonId());
                docFileVerificationToUpdate.setDocFileId(updatedDocFileVerification.getDocFileId());
                docFileVerificationDTO.save(docFileVerificationToUpdate);
                return new ResponseEntity<String>("Successfully updated doc file verification", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<String>("Doc file verification not found", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteDocFileVerification(UUID id) {
        try {
            docFileVerificationDTO.deleteById(id);
            return new ResponseEntity<String>("Successfully deleted doc verification", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
