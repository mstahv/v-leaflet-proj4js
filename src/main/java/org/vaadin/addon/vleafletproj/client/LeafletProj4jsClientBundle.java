package org.vaadin.addon.vleafletproj.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.TextResource;

public interface LeafletProj4jsClientBundle extends ClientBundle {
 
    @Source("proj4.js")
    @DoNotEmbed
    TextResource proj4js();

    @Source("proj4leaflet.js")
    @DoNotEmbed
    TextResource proj4Leaflet();

}
