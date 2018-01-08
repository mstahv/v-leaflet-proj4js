package org.vaadin.addon.vleafletproj;

import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.vleafletproj.client.CustomProjection;
import org.vaadin.addon.vleafletproj.client.LeafletProjectionMapState;

/**
 * An extended version of LMap that supports using custom projections as baselayer via Proj4JS.
 *
 * @author mstahv
 */
public class LProjectionMap extends LMap {

    public LProjectionMap() {
    }

    @Override
    protected LeafletProjectionMapState getState() {
        return (LeafletProjectionMapState) super.getState();
    }
    
    public void setCustomTmsCrs(CustomProjection customProjection) {
        getState().customProjection = customProjection;
    }

}
