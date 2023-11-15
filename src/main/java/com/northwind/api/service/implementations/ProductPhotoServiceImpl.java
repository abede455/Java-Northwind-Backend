package com.northwind.api.service.implementations;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.northwind.api.entities.Product;
import com.northwind.api.entities.ProductPhoto;
import com.northwind.api.repository.ProductPhotoRepository;
import com.northwind.api.service.ProductPhotoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductPhotoServiceImpl implements ProductPhotoService {

    private final ProductPhotoRepository repository;
    private final Path root = Paths.get("upload");

    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize upload directory");
        }
    }

    public String save(MultipartFile file, Long productPhotoId) {
        Path target = root.resolve(String.valueOf(productPhotoId) + "_" + file.getOriginalFilename());
        try (InputStream fileStream = file.getInputStream()) {
            Files.copy(fileStream, target);
            return target.toString();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<ProductPhoto> createEntity(ProductPhoto Entity) {
        return Optional.of(repository.save(Entity));
    }

    @Override
    public List<ProductPhoto> findAllEntity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllEntity'");
    }

    @Override
    public ProductPhoto findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public ProductPhoto createEntity(MultipartFile file, Product product) {
        ProductPhoto productPhoto = new ProductPhoto();
        productPhoto.setProhoFileName(file.getOriginalFilename());
        productPhoto.setProhoFileType(file.getContentType());
        productPhoto.setProhoSize(file.getSize());
        productPhoto.setProduct(product);
        productPhoto = createEntity(productPhoto).orElseThrow(() -> new RuntimeException("Product Photo uncreated"));
        // productPhoto.setProhoUrl(save(file, productPhoto.getProhoId()));

        return productPhoto;
    }

}
