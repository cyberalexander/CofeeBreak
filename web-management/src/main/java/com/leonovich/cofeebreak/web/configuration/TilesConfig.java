package com.leonovich.cofeebreak.web.configuration;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Configure tiles definitions on application.
 * Created by alexanderleonovich on 30.08.15.
 */
public class TilesConfig implements DefinitionsFactory {

    private static final Map<String, Definition> tilesDefinitions = new HashMap<>();
    private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/view/layout/default.jsp");


    /**
     * @param name  <code>Name of the view</code>
     * @param title <code>Page title</code>
     * @param body  <code>Body JSP file path</code>
     *              <p/>
     *              <code>Adds default layout definitions</code>
     */
    private static void addDefaultLayout(String name, String title, String body) {
        Map<String, Attribute> attributes = new HashMap<>();

        attributes.put("title", new Attribute(title));
        attributes.put("header", new Attribute("/WEB-INF/view/layout/header.jsp"));
        attributes.put("body", new Attribute(body));
        attributes.put("footer", new Attribute("/WEB-INF/view/layout/footer.jsp"));

        tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
    }

    /**
     * Registration of tiles views pages
     */
    public static void addDefinitions() {
        addDefaultLayout("showCoffeeMenu", "WELCOME", "/WEB-INF/view/welcome.jsp");
        addDefaultLayout("login", "LOGIN PAGE", "/WEB-INF/view/login.jsp");
        addDefaultLayout("coffeeMenu", "Main", "/WEB-INF/view/coffee_menu.jsp");
        addDefaultLayout("createOrder", "CREATE ORDER", "/WEB-INF/view/create_order.jsp");
        addDefaultLayout("chooseAddress", "CHHOSE ORDER ADDRESS", "/WEB-INF/view/choose_address.jsp");
        addDefaultLayout("registration", "REGISTRATION PAGE", "/WEB-INF/view/registration.jsp");
        addDefaultLayout("addAddress", "Add Address", "/WEB-INF/view/add_address.jsp");
        addDefaultLayout("updateSail", "Update Sail", "/WEB-INF/view/update_sail.jsp");
        addDefaultLayout("addCoffee", "Add Coffee", "/WEB-INF/view/add_coffee.jsp");
        addDefaultLayout("editCoffee", "Edit Coffee", "/WEB-INF/view/edit_coffee.jsp");
        addDefaultLayout("loginfailed", "Login Failed", "/WEB-INF/view/login.jsp");
        addDefaultLayout("error", "Error", "/WEB-INF/view/error.jsp");
    }

    /**
     * Add Apache tiles definitions
     */
    @Override
    public Definition getDefinition(String name, Request request) {
        return tilesDefinitions.get(name);
    }
}
