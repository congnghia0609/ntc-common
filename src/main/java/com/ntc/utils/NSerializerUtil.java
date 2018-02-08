/*
 * Copyright 2015 nghiatc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ntc.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nghiatc
 * @since Aug 20, 2015
 */
public class NSerializerUtil {
    private static final Logger logger = LoggerFactory.getLogger(NSerializerUtil.class);
    
    public byte[] serializeBool(boolean b) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bos);
            dos.writeBoolean(b);
            byte[] bb = bos.toByteArray();
            dos.close();
            bos.close();
            return bb;
        } catch (Exception ex) {
            logger.error("MSerializerUtil.serializeBool ", ex);
        }
        return null;
    }
    
    public boolean deserializeBool(byte[] b) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(b, 0, b.length);
            DataInputStream dis = new DataInputStream(bis);
            boolean rs = dis.readBoolean();
            dis.close();
            bis.close();
            return rs;
        } catch (Exception ex) {
            logger.error("MSerializerUtil.deserializeBool ", ex);
        }
        return false;
    }
    
    public byte[] serializeInt(int i) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bos);
            dos.writeInt(i);
            byte[] bb = bos.toByteArray();
            dos.close();
            bos.close();
            return bb;
        } catch (Exception ex) {
            logger.error("MSerializerUtil.serializeInt ", ex);
        }
        return null;
    }
    
    public int deserializeInt(byte[] b) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(b, 0, b.length);
            DataInputStream dis = new DataInputStream(bis);
            int rs = dis.readInt();
            dis.close();
            bis.close();
            return rs;
        } catch (Exception ex) {
            logger.error("MSerializerUtil.deserializeInt ", ex);
        }
        return 0;
    }
    
    public byte[] serializeLong(long l) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bos);
            dos.writeLong(l);
            byte[] bb = bos.toByteArray();
            dos.close();
            bos.close();
            return bb;
        } catch (Exception ex) {
            logger.error("MSerializerUtil.serializeLong ", ex);
        }
        return null;
    }
    
    public long deserializeLong(byte[] b) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(b, 0, b.length);
            DataInputStream dis = new DataInputStream(bis);
            long rs = dis.readLong();
            dis.close();
            bis.close();
            return rs;
        } catch (Exception ex) {
            logger.error("MSerializerUtil.deserializeLong ", ex);
        }
        return 0;
    }
    
    public byte[] serializeFloat(float f) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bos);
            dos.writeFloat(f);
            byte[] bb = bos.toByteArray();
            dos.close();
            bos.close();
            return bb;
        } catch (Exception ex) {
            logger.error("MSerializerUtil.serializeFloat ", ex);
        }
        return null;
    }
    
    public float deserializeFloat(byte[] b) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(b, 0, b.length);
            DataInputStream dis = new DataInputStream(bis);
            float rs = dis.readFloat();
            dis.close();
            bis.close();
            return rs;
        } catch (Exception ex) {
            logger.error("MSerializerUtil.deserializeFloat ", ex);
        }
        return 0;
    }
    
    public byte[] serializeDouble(double d) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bos);
            dos.writeDouble(d);
            byte[] bb = bos.toByteArray();
            dos.close();
            bos.close();
            return bb;
        } catch (Exception ex) {
            logger.error("MSerializerUtil.serializeDouble ", ex);
        }
        return null;
    }
    
    public double deserializeDouble(byte[] b) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(b, 0, b.length);
            DataInputStream dis = new DataInputStream(bis);
            double rs = dis.readDouble();
            dis.close();
            bis.close();
            return rs;
        } catch (Exception ex) {
            logger.error("MSerializerUtil.deserializeDouble ", ex);
        }
        return 0;
    }
    
    public byte[] serializeString(String s) {
        try {
            return s.getBytes();
        } catch (Exception ex) {
            logger.error("MSerializerUtil.serializeString ", ex);
        }
        return null;
    }
    
    public String deserializeString(byte[] s) {
        try {
            return new String(s);
        } catch (Exception ex) {
            logger.error("MSerializerUtil.deserializeString ", ex);
        }
        return null;
    }

    
//    public static void main(String[] args) {
//        boolean b1 = true;
//        System.out.println("b1: " + b1);
//        byte[] bb = serializeBool(b1);
//        boolean b2 = deserializeBool(bb);
//        System.out.println("b2: " + b2);
//        
//        int i1 = 10;
//        System.out.println("i1: " + i1);
//        byte[] ii = serializeInt(i1);
//        int i2 = deserializeInt(ii);
//        System.out.println("i2: " + i2);
//        
//        long l1 = 11;
//        System.out.println("l1: " + l1);
//        byte[] ll = serializeLong(l1);
//        long l2 = deserializeLong(ll);
//        System.out.println("l2: " + l2);
//        
//        float f1 = 12;
//        System.out.println("f1: " + f1);
//        byte[] ff = serializeFloat(f1);
//        float f2 = deserializeFloat(ff);
//        System.out.println("f2: " + f2);
//        
//        double d1 = 13;
//        System.out.println("d1: " + d1);
//        byte[] dd = serializeDouble(d1);
//        double d2 = deserializeDouble(dd);
//        System.out.println("d2: " + d2);
//        
//        String s1 = "nghiatc";
//        System.out.println("s1: " + s1);
//        byte[] ss = serializeString(s1);
//        String s2 = deserializeString(ss);
//        System.out.println("s2: " + s2);
//        
//    }
    
    
}
