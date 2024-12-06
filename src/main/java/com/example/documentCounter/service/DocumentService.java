package com.example.documentCounter.service;

import com.example.documentCounter.model.DocumentInfo;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class DocumentService {

    public DocumentInfo processDocument(MultipartFile file) throws Exception {
        String filename = file.getOriginalFilename();
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename is missing");
        }
        String fileType = file.getOriginalFilename().toLowerCase();
        int pageCount;

        try (InputStream inputStream = file.getInputStream()) {
            if (fileType.endsWith(".pdf")) {
                pageCount = countPdfPages(inputStream);
            } else if (fileType.endsWith(".docx")) {
                pageCount = countWordPages(inputStream);
            } else {
                throw new IllegalArgumentException("Unsupported file type");
            }
        }

        double cost = calculateCost(pageCount);

        return new DocumentInfo(filename, pageCount, cost);
    }

    private int countPdfPages(InputStream inputStream) throws Exception {
        try (PDDocument pdf = PDDocument.load(inputStream)) {
            return pdf.getNumberOfPages();
        }
    }

    private int countWordPages(InputStream inputStream) throws Exception {
        try (XWPFDocument document = new XWPFDocument(inputStream)) {
            return document.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
        }
    }

    private double calculateCost(int pages) {
        return pages * 0.10; // Exemplo: R$ 0,10 por página.
    }
}

