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

import java.util.*;

/**
 *
 * @author nghiatc
 * @since Aug 17, 2015
 */
public class MIMETypeUtil {
    
    public static MIMETypeUtil instance = new MIMETypeUtil();
    private Map<String, String> mapMT = new LinkedHashMap<String, String>();
    
    private MIMETypeUtil(){
        
    }
    
    public static MIMETypeUtil getInstance(){
        return instance;
    }
    
    public String getMIMETypeMedia(String ext){
        String rs = "video/mp4";
        if("mp4".equalsIgnoreCase(ext)){
            return "video/mp4";
        } else if("afl".equalsIgnoreCase(ext)){
            return "video/animaflex";
        } else if("asf".equalsIgnoreCase(ext)){
            return "video/x-ms-asf";
        } else if("asx".equalsIgnoreCase(ext)){
            return "video/x-ms-asf";
        } else if("asx".equalsIgnoreCase(ext)){
            return "video/x-ms-asf-plugin";
        } else if("avi".equalsIgnoreCase(ext)){
            return "video/avi";
        } else if("avs".equalsIgnoreCase(ext)){
            return "video/avs-video";
        } else if("dif".equalsIgnoreCase(ext)){
            return "video/x-dv";
        } else if("dl".equalsIgnoreCase(ext)){
            return "video/dl";
        } else if("dv".equalsIgnoreCase(ext)){
            return "video/x-dv";
        } else if("lsf".equalsIgnoreCase(ext)){
            return "video/x-la-asf";
        } else if("lsx".equalsIgnoreCase(ext)){
            return "video/x-la-asf";
        } else if("mov".equalsIgnoreCase(ext)){
            return "video/quicktime";
        } else if("movie".equalsIgnoreCase(ext)){
            return "video/x-sgi-movie";
        } else if("mp2".equalsIgnoreCase(ext)){
            return "video/mpeg";
        } else if("mpa".equalsIgnoreCase(ext)){
            return "video/mpeg";
        } else if("mpe".equalsIgnoreCase(ext)){
            return "video/mpeg";
        } else if("mpeg".equalsIgnoreCase(ext)){
            return "video/mpeg";
        } else if("mpg".equalsIgnoreCase(ext)){
            return "video/mpeg";
        } else if("mpv2".equalsIgnoreCase(ext)){
            return "video/mpeg";
        } else if("qt".equalsIgnoreCase(ext)){
            return "video/quicktime";
        } else if("flv".equalsIgnoreCase(ext)){
            return "video/quicktime";
        }
        
        if("mp3".equalsIgnoreCase(ext)){
            return "audio/mpeg";
        } else if("aif".equalsIgnoreCase(ext)){
            return "audio/x-aiff";
        } else if("aifc".equalsIgnoreCase(ext)){
            return "audio/x-aiff";
        } else if("aiff".equalsIgnoreCase(ext)){
            return "audio/x-aiff";
        } else if("au".equalsIgnoreCase(ext)){
            return "audio/basic";
        } else if("m3u".equalsIgnoreCase(ext)){
            return "audio/x-mpegurl";
        } else if("mid".equalsIgnoreCase(ext)){
            return "audio/mid";
        } else if("ra".equalsIgnoreCase(ext)){
            return "audio/x-pn-realaudio";
        } else if("ram".equalsIgnoreCase(ext)){
            return "audio/x-pn-realaudio";
        } else if("rmi".equalsIgnoreCase(ext)){
            return "audio/mid";
        } else if("snd".equalsIgnoreCase(ext)){
            return "audio/basic";
        } else if("wav".equalsIgnoreCase(ext)){
            return "audio/x-wav";
        } else if("ogg".equalsIgnoreCase(ext)){
            return "audio/ogg";
        }
        return rs;
    }
    
    public String getMIMETypeAudio(String ext){
        String rs = "audio/mpeg";
        if("mp3".equalsIgnoreCase(ext)){
            return "audio/mpeg";
        } else if("aif".equalsIgnoreCase(ext)){
            return "audio/x-aiff";
        } else if("aifc".equalsIgnoreCase(ext)){
            return "audio/x-aiff";
        } else if("aiff".equalsIgnoreCase(ext)){
            return "audio/x-aiff";
        } else if("au".equalsIgnoreCase(ext)){
            return "audio/basic";
        } else if("m3u".equalsIgnoreCase(ext)){
            return "audio/x-mpegurl";
        } else if("mid".equalsIgnoreCase(ext)){
            return "audio/mid";
        } else if("ra".equalsIgnoreCase(ext)){
            return "audio/x-pn-realaudio";
        } else if("ram".equalsIgnoreCase(ext)){
            return "audio/x-pn-realaudio";
        } else if("rmi".equalsIgnoreCase(ext)){
            return "audio/mid";
        } else if("snd".equalsIgnoreCase(ext)){
            return "audio/basic";
        } else if("wav".equalsIgnoreCase(ext)){
            return "audio/x-wav";
        } else if("ogg".equalsIgnoreCase(ext)){
            return "audio/ogg";
        }
        return rs;
    }
    
    public String getMIMETypeVideo(String ext){
        String rs = "video/mp4";
        if("mp4".equalsIgnoreCase(ext)){
            return "video/mp4";
        } else if("afl".equalsIgnoreCase(ext)){
            return "video/animaflex";
        } else if("asf".equalsIgnoreCase(ext)){
            return "video/x-ms-asf";
        } else if("asx".equalsIgnoreCase(ext)){
            return "video/x-ms-asf";
        } else if("asx".equalsIgnoreCase(ext)){
            return "video/x-ms-asf-plugin";
        } else if("avi".equalsIgnoreCase(ext)){
            return "video/avi";
        } else if("avs".equalsIgnoreCase(ext)){
            return "video/avs-video";
        } else if("dif".equalsIgnoreCase(ext)){
            return "video/x-dv";
        } else if("dl".equalsIgnoreCase(ext)){
            return "video/dl";
        } else if("dv".equalsIgnoreCase(ext)){
            return "video/x-dv";
        } else if("lsf".equalsIgnoreCase(ext)){
            return "video/x-la-asf";
        } else if("lsx".equalsIgnoreCase(ext)){
            return "video/x-la-asf";
        } else if("mov".equalsIgnoreCase(ext)){
            return "video/quicktime";
        } else if("movie".equalsIgnoreCase(ext)){
            return "video/x-sgi-movie";
        } else if("mp2".equalsIgnoreCase(ext)){
            return "video/mpeg";
        } else if("mpa".equalsIgnoreCase(ext)){
            return "video/mpeg";
        } else if("mpe".equalsIgnoreCase(ext)){
            return "video/mpeg";
        } else if("mpeg".equalsIgnoreCase(ext)){
            return "video/mpeg";
        } else if("mpg".equalsIgnoreCase(ext)){
            return "video/mpeg";
        } else if("mpv2".equalsIgnoreCase(ext)){
            return "video/mpeg";
        } else if("qt".equalsIgnoreCase(ext)){
            return "video/quicktime";
        } else if("flv".equalsIgnoreCase(ext)){
            return "video/quicktime";
        }
        return rs;
    }
    
    private String getMIMEType(String ext){
        String rs = "text/plain";
        if("x3d".equalsIgnoreCase(ext)){
            return "application/vnd.hzn-3d-crossword";
        } else if("3gp".equalsIgnoreCase(ext)){
            return "video/3gpp";
        } else if("3g2".equalsIgnoreCase(ext)){
            return "video/3gpp2";
        } else if("mseq".equalsIgnoreCase(ext)){
            return "application/vnd.mseq";
        } else if("pwn".equalsIgnoreCase(ext)){
            return "application/vnd.3m.post-it-notes";
        } else if("plb".equalsIgnoreCase(ext)){
            return "application/vnd.3gpp.pic-bw-large";
        } else if("psb".equalsIgnoreCase(ext)){
            return "application/vnd.3gpp.pic-bw-small";
        } else if("pvb".equalsIgnoreCase(ext)){
            return "application/vnd.3gpp.pic-bw-var";
        } else if("tcap".equalsIgnoreCase(ext)){
            return "application/vnd.3gpp2.tcap";
        } else if("7z".equalsIgnoreCase(ext)){
            return "application/x-7z-compressed";
        } else if("abw".equalsIgnoreCase(ext)){
            return "application/x-abiword";
        } else if("ace".equalsIgnoreCase(ext)){
            return "application/x-ace-compressed";
        } else if("acc".equalsIgnoreCase(ext)){
            return "application/vnd.americandynamics.acc";
        } else if("acu".equalsIgnoreCase(ext)){
            return "application/vnd.acucobol";
        } else if("".equalsIgnoreCase(ext)){
            return "";
        }
        return rs;
    }
    
    private String getMIMETypeImage(String ext){
        String rs = "image/jpeg";
        if("jpeg".equalsIgnoreCase(ext)){
            return "image/jpeg";
        } else if("jpg".equalsIgnoreCase(ext)){
            return "image/jpeg";
        } else if("png".equalsIgnoreCase(ext)){
            return "image/png";
        } else if("gif".equalsIgnoreCase(ext)){
            return "image/gif";
        } else if("cgm".equalsIgnoreCase(ext)){
            return "image/cgm";
        } else if("fits".equalsIgnoreCase(ext)){
            return "image/fits";
        } else if("g3fax".equalsIgnoreCase(ext)){
            return "image/g3fax";
        } else if("ief".equalsIgnoreCase(ext)){
            return "image/ief";
        } else if("jp2".equalsIgnoreCase(ext)){
            return "image/jp2";
        } else if("jpm".equalsIgnoreCase(ext)){
            return "image/jpm";
        } else if("jpx".equalsIgnoreCase(ext)){
            return "image/jpx";
        } else if("naplps".equalsIgnoreCase(ext)){
            return "image/naplps";
        } else if("btif".equalsIgnoreCase(ext) || "prs.btif".equalsIgnoreCase(ext)){
            return "image/prs.btif";
        } else if("pti".equalsIgnoreCase(ext) || "prs.pti".equalsIgnoreCase(ext)){
            return "image/prs.pti";
        } else if("t38".equalsIgnoreCase(ext)){
            return "image/t38";
        } else if("tiff".equalsIgnoreCase(ext)){
            return "image/tiff";
        } else if("tiff-fx".equalsIgnoreCase(ext)){
            return "image/tiff-fx";
        } else if("photoshop".equalsIgnoreCase(ext) || "adobe.photoshop".equalsIgnoreCase(ext) || "vnd.adobe.photoshop".equalsIgnoreCase(ext)){
            return "image/vnd.adobe.photoshop";
        } else if("inf2".equalsIgnoreCase(ext) || "cns.inf2".equalsIgnoreCase(ext) || "vnd.cns.inf2".equalsIgnoreCase(ext)){
            return "image/vnd.cns.inf2";
        } else if("djvu".equalsIgnoreCase(ext) || "vnd.djvu".equalsIgnoreCase(ext)){
            return "image/vnd.djvu";
        } else if("dwg".equalsIgnoreCase(ext) || "vnd.dwg".equalsIgnoreCase(ext)){
            return "image/vnd.dwg";
        } else if("dxf".equalsIgnoreCase(ext) || "vnd.dxf".equalsIgnoreCase(ext)){
            return "image/vnd.dxf";
        } else if("edmics-mmr".equalsIgnoreCase(ext) || "fujixerox.edmics-mmr".equalsIgnoreCase(ext) || "vnd.fujixerox.edmics-mmr".equalsIgnoreCase(ext)){
            return "image/vnd.fujixerox.edmics-mmr";
        } else if("edmics-rlc".equalsIgnoreCase(ext) || "fujixerox.edmics-rlc".equalsIgnoreCase(ext) || "vnd.fujixerox.edmics-rlc".equalsIgnoreCase(ext)){
            return "image/vnd.fujixerox.edmics-rlc";
        } else if("pgb".equalsIgnoreCase(ext) || "globalgraphics.pgb".equalsIgnoreCase(ext) || "vnd.globalgraphics.pgb".equalsIgnoreCase(ext)){
            return "image/vnd.globalgraphics.pgb";
        } else if("icon".equalsIgnoreCase(ext) || "microsoft.icon".equalsIgnoreCase(ext) || "vnd.microsoft.icon".equalsIgnoreCase(ext)){
            return "image/vnd.microsoft.icon";
        } else if("mix".equalsIgnoreCase(ext) || "vnd.mix".equalsIgnoreCase(ext)){
            return "image/vnd.mix";
        } else if("ms-modi".equalsIgnoreCase(ext) || "vnd.ms-modi".equalsIgnoreCase(ext)){
            return "image/vnd.ms-modi";
        } else if("net-fpx".equalsIgnoreCase(ext) || "vnd.net-fpx".equalsIgnoreCase(ext)){
            return "image/vnd.net-fpx";
        } else if("sealed.png".equalsIgnoreCase(ext) || "vnd.sealed.png".equalsIgnoreCase(ext)){
            return "image/vnd.sealed.png";
        } else if("softseal.gif".equalsIgnoreCase(ext) || "sealedmedia.softseal.gif".equalsIgnoreCase(ext) || "vnd.sealedmedia.softseal.gif".equalsIgnoreCase(ext)){
            return "image/vnd.sealedmedia.softseal.gif";
        } else if("softseal.jpg".equalsIgnoreCase(ext) || "sealedmedia.softseal.jpg".equalsIgnoreCase(ext) || "vnd.sealedmedia.softseal.jpg".equalsIgnoreCase(ext)){
            return "image/vnd.sealedmedia.softseal.jpg";
        } else if("svf".equalsIgnoreCase(ext)  || "vnd.svf".equalsIgnoreCase(ext)){
            return "image/vnd.svf";
        } else if("wbmp".equalsIgnoreCase(ext) || "wap.wbmp".equalsIgnoreCase(ext) || "vnd.wap.wbmp".equalsIgnoreCase(ext)){
            return "image/vnd.wap.wbmp";
        } else if("xiff".equalsIgnoreCase(ext) || "vnd.xiff".equalsIgnoreCase(ext)){
            return "image/vnd.xiff";
        }
        return rs;
    }
    
    
}
