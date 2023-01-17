package com.poecat.animalshelter.files;
/* INTEGRATION TEST */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextFileExporterTest {

    private TextFileExporter textFileExporter;
    private Path exportDirectory;

    @BeforeEach
    void setUp() {
        textFileExporter = new TextFileExporter();
    }

    @AfterEach
    void tearDown() throws IOException {
        exportDirectory.toFile().delete();
    }

    @Test
    void testExport() throws IOException {
        exportDirectory = Files.createTempDirectory("temp");
        TextFileExporter.TEMP_EXPORT_DIRECTORY = exportDirectory.toString();
        String fileContent = "This is a test file.";
        String fileName = "test.txt";

        Path exportedFilePath = textFileExporter.export(fileContent, fileName);

        assertNotNull(exportedFilePath);
        assertTrue(Files.exists(exportedFilePath));
        assertEquals(fileContent, new String(Files.readAllBytes(exportedFilePath)));
    }
}

