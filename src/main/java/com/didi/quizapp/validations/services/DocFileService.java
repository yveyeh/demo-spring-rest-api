package com.didi.quizapp.validations.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.didi.quizapp.validations.DocFile;
import com.didi.quizapp.validations.data.DocFileDTO;


@Service
public class DocFileService {

    public DocFileService() {
        //
    }

    @Autowired
    DocFileDTO docFileDTO;

    public ResponseEntity<String> createDocFile(DocFile docFile) {
        try {
            docFileDTO.save(docFile);
            return new ResponseEntity<>("DocFile created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<DocFile>> getAllDocFiles() {
        try {
            return new ResponseEntity<>(docFileDTO.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<DocFile> getDocFileByID(UUID id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            return docFileDTO.findById(id)
                    .map(docFile -> new ResponseEntity<>(docFile, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateDocFile(UUID id, DocFile updatedDocFile) {
        try {
            Optional<DocFile> optionalDocFile = docFileDTO.findById(id);
            if (optionalDocFile.isPresent()) {
                DocFile docFileToUpdate = optionalDocFile.get();
                
                docFileToUpdate.setName(updatedDocFile.getName());
                docFileToUpdate.setPath(updatedDocFile.getPath());
                docFileToUpdate.setSize(updatedDocFile.getSize());
                docFileToUpdate.setDescription(updatedDocFile.getDescription());
                docFileToUpdate.setVerified(updatedDocFile.isVerified());
                docFileToUpdate.setVerifiedAt(updatedDocFile.getVerifiedAt());
                docFileToUpdate.setVerificationStatus(updatedDocFile.getVerificationStatus());
                docFileToUpdate.setVerifiedBy(updatedDocFile.getVerifiedBy());
                docFileToUpdate.setDocFileTypeId(updatedDocFile.getDocFileTypeId());
                docFileToUpdate.setIdDocId(updatedDocFile.getIdDocId());

                docFileDTO.save(docFileToUpdate);
                return new ResponseEntity<String>("Successfully updated doc file", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<String>("Doc file not found", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteDocFile(UUID id) {
        try {
            docFileDTO.deleteById(id);
            return new ResponseEntity<String>("Successfully deleted doc file", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
