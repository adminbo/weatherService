package com.zjkj.wxy.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zjkj.wxy.core.utils.JpushUtils;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class JpushTest extends JpushUtils{
	 protected static final Logger LOG = LoggerFactory.getLogger(JpushTest.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
        PushPayload payload = buildPushObject_all_all_alert();
        try {
            PushResult result = jpushClient.sendPush(payload);
            int status = result.getResponseCode();
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            LOG.error("Sendno: " + payload.getSendno());

        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            LOG.error("Sendno: " + payload.getSendno());
        }
	}
	/*
	 * 进行推送的关键在于构建一个 PushPayload 对象。以下示例一般的构建对象的用法。
	 */
	//所有平台，推送目标是别名为 "alias1"，通知内容为 ALERT。
    public static PushPayload buildPushObject_all_alias_alert() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias("alias"))
                .setNotification(Notification.alert(ALERT))
                .build();
    }
    //	快捷地构建推送对象：所有平台，所有设备，内容为 ALERT 的通知。
    public static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll(ALERT);
    }
    //平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE。
    public static PushPayload buildPushObject_android_tag_alertWithTitle() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.android(ALERT, "title", null))
                .build();
    }
}
