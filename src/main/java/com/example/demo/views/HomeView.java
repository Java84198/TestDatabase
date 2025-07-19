package com.example.demo.views;

import com.example.demo.Dati;
import com.example.demo.ServiceDati;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;



@Route("")
public class HomeView extends VerticalLayout {

    private final ServiceDati serviceDati;
    private Dati dati;


    @Autowired
    public HomeView(ServiceDati serviceDati) {
        this.serviceDati = serviceDati;
        setupUI();
    }

    private void setupUI() {
        add(new H1("Welcome to your new application"));
        add(new Paragraph("This is the home view"));
        add(new Paragraph("You can edit this view in src/main/java/com/example/demo/views/HomeView.java"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

        TextField nome = new TextField("Nome");
        nome.setPlaceholder("Inserisci il tuo nome");

        PasswordField password = new PasswordField("Password");
        password.setPlaceholder("Inserisci la tua password");

        Button button = new Button("Login");
        button.addClickListener(e -> {
            // Ottieni i dati più recenti dal database
            Iterable<Dati> allDati = serviceDati.findAll();
            boolean loginSuccessful = false;

            for (Dati d : allDati) {
                if (nome.getValue().equalsIgnoreCase(d.getNome()) &&
                    password.getValue().equalsIgnoreCase(d.getCognome())) {
                    loginSuccessful = true;

                    break;
                }
            }

            if (loginSuccessful) {
                Notification.show("Login effettuato con successo");
                nome.setValue("");
                password.setValue("");
                button.setEnabled(false);
            } else {
                Notification.show("Credenziali non valide");
            }
        });

        add(nome, password, button);
    }
}
