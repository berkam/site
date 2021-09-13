package site.controllers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import site.model.product.Product;

@Component
class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {

    @Override
    public EntityModel<Product> toModel(Product employee) {
        return new EntityModel<>(employee,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductionController.class).all()).withRel("products"));
    }
}
