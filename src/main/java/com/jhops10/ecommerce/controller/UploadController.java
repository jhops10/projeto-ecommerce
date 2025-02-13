package com.jhops10.ecommerce.controller;

import com.jhops10.ecommerce.dto.PathToFileDTO;
import com.jhops10.ecommerce.service.upload.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class UploadController {

    @Autowired
    private IUploadService uploadService;

    @PostMapping("/upload")
    public ResponseEntity<PathToFileDTO> uploadFile(@RequestParam("arquivo") MultipartFile arquivo) {
        String fileName = uploadService.uploadFile(arquivo);
        if (fileName != null) {
            PathToFileDTO pathToFileDTO = new PathToFileDTO(fileName);
            return ResponseEntity.ok().body(pathToFileDTO);
        }
        return ResponseEntity.badRequest().build();
    }
}
