# Hello World

This is the project for the Hello World demo. 

## Build

To build it, execute the following commands in the hello-world project folder:

```
gradlew clean build
```
```
docker build . -t hello-world:local
```

## Run

Make sure you do not have a docker stack named `bldxxl` running.

Execute the following command to deploy the stack:

```
docker stack deploy --compose-file compose-hello-world.yml bldxxl
```

The consul instance can be found at:

```
http://localhost:8500/ui
```

The endpoint for the hello world application can be found at:

```
http://localhost:8080/
```