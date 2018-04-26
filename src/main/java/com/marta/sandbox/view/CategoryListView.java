package com.marta.sandbox.view;

import com.marta.sandbox.enums.Category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class CategoryListView extends AbstractView {

    public Category[] getCategories () { return Category.values(); }

}
