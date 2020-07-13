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
List<UserDto> getAll();
UserDto get(String id);
UserDto add(UserCreateDto userCreateDto);
UserDto update(String id, UserUpdateDto userUpdateDto);
void delete(String id);
```


## Usage

Example of use get All ...

```java
@Autowired
private UserSdk userSdk;
...

List<UserDto> users = userSdk.getAll();

```


Example of use get by id ...

```java
@Autowired
private UserSdk userSdk;
...

UserDto user = userSdk.get("5f0213b863993b271b08a54b");

```

Example add new User ...

```java
@Autowired
private UserSdk userSdk;
...

UserCreateDto userCreateDto = new UserCreateDto();
userCreateDto.setName("Cristian");
userCreateDto.setSurname("Jaldin");
userCreateDto.setUsername("cjaldin");
userCreateDto.setPassword("1234");
userCreateDto.setRoles(Arrays.asList("ADMIN"));

UserDto userCreated = userSdk.add(userCreateDto);

```


Example update User ...

```java
@Autowired
private UserSdk userSdk;
...


```

Example delete User by id ...

```java
@Autowired
private UserSdk userSdk;
...

userSdk.delete("5f0213b863993b271b08a54b");

```



