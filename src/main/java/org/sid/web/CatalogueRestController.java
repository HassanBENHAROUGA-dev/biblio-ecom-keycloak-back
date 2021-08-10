package org.sid.web;

import org.sid.dao.ProductRepository;
import org.sid.entities.Product;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
@CrossOrigin("*")
@RestController
public class CatalogueRestController {
    private ProductRepository productRepository;

    public CatalogueRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Product p = productRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()));

    }
    @PostMapping(path = "/uploadPhoto/{id}")
    //@PreAuthorize("hasAuthority('admin')")
    public void uploadPhoto(MultipartFile file,@PathVariable Long id) throws IOException {
        Product p = productRepository.findById(id).get();
        //enregistrer le nom de laphoto en database par son id
        //p.setPhotoName(id+".png");
        p.setPhotoName(file.getOriginalFilename());
        Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()), file.getBytes());
        productRepository.save(p);
    }
}
