/*
 * Copyright (c) 2020 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclipse.microprofile.config.inject;


import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

/**
 * <p>
 * Retrieve a number of related configuration properties with the specified prefix into a property class.
 * <pre>
 * &#064;ConfigProperties(prefix="server")
 * public class MyServer {
 *      public String host; //maps the property name server.host
 *      public int port;    //maps to the property name server.port
 *      private String context; //maps to the property name server.context
 *      public &#064;ConfigProperty(name="old.location")
 *      String location; //maps to the property name server.old.location
 *      public String getContext() {
 *          return context;
 *      }
 * }
 * </pre>
 *
 * 
 *
 * @since 2.0
 * @author <a href="mailto:emijiang@uk.ibm.com">Emily Jiang</a>
 * 
 */

@Target({METHOD, FIELD, PARAMETER, TYPE})
@Retention(RUNTIME)
@Documented
@Qualifier
public @interface ConfigProperties {

    /**
     * The prefix of the configuration properties
     * @return the configuration property prefix
     */
    @Nonbinding
    String prefix() default "";
}
