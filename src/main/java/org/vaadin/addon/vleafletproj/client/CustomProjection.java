/*
 * Copyright 2018 Vaadin Community.
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

import java.io.Serializable;

/**
 * A class to hold custom proj details. All parameters are currently either strings or JSON stings.
 * 
 * TODO: make a proper model class for this
 *
 * @author mstahv
 */
public class CustomProjection implements Serializable {
    
    private String code, proj4def, projectedBounds, options, bottomLeft, topRight;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProj4def() {
        return proj4def;
    }

    public void setProj4def(String proj4def) {
        this.proj4def = proj4def;
    }

    public String getProjectedBounds() {
        return projectedBounds;
    }

    public void setProjectedBounds(String projectedBounds) {
        this.projectedBounds = projectedBounds;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public void setBottomLeft(String bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public void setTopRight(String topRight) {
        this.topRight = topRight;
    }

    public String getBottomLeft() {
        return bottomLeft;
    }

    public String getTopRight() {
        return topRight;
    }
    
    
}
