package com.capgemini.bldxxl.subdns.controllers;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.kv.model.GetValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SubDnsController {

    private int instanceValue;

    public SubDnsController() {
        instanceValue = new Random().nextInt(1000);
    }


    @RequestMapping("/value")
    public String value() {
        ConsulClient client = new ConsulClient("localhost");
        Response<GetValue> keyValueResponse = client.getKVValue("subdns-value");
        String decodedValue = keyValueResponse.getValue().getDecodedValue();
        return decodedValue;
    }

    @RequestMapping("/instanceValue")
    public String instanceValue() {
        return String.valueOf(instanceValue);
    }

}
