package com.marta.sandbox.webservice;

import com.marta.sandbox.dao.BrandDAO;
import com.marta.sandbox.dao.ProductDAO;
import com.marta.sandbox.dto.ProductRecord;
import com.marta.sandbox.dto.ResultRecord;
import com.marta.sandbox.entity.Product;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/product-editor")
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ProductEditor {

    @Inject
    private ProductDAO productDAO;

    @Inject
    private BrandDAO brandDAO;

    @GET
    @Path("/get-product-by-id")
    @Produces({MediaType.APPLICATION_JSON})
    @WebMethod
    public ProductRecord getProductById (
            @QueryParam(value = "id")
            @WebParam (name = "id", partName = "id")
            String id
    ) {
        final Product product = productDAO.getProductById(id);
        if(product == null) return null;
        return new ProductRecord(product);
    }

    @GET
    @Path("/get-products-by-name")
    @Produces({MediaType.APPLICATION_JSON})
    @WebMethod
    public List<ProductRecord> getProductsByName (
            @QueryParam(value = "name")
            @WebParam (name = "name", partName = "name")
            String name
    ) {
        return ProductRecord.toList(productDAO.getListProductByName(name));
    }

    @GET
    @Path("/get-all-products")
    @Produces({MediaType.APPLICATION_JSON})
    @WebMethod
    public List<ProductRecord> getProducts () {
        return ProductRecord.toList(productDAO.getListProduct());
    }

    @GET
    @Path("/get-products-by-category")
    @Produces({MediaType.APPLICATION_JSON})
    @WebMethod
    public List<ProductRecord> getProductsByCategory (
            @QueryParam(value = "category")
            @WebParam (name = "category", partName = "category")
            String category
    ) {
        return ProductRecord.toList(productDAO.getListProductByCategory(category));
    }

    @GET
    @Path("/add-new-brand")
    @Produces({MediaType.APPLICATION_JSON})
    @WebMethod
    public ResultRecord addNewBrand (
            @QueryParam(value = "brand")
            @WebParam (name = "brand", partName = "brand")
            String brand)
    {
        brandDAO.persist(brand.toUpperCase());
        return new ResultRecord();
    }

    @WebMethod
    public void addNewProduct (
            @WebParam (name = "name", partName = "name")
            String name,
            @WebParam (name = "category", partName = "category")
            String category,
            @WebParam(name = "brandId", partName = "brandId")
            String brandId,
            @WebParam(name = "price", partName = "price")
            float price,
            @WebParam(name = "image", partName = "image")
            String image,
            @WebParam(name="description", partName = "description")
            String description,
            @WebParam(name = "inStock", partName = "inStock")
            boolean inStock
    ) {
        final Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setBrand(brandDAO.getBrandById(brandId));
        product.setPrice(price);
        product.setImage(image);
        product.setDescription(description);
        product.setInStock(inStock);
        productDAO.merge(product);
    }

    @GET
    @Path("/remove-product-by-id")
    @Produces({MediaType.APPLICATION_JSON})
    @WebMethod
    public ResultRecord removeProductById (
            @QueryParam(value = "id")
            @WebParam (name = "id", partName = "id")
            String id
    ) {
        productDAO.removeProduct(id);
        return new ResultRecord();
    }
}
