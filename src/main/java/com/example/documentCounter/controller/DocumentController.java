package com.example.documentCounter.controller;

import com.example.documentCounter.model.DocumentInfo;
import com.example.documentCounter.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<DocumentInfo> uploadFile(@RequestParam("file") MultipartFile file) {
        // System.out.println("Arquivo recebido: " + file.getOriginalFilename()); => log para verificar se o parâmetro está chegando ao servidor.
        try {
            DocumentInfo documentInfo = documentService.processDocument(file);
            return ResponseEntity.ok(documentInfo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
