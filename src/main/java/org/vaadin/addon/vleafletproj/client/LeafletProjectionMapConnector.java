/*
 * Copyright 2017 Vaadin Community.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.addon.vleafletproj.client;

import com.google.gwt.dom.client.Element;
import com.vaadin.shared.ui.Connect;
import org.peimari.gleaflet.client.Crs;
import org.peimari.gleaflet.client.Map;
import org.peimari.gleaflet.client.MapOptions;
import org.vaadin.addon.leaflet.client.LeafletMapConnector;
import org.vaadin.addon.vleafletproj.LProjectionMap;

/**
 *
 * @author mstahv
 */
@Connect(LProjectionMap.class)
public class LeafletProjectionMapConnector extends LeafletMapConnector {

    @Override
    protected Map createMap(Element mapElement, MapOptions options) {
        options.setCrs(introduceCustomCsr(getState().customProjection.getCode(), getState().customProjection.getProj4def(), getState().customProjection.getOptions(), getState().customProjection.getBottomLeft(), getState().customProjection.getTopRight()));
        options.setWorldCopyJump(false);
        options.setCustomOption("continuousWorld", true);
        return super.createMap(mapElement, options);
    }

    @Override
    public LeafletProjectionMapState getState() {
        return (LeafletProjectionMapState) super.getState();
    }
    
    public static native final Crs introduceCustomCsr(String code, String proj4def, String options, String bottomLeft, String topRight)
    /*-{
        var opts = JSON.parse(options);
        return new $wnd.L.Proj.CRS(code, proj4def, opts);
    }-*/
    ;
    
}
