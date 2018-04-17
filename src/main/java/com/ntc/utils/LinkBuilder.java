package com.ntc.utils;

import com.ntc.configer.NConfig;


public class LinkBuilder {
	public static final String _defaultAvatar = "https://example.com/images/noavatar.png";
	public static final String _defaultBizAvatar = "https://example.com/images/bar_noavatar.png";
	public static final String _defaultCover = "https://example.com/images/nocover.jpg";
	public static final String _staticDomain = NConfig.getConfig().getString("static.domain", "dev.example.com");

	public static String buildAvatarLink(int uid, int avtVer, long tmpId, int size) {
		//String noiseString = NoiseIdUtils.encryptString(System.currentTimeMillis() + "");
		String link = _defaultAvatar;
		if(avtVer > 0) {
			String noiseData = NoiseIdUtils.encryptString(uid + "," + avtVer + "," + tmpId);
			link = "http://" + _staticDomain + "/loop/img/avt/" + noiseData;
		}
		return link;
	}
	
	public static String buildBizAvatarLink(int uid, int avtVer, long tmpId, int size) {
		//String noiseString = NoiseIdUtils.encryptString(System.currentTimeMillis() + "");
		String link = _defaultBizAvatar;
		if(avtVer > 0) {
			String noiseData = NoiseIdUtils.encryptString(uid + "," + avtVer + "," + tmpId);
			link = "http://" + _staticDomain + "/loop/img/avt/" + noiseData;
		}
		return link;
	}

	public static String buildCoverLink(int uid, int covVer, long tmpId, int size) {
		//String noiseString = NoiseIdUtils.encryptString(System.currentTimeMillis() + "");
		String link = _defaultCover;
		if(covVer > 0) {
			String noiseData = NoiseIdUtils.encryptString(uid + "," + covVer + "," + tmpId);
			link = "http://" + _staticDomain + "/loop/img/cov/" + noiseData;
		}
		return link;
	}

	public static String buildChatLink(int uid, long tmpId, int size) {
		//String noiseString = NoiseIdUtils.encryptString(System.currentTimeMillis() + "");
		String noiseData = NoiseIdUtils.encryptString(tmpId + "," + uid + "," + System.currentTimeMillis());
		String link = "http://" + _staticDomain + "/loop/img/c/" + noiseData;

		return link;
	}

	public static String buildVTemplateLink(int id, int tmlVer, int size) {
		String noiseData = NoiseIdUtils.encryptString(id + "," + tmlVer);
		String link = "http://" + _staticDomain + "/loop/img/tml/v/" + noiseData;
		return link;
	}

	public static String buildHTemplateLink(int id, int tmlVer, int size) {
		String noiseData = NoiseIdUtils.encryptString(id + "," + tmlVer);
		String link = "http://" + _staticDomain + "/loop/img/tml/h/" + noiseData;
		return link;
	}
}
