package com.finalapp.view;

import com.finalapp.components.Topbar;
import com.finalapp.controller.crud.CustomerEditor;
import com.finalapp.model.Customer;
import com.finalapp.service.CustomerRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.util.StringUtils;

@Route(value = "dashboard", layout = MainLayout.class)
public class Dashboard extends VerticalLayout {

    private final CustomerRepository repo;

    private final CustomerEditor editor;

    final Grid<Customer> grid;


    Topbar topBar;
    public static final String VIEW_NAME ="dashboard";

    public Dashboard(CustomerRepository repo, CustomerEditor editor) {
        topBar = new Topbar();
        this.repo = repo;
        this.editor = editor;
        this.grid = new Grid<>(Customer.class);

        // build layout
        add(topBar, grid, editor);

        grid.setColumns("id", "firstName", "lastName");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);



        topBar.getFilter().setValueChangeMode(ValueChangeMode.EAGER);
        topBar.getFilter().addValueChangeListener(e -> listCustomers(e.getValue()));

        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editCustomer(e.getValue());
        });

        // Instantiate and edit new Customer the new button is clicked
        topBar.getNewProduct().addClickListener(e -> editor.editCustomer(new Customer("", "")));

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listCustomers(topBar.getFilter().getValue());
        });

        // Initialize listing
        listCustomers(null);
    }


    void listCustomers(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(repo.findAll());
        }
        else {
            grid.setItems(repo.findByLastNameStartsWithIgnoreCase(filterText));
        }
    }


}
