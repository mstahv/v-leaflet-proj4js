package org.vaadin.addon;

import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import org.vaadin.addon.leaflet.LMarker;
import org.vaadin.addon.leaflet.LTileLayer;
import org.vaadin.addon.leaflet.LWmsLayer;
import org.vaadin.addon.vleafletproj.LProjectionMap;
import org.vaadin.addon.vleafletproj.client.CustomProjection;
import org.vaadin.addonhelpers.AbstractTest;

/**
 */
public class LProjectionMapUsageUI extends AbstractTest {

    @Override
    public Component getTestComponent() {
        LProjectionMap lProjectionMap = new LProjectionMap();
        CustomProjection customProjection = new CustomProjection();
        customProjection.setCode("EPSG:3067");
        customProjection.setProj4def("+proj=utm +zone=35 +ellps=GRS80 +units=m +towgs84=0,0,0,-0,-0,-0,0 +no_defs");
        customProjection.setProjectedBounds("[-548576.0, 6291456.0, 1548576.0, 8388608]");
        customProjection.setOptions("{" +
"        \"resolutions\": [" +
"            8192," +
"            4096," +
"            2048," +
"            1024," +
"            512," +
"            256," +
"            128," +
"            64," +
"            32," +
"            16," +
"            8," +
"            4," +
"            2," +
"            1," +
"            0.5," +
"            0.25," +
"            0.125," +
"            0.0625," +
"            0.03125," +
"            0.015625" +
"        ], \"origin\":[-548576.0, 8388608]}");
        lProjectionMap.setCustomTmsCrs(customProjection);
        
        LTileLayer lTileLayer = new LTileLayer("http://wmts.mapant.fi/wmts.php?z={z}&x={x}&y={y}");
        lTileLayer.setAttributionString("<a href=\"http://www.maanmittauslaitos.fi/en/digituotteet/laser-scanning-data\" target=\"_blank\">Laser scanning</a> and <a href=\"http://www.maanmittauslaitos.fi/en/digituotteet/topographic-database\" target=\"_blank\">topographic</a> data provided by the <a href=\"http://www.maanmittauslaitos.fi/en\" target=\"_blank\">National Land Survey of Finland</a> under the <a href=\"https://creativecommons.org/licenses/by/4.0/legalcode\">Creative Commons license</a>.");
        
        lTileLayer.setDetectRetina(true);
        
        lProjectionMap.addLayer(lTileLayer);
        
        LWmsLayer lWmsLayer = new LWmsLayer();
        lWmsLayer.setUrl("http://wms.mapant.fi/wms.php");
        
        //lProjectionMap.addLayer(lWmsLayer);
        
        lProjectionMap.setSizeFull();
        // N=6711010.287, E=241608.383(ETRS-TM35FIN), if your markers/vectors 
        // need to be in a custom projection, project those in Java. See geotools project for that.
        LMarker lMarker = new LMarker(60.452405, 22.300335);
        lMarker.setPopup("Vaadin Ltd");
        lProjectionMap.addComponent(lMarker);
        
        lProjectionMap.addClickListener(e -> {
            Notification.show("Clicked at " + e.getPoint());
        });
        
        
        lProjectionMap.zoomToContent();
        return lProjectionMap;
    }

}
