# User SDK

User-sdk is a Java library.

# Related projects

- [User Service](https://github.com/cristianjaldin/user-service)
- [User DTO](https://github.com/cristianjaldin/user-dto)
- [User Consumer](https://github.com/cristianjaldin/user-consumer)

## Installation

You have download the repo from the application and run a **mvn install**.

Add the following dependency in your project:

```xml
<dependency>
    <groupId>com.example.demo.sdk</groupId>
    <artifactId>user</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## Configuration

Create the following configuration class **ConfigUserSdk** in your project with @EnableUserSdk

```java

import org.springframework.context.annotation.Configuration;
import com.example.demo.sdk.user.configSDK.EnableUserSdk;

@Configuration
@EnableUserSdk
public class ConfigUserSdk {

}

```

Then configure the following parameters in your configuration file **application.properties**:

```java
sdk.user.service.base.url=localhost:8090
sdk.user.service.path=/api/v1/users
sdk.user.service.scheme.url=http
```

**Warning:**

## Methods

There is a service with four methods. The first one 

```java



```


## Usage

Example of use ...

```java


```
