/*******************************************************************************
 *
 * Copyright (c) 2001-2020 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2020-04-15 14:50:20 
 *******************************************************************************/

package com.kaw.ms.gateway;

import java.io.UnsupportedEncodingException;

import org.springframework.util.Base64Utils;

/**
 * GatewayTest.
 *
 * @author haoyf (mailto: haoyf@primeton.com)
 */
public class GatewayTest {

    /**
     * @param args
     * @throws UnsupportedEncodingException 
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
         String b64 = Base64Utils.encodeToString("tiger".getBytes("UTF-8"));
         System.out.println(b64);
    }

}
