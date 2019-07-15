package com.message.sms;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.message.util.ReturnMsgCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName: SMSController
 * @Description: 短信发送
 * @author shuyu.wang
 * @date 2017年11月10日 下午3:09:15
 * @version V1.0
 */
@RestController
@Slf4j
public class SMSController {
	/**
	 * {"msg":"","phone":"手机号码"}
	 * @param json
	 * @return
	 * {
	 *     "msg": "操作成功",
	 *     "code": 0,
	 *     "time": "2019-04-23 10:06:50"
	 * }
	 */
	@PostMapping("ganinfo/sendMessage")
	public JSONObject sendKaiLiDeMsg(@RequestBody String json) {
		JSONObject resObj=new JSONObject();
		try {
			JSONObject jsonObj=JSONUtil.parseObj(json);
			if(jsonObj.containsKey("msg") && jsonObj.getStr("msg").length()>0 && jsonObj.containsKey("phone") && jsonObj.getStr("phone").length()>0){
				String phones=jsonObj.getStr("phone");
				String msg=jsonObj.getStr("msg");
					MessageDate messageDate = new MessageDate();
					messageDate.setSpnumber("09913079910");//发送号码
					Map<String,String> phonemap = new HashMap<>();
					phonemap.put("1",phones);
					messageDate.setNumber(phonemap);//接收号码
					messageDate.setSpnumpass("09913079910");//发送密码
					messageDate.setMsg(msg);//发送内容
					String datetime = EncryptUtil.computeByDatePhp();
					SMSRequest request = new SMSRequest();
					request.setAccess_token("81e9a502fb4d77964f00629a2d535863");
					request.setState("11");
					request.setTimestamp(datetime);
					request.setSign(EncryptUtil.signByGenerateToString(request.getAccess_token(), request.getTimestamp(), messageDate.getSpnumber(), request.getState(), "ce7af9e5edbad0a964f2aa6a19a18cb8"));
					request.setMessageDate(messageDate);
					String post = HttpUtil.post(ConstantConfigUtil.getSendMessageUrl(), JSONUtil.toJsonStr(request));
					log.info(DateUtil.now()+"手机号码:"+phones+"--发送信息为："+msg+"---德立凯短信返回信息:"+post);
					JSONObject jsonObject = JSONUtil.parseObj(post);
					String res_code = (String)jsonObject.get("res_code");
					if ("0000000000".equals(res_code)) {
						resObj.put(ReturnMsgCode.code,ReturnMsgCode.rightCode);
						resObj.put(ReturnMsgCode.msg,ReturnMsgCode.rightMsg);
						resObj.put(ReturnMsgCode.time, DateUtil.now());
						log.info(DateUtil.now()+"手机号码:"+phones+"短信发送成功!");
					}else {
						resObj.put(ReturnMsgCode.code,ReturnMsgCode.errCode);
						resObj.put(ReturnMsgCode.msg,ReturnMsgCode.errMsg);
						resObj.put(ReturnMsgCode.time, DateUtil.now());
						log.info(DateUtil.now()+"手机号码:"+phones+"短信发送失败!");
					}
			}else{
				resObj.put(ReturnMsgCode.code,ReturnMsgCode.illegalCode);
				resObj.put(ReturnMsgCode.msg,ReturnMsgCode.illegalMsg);
				resObj.put(ReturnMsgCode.time, DateUtil.now());
			}
		} catch (Exception e) {
			e.printStackTrace();
			resObj.put(ReturnMsgCode.code,ReturnMsgCode.errCode);
			resObj.put(ReturnMsgCode.msg,ReturnMsgCode.errMsg);
			resObj.put(ReturnMsgCode.time, DateUtil.now());
		}
		return resObj;
	}







}
