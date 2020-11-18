# Spring Cloud

This is the project for the Spring Cloud demo. 


## Build

To build it, execute the following commands in the main-dns project folder:

```
gradlew clean build
```
```
docker build . -t spring-cloud:local
```

## Run

Make sure you do not have a docker stack named `bldxxl` running.

Execute the following command to deploy the stack:

```
docker stack deploy --compose-file compose-spring-cloud.yml bldxxl
```

The consul instance can be found at:

```
http://localhost:8500/ui
```

The endpoints for the spring-cloud application can be found at:

```
http://localhost:8080/
http://localhost:8080/services
http://localhost:8080/consulvalue
```

The value of the key `consul-value` does not need to be set, but will live update the value retrieved on the `/consulvalue` endpoint.
