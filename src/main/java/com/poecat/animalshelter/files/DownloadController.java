package com.poecat.animalshelter.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class DownloadController {

    @Autowired
    private FileExporter fileExporter;

    @RequestMapping("/downloads")
    public String index() {
        return "downloads";
    }

    @RequestMapping("/downloads/rules")
    public ResponseEntity<InputStreamResource> downloadTextFile() throws IOException {

        String fileName = "ustawa-o-ochronie-zwierzat.txt";
        Path filePath = Path.of("C:/downloads/ustawa-o-ochronie-zwierzat.txt");
        String fileContent = Files.readString(filePath);

        Path exportedPath = fileExporter.export(fileContent, fileName);

        File exportedFile = exportedPath.toFile();
        FileInputStream fileInputStream = new FileInputStream(exportedFile);
        InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
                .contentType(MediaType.TEXT_PLAIN)
                .contentLength(exportedFile.length())
                .body(inputStreamResource);
    }
}