package com.capgemini.bldxxl.maindns.controllers;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.kv.model.GetValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class MainDnsController {

    @RequestMapping("/value")
    public String value() {
        ConsulClient client = new ConsulClient("localhost");
        Response<GetValue> keyValueResponse = client.getKVValue("sub-url");
        String subUrl = keyValueResponse.getValue().getDecodedValue();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://"+subUrl + ":8080/value", String.class);

        return "Got String from sub: " + response.getBody() ;
    }

    @RequestMapping("/values")
    public String values() throws InterruptedException, UnknownHostException {
        ConsulClient client = new ConsulClient("localhost");
        Response<GetValue> keyValueResponse = client.getKVValue("sub-url");
        String subUrl = keyValueResponse.getValue().getDecodedValue();

        String values = "";

        for(int i = 0; i < 10; i++) {
            InetAddress address = InetAddress.getByName(subUrl);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity("http://" + address.getHostAddress() + ":8080/instanceValue", String.class);
            values += response.getBody() + "<br/>";
        }

        return values;
    }

}
