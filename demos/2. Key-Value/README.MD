# Key-Value

This is the project for the Key-Value demo. 


## Build

To build it, execute the following commands in the key-value project folder:

```
gradlew clean build
```
```
docker build . -t key-value:local
```

## Run

Make sure you do not have a docker stack named `bldxxl` running.

Execute the following command to deploy the stack:

```
docker stack deploy --compose-file compose-key-value.yml bldxxl
```

The consul instance can be found at:

```
http://localhost:8500/ui
```

The endpoints for the key-value application can be found at:

```
http://localhost:8080/services
http://localhost:8080/value
http://localhost:8080/updatevalue
```

Do not forget to set a `testkey` key with a numerical value in the consul KV store.
