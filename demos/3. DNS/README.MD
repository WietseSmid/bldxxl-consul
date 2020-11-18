# DNS

This is the project for the DNS demo. 


## Build

To build it, execute the following commands in the main-dns project folder:

```
gradlew clean build
```
```
docker build . -t main-dns:local
```

And execute the following commands in the sub-dns project folder:

```
gradlew clean build
```
```
docker build . -t sub-dns:local
```

## Run

Make sure you do not have a docker stack named `bldxxl` running.

Execute the following command to deploy the stack:

```
docker stack deploy --compose-file compose-dns.yml bldxxl
```

The consul instance can be found at:

```
http://localhost:8500/ui
```

The endpoints for the main-dns application can be found at:

```
http://localhost:8080/value
http://localhost:8080/values
```

Do not forget to set a `sub-url` key with a value of `sub-dns.service.consul` in the consul KV store.
And also set the value of the `subdns-value` key to something.
