package once.curso.proyectotienda.model;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import once.curso.proyectotienda.entities.ExistingProduct;
import once.curso.proyectotienda.restcontrollers.ExistingProductRestController;
import once.curso.proyectotienda.restcontrollers.SubCategoryRestController;

@Component
public class ExistingProductModelAssembler implements SimpleRepresentationModelAssembler<ExistingProduct> {
    @Override
    public void addLinks(EntityModel<ExistingProduct> existingProduct) {
        existingProduct.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExistingProductRestController.class)
                .findById(existingProduct.getContent().getId())).withSelfRel());

        existingProduct.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SubCategoryRestController.class)
                .findById(existingProduct.getContent().getSubcategory().getId())).withRel("subcategory"));
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<ExistingProduct>> existingProducts) {
        existingProducts.forEach(this::addLinks);
    }
}