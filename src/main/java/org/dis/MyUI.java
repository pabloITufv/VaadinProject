package org.dis;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.w3c.dom.Text;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    //Crea un objeto de tipo label y le pone un nombre
    private TextField creaLabel(String texto){
        TextField etiqueta = new TextField();
        etiqueta.setCaption(texto);
        return etiqueta;
    }
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        //Vertical Layout es un Marco en Vaadin
        final VerticalLayout layout = new VerticalLayout();
        final HorizontalLayout salarioBruto = new HorizontalLayout();
        final HorizontalLayout salarioNeto = new HorizontalLayout();
        TextField tipo = creaLabel("Tipo empleado:");
        TextField ventasMes = creaLabel("Ventas del Mes:");
        TextField horasExtra = creaLabel("Horas Extra:");

        salarioBruto.addComponents(tipo,ventasMes,horasExtra);
        //Esto es para el huequecito de la cagita
        //final TextField name = new TextField();
        //name.setCaption("Type your name here:");

        //Crea el botón y le añade el evento
        Button button = new Button("Calcular Salario Bruto:");
        button.addClickListener(e -> {
            //layout.addComponent(new Label("Thanks " + name.getValue()
                    //+ ", it works!"));
        });
        TabSheet tabs = new TabSheet();
        tabs.addTab(salarioBruto).setCaption("Calcular Salario Bruto");
        tabs.addTab(salarioNeto).setCaption("Calcular Salario Neto");

        //En el marco (Layout) añademe los eventos que he creado arriba
        layout.addComponents(tabs, button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
