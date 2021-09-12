package demo.controllers;

import demo.model.product.Product;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {

    @Override
    public EntityModel<Product> toModel(Product employee) {
        return new EntityModel<>(employee,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductionController.class).all()).withRel("products"));
    }
}
