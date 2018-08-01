package com.biyouche.controller.apply;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biyouche.annotation.CurrentUser;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.apply.InsuranceOrder;
import com.biyouche.domain.apply.model.VipInsuranceModel;
import com.biyouche.domain.user.User;
import com.biyouche.exception.BussinessException;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.VIPInsuranceService;
import com.biyouche.service.InsuranceOrderService;
import com.biyouche.service.UserService;
import com.biyouche.utils.ValidatorUtils;

/**
 * 学车保险
 * @author lgh
 *
 */
@RequestMapping("/insurance")
@RestController
public class InsuranceController extends BaseController {

	private final static Logger LOGGER = LoggerFactory.getLogger(InsuranceController.class);
	
	@Autowired
	private VIPInsuranceService insuranceService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private InsuranceOrderService insuranceOrderService;
	
	/**
	 * 学车保险初始化
	 * @author lgh
	 * @return
	 */
	@GetMapping("/toShowInsurance")
    public ResponseObject toShowInsurance(@CurrentUser Integer userId) {
		try {
        	
			if( ValidatorUtils.isNull(userId) ) {
				throw new BussinessException(210003);
			}
			
        	LOGGER.info("学车保险初始化...... ");
        	
        	//保险套餐
        	
        	List<VipInsuranceModel> vipInsurance = insuranceService.vipInsuranceList();

        	//信息填写

        	User user = userService.selectUserById(userId);

    		String loginMobile = user.getLoginMobile();
    		String encryptMobile = ValidatorUtils.mobileEncrypt(loginMobile);

    		//返回结果

    		Map<String,Object> result = new LinkedHashMap<String, Object>();
    		result.put("vipInsurance", vipInsurance);
    		result.put("loginMobile", loginMobile);
    		result.put("encryptMobile", encryptMobile);

			return dealSuccess(result);
		} catch (Exception e) {
			return dealException(e);
		}
	}

	/**
	 * 学车保险生成订单
	 * @author lgh
	 * @return
	 */
	@GetMapping("/doInsuranceOrder")
    public ResponseObject doInsuranceOrder(@CurrentUser Integer userId, InsuranceOrder order) {
		try {

			if( ValidatorUtils.isNull(userId) ) {
				throw new BussinessException(210003);
			}

			order.setUserId(userId);
			LOGGER.info("学车保险生成订单: " + order.toString());
			insuranceOrderService.doInsuranceOrder(order);

			return dealSuccess();
		} catch (Exception e) {
			return dealException(e);
		}
	}

	/**
	 * 学车保险异步回调
	 * @author lgh
	 * @return
	 */
	@GetMapping("/insuranceOrderNotify")
    public ResponseObject insuranceOrderNotify() {
		try {

			LOGGER.info("学车保险异步回调 ...... ");
			insuranceOrderService.insuranceOrderNotify();

			return dealSuccess();
		} catch (Exception e) {
			return dealException(e);
		}
	}

	/**
	 * 学车保险订单详情
	 * @author lgh
	 * @return
	 */
	@GetMapping("/insuranceOrderDetail")
    public ResponseObject InsuranceOrderDetail(@CurrentUser Integer userId) {
		try {

			if( ValidatorUtils.isNull(userId) ) {
				throw new BussinessException(210003);
			}

			LOGGER.info("学车保险订单详情: userId=" + userId);
			insuranceOrderService.insuranceOrderDetail(userId);

			return dealSuccess();
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	
}
