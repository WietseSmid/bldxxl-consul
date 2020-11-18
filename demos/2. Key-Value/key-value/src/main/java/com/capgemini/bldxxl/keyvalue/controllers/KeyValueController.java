package com.capgemini.bldxxl.keyvalue.controllers;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.kv.model.GetValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyValueController {

    @RequestMapping("/services")
    public String services() {
        ConsulClient client = new ConsulClient("localhost");
        return client.getAgentServices().getValue().keySet().toString();
    }

    @RequestMapping("/value")
    public String value() {
        ConsulClient client = new ConsulClient("localhost");
        Response<GetValue> keyValueResponse = client.getKVValue("testkey");
        String decodedValue = keyValueResponse.getValue().getDecodedValue();
        return decodedValue;
    }

    @RequestMapping("/updatevalue")
    public int updateKeyValue() {
        ConsulClient client = new ConsulClient("localhost");
        Response<GetValue> keyValueResponse = client.getKVValue("testkey");
        String decodedValue = keyValueResponse.getValue().getDecodedValue();
        int newValue = Integer.parseInt(decodedValue) + 1;
        client.setKVValue("testkey", String.valueOf(newValue));
        return newValue;
    }
}
