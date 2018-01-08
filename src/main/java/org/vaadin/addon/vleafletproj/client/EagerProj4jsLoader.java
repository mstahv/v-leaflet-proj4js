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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import org.peimari.gleaflet.client.resources.LeafletResourceInjector;

/**
 *
 * @author mstahv
 */
public class EagerProj4jsLoader implements EntryPoint {

    @Override
    public void onModuleLoad() {
        ensureInjected();
    }

    protected static LeafletProj4jsClientBundle bundle;

    public static void ensureInjected() {
        if (bundle == null) {
            LeafletResourceInjector.ensureInjected();
            bundle = GWT.create(LeafletProj4jsClientBundle.class);
            injectResources();
        }
    }

    /**
     * Override this with deferred binding to customize injected stuff
     */
    protected static void injectResources() {
        injectScript(bundle.proj4js().getText());
        injectScript(bundle.proj4Leaflet().getText());
    }

    private static native void injectScript(String script) /*-{
	    $wnd.eval(script);
    }-*/;
}
