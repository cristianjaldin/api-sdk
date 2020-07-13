# User SDK

User-sdk is a Java library for [User Service](https://github.com/cristianjaldin/user-service).

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
sdk.user.service.scheme.url=http
sdk.user.service.base.url=localhost:8090
sdk.user.service.path=/api/v1/users
```

## Methods

UserSdk have four methods:

```java
UserDto get(String id);
UserDto add(UserCreateDto userCreateDto);
UserDto update(String id, UserUpdateDto userUpdateDto);
List<UserDto> getAll();
void delete(String id);
```


## Usage

Example of use ...

```java


```
