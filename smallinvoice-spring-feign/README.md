# Small Invoice Client API for Spring


## Generating the Spring Feign API

```sh
# Generate the source files
$ mvn clean compile
```

### Deploy to your own artifacts sever
Currently, the Smallinvoice Spring Client is not yet available on Maven Central (or something similar).
That's why you manually need to deploy it to your own artifacts hosting solution.

```
# You might have to adjust your ~/.m2/settings.xml or add a <distributionManagement> section to the pom.xml
$ mvn deploy
```

## Using the Java API
Once deployed to a repository, add the following dependency:

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.example</groupId>
  <artifactId>smallinvoice-spring-feign</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.example:smallinvoice-spring-feign:1.0.0"
```

## Configuring the API

Access to the Small Invoice Backend with `Client credentials`.

[https://api.smallinvoice.com/v2/doc/?action=auth-workflow](https://api.smallinvoice.com/v2/doc/?action=auth-workflow)

Put the configuration to the application.yml file.

```yaml
smallinvoiceapireference:
  security:
    oauth:
      client-id: ${SMALLINVOICE_CLIENT_ID:T1ZNOB7EO20G3OIB5JR4}
      client-secret: ${SMALLINVOICE_CLIENT_SECRET:3FeuIQslNvr5GuDELXC1Qo/8H3lCCvnInGVFbwN3lhrLANYn9U1p1oP5Sz9wkhGsG9O25igj8Az6dBb7}
      access-token-url: ${SMALLINVOICE_ACCESS-TOKEN-URL:https://api.smallinvoice.com/v2/auth/access-tokens}
      scope:
        - profile
        - contact
        - letter
        - catalog 
        - invoice
        - offer 
        - delivery_note 
        - order_confirmation 
        - project 
        - cost_unit 
        - working_hours 
        - activity 
        - effort 
        - contact_reminder 
        - configuration
```

.. or alternatively to the `application.properties` file.

```properties
smallinvoiceapireference.security.oauth.client-id=${SMALLINVOICE_CLIENT_ID:T1ZNOB7EO20G3OIB5JR4}
smallinvoiceapireference.security.oauth.client-secret=${SMALLINVOICE_CLIENT_SECRET:3FeuIQslNvr5GuDELXC1Qo/8H3lCCvnInGVFbwN3lhrLANYn9U1p1oP5Sz9wkhGsG9O25igj8Az6dBb7}
smallinvoiceapireference.security.oauth.scope=${SMALLINVOICE_SCOPE:profile contact letter catalog invoice offer delivery_note order_confirmation project cost_unit working_hours activity effort contact_reminder configuration}
smallinvoiceapireference.security.oauth.access-token-url=${SMALLINVOICE_ACCESS-TOKEN-URL:https://api.smallinvoice.com/v2/auth/access-tokens}
```




