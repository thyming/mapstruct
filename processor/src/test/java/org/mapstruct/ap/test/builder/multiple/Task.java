/**
 *  Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.ap.test.builder.multiple;

/**
 * @author Filip Hrisafov
 */
public class Task {

    private final String builderCreationMethod;
    private final String buildMethod;
    private String name;

    public Task() {
        this.builderCreationMethod = null;
        this.buildMethod = "constructor";
    }

    public Task(Builder builder, String buildMethod) {
        this.builderCreationMethod = builder.builderCreationMethod;
        this.buildMethod = buildMethod;
        this.name = builder.name;
    }

    public String getBuilderCreationMethod() {
        return builderCreationMethod;
    }

    public String getBuildMethod() {
        return buildMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Builder builder() {
        return new Builder( "builder" );
    }

    public static class Builder {

        private String name;
        private String builderCreationMethod;

        protected Builder(String builderCreationMethod) {
            this.builderCreationMethod = builderCreationMethod;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Task wrongCreate() {
            return new Task( this, "wrongCreate" );
        }

        public Task build() {
            return new Task( this, "build" );
        }

    }
}
