package com.icbc.sh.icbdjavaee.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pujuan
 *
 */
@Service
public class IcbcService {

    public List<String> doBusiness(String args){
        StringBuilder buf = new StringBuilder();
        buf.append("123")
           .append("456")
           .append("789");
        return null;
    }
}
