## Welcome to MicroProfile Config

image:https://badges.gitter.im/eclipse/microprofile-config.svg[link="https://gitter.im/eclipse/microprofile-config"]
image:https://img.shields.io/maven-central/v/org.eclipse.microprofile.config/microprofile-config-api.svg[link="http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22org.eclipse.microprofile.config%22%20AND%20a%3A%22microprofile-config-api%22"]
image:https://javadoc.io/badge/org.eclipse.microprofile.config/microprofile-config-api.svg[ link="https://javadoc.io/doc/org.eclipse.microprofile.config/microprofile-config-api"]

Released versions:
Config 1.4: [Javadocs](https://download.eclipse.org/microprofile/microprofile-config-1.4/apidocs/) | [Spec PDF](https://download.eclipse.org/microprofile/microprofile-config-1.4/microprofile-config-spec.pdf) |[Spec html](https://download.eclipse.org/microprofile/microprofile-config-1.4/microprofile-config-spec.html)

# Configuration for MicroProfile

MicroProfile Config Feature

== Rationale

The majority of applications need to be configured based on a running environment.
It must be possible to modify configuration data from outside an application so that the application itself does not need to be repackaged.

The configuration data can come from different locations and in different formats (e.g. system properties, system environment variables, .properties, .xml, datasource).
We call these config locations ConfigSources.
If the same property is defined in multiple ConfigSources, we apply a policy to specify which one of the values will effectively be used.

Under some circumstances, some data sources may change dynamically.
The changed values should be fed into the client without the need for restarting the application.
This requirement is particularly important for microservices running in a cloud environment.
The MicroProfile Config approach allows to pick up configured values immediately after they got changed.

== Design

The current configuration of an application can be accessed via _ConfigProvider#getConfig()_.

A _Config_ consists of the information collected from the registered _org.eclipse.microprofile.config.spi.ConfigSource_ s.
These _ConfigSource_ s get sorted according to their _ordinal_.
That way it is possible to overwrite configuration with lower importance from outside.

By default there are 3 default ConfigSources:

* _System.getProperties()_ (ordinal=400)
* _System.getenv()_ (ordinal=300)
* all _META-INF/microprofile-config.properties_ files on the ClassPath.
(default ordinal=100, separately configurable via a config_ordinal property inside each file)

Therefore, the default values can be specified in the above files packaged with the application and the value can be overwritten later for each deployment. A higher ordinal number takes precedence over a lower number.

== Custom ConfigSources

It is possible to write and register a custom _ConfigSources_.
An example would be a ConfigSource which gets the configured values from a shared database table in a cluster.

== Building

The whole MicroProfile config project can be built via Apache Maven

	$> mvn clean install

== Contributing

Do you want to contribute to this project? link:CONTRIBUTING.adoc[Find out how you can help here].

