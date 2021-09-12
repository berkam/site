package site.controllers;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.model.ProductRepository;
import site.model.product.Product;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductionController {
    private final ProductRepository repository;

    private final ProductModelAssembler assembler;

    ProductionController(ProductRepository repository,
                         ProductModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/products")
    CollectionModel<EntityModel<Product>> all() {

        List<EntityModel<Product>> employees = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return new CollectionModel<>(employees,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductionController.class).all()).withSelfRel());
    }
}
