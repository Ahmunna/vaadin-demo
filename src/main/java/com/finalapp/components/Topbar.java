package com.finalapp.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class Topbar extends HorizontalLayout {

    private TextField filter;
    private Button newProduct;

    public TextField getFilter() {
        return filter;
    }

    public void setFilter(TextField filter) {
        this.filter = filter;
    }

    public Button getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Button newProduct) {
        this.newProduct = newProduct;
    }

    //method for creating the topbar
    public  Topbar() {
        filter = new TextField();
        filter.setPlaceholder("Filter by Lastname");


        newProduct = new Button("New Employee");
        newProduct.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        newProduct.setIcon(VaadinIcon.PLUS_CIRCLE.create());


       setWidth("100%");
        add(filter);
       add(newProduct);
        setVerticalComponentAlignment(Alignment.START, filter);
        expand(filter);
    }
}
