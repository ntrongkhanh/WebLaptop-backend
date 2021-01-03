package com.weblaptop.backend.services;

import com.weblaptop.backend.models.DTO.CommentDto;
import com.weblaptop.backend.models.DTO.ImageDTO;
import com.weblaptop.backend.models.ENTITY.CommentEntity;
import com.weblaptop.backend.models.ENTITY.ImageEntity;
import com.weblaptop.backend.models.ENTITY.Product.ProductEntity;
import com.weblaptop.backend.models.ENTITY.User;
import com.weblaptop.backend.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private EntityManager entityManager;


    public ResponseEntity<Map<String, Object>> create(CommentDto dto) {
        try {
            User user=entityManager.getReference(User.class,dto.getUser().getId());
            ProductEntity productEntity=entityManager.getReference(ProductEntity.class,dto.getIdProduct());
            CommentEntity paren=entityManager.getReference(CommentEntity.class,dto.getIdParent());
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setUser(user);
            commentEntity.setTime(dto.getTime());
            commentEntity.setProductEntity(productEntity);
            commentEntity.setParent(paren);

            commentEntity=commentRepository.save(commentEntity);

            Map<String, Object> response = new HashMap<>();
            response.put("data",commentEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Map<String, Object>> getAllByProduct(long idProduct) {
        try {
            List<CommentEntity> entityList=commentRepository.findAllByProduct(idProduct);
            List<CommentDto> dtos=new ArrayList<>();
            for (CommentEntity entity:entityList){
                CommentDto dto=new CommentDto();
                dto.setId(entity.getId());
                dto.setUser(entity.getUser());
                dto.setTime(entity.getTime());
                dto.setIdProduct(entity.getProductEntity().getId());
                dto.setContent(entity.getContent());
                dto.setChildren(toChildren(entity.getChildren(),dto.getId()));
                dtos.add(dto);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("data", dtos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    private List<CommentDto> toChildren(List<CommentEntity> list,long idParent){
        List<CommentDto> dtos=new ArrayList<>();
        for (CommentEntity entity: list){
            CommentDto dto=new CommentDto();
            dto.setId(entity.getId());
            dto.setUser(entity.getUser());
            dto.setTime(entity.getTime());
            dto.setIdProduct(entity.getProductEntity().getId());
            dto.setContent(entity.getContent());
            dto.setIdParent(idParent);
            dtos.add(dto);
        }
        return dtos;
    }
}
