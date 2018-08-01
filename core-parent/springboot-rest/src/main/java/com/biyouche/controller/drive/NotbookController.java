package com.biyouche.controller.drive;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biyouche.controller.BaseController;
import com.biyouche.domain.drive.vo.DriveSecretDetail;
import com.biyouche.domain.drive.vo.DriveSecretVo;
import com.biyouche.domain.drive.vo.NotbookAfterDetail;
import com.biyouche.domain.drive.vo.NotbookAfterVo;
import com.biyouche.domain.drive.vo.NotbookDetail;
import com.biyouche.domain.drive.vo.NotbookIco;
import com.biyouche.domain.drive.vo.SkillsDetail;
import com.biyouche.domain.drive.vo.SkillsIco;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.DriveSecretService;
import com.biyouche.service.DriveSkillService;
import com.biyouche.service.NotbokService;
import com.biyouche.service.NotbookAfterService;

/**
 * 拿本栏目
 * @author hucong
 *
 */
@RestController
@RequestMapping("/notbook")
public class NotbookController extends BaseController{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(NotbookController.class);
	
	@Autowired
	private NotbokService notbokService;
	
	@Autowired
	private NotbookAfterService notbookAfterService;
	
	@Autowired
	private DriveSecretService driveSecretService;
	
	@Autowired
	private DriveSkillService driveSkillService;
	
	 /**
     * 拿本图标列表
     * @return
     * @author hucong
     */
    @PostMapping("icoList")
    public ResponseObject icoList() {
        try {
        	LOGGER.info("请求拿本栏目接口");
        	ResponseObject dealSuccess = dealSuccess();
        	List<NotbookIco> ico_list = notbokService.selectAllIco();
        	dealSuccess.content.put("ico_list", ico_list);
        	List<NotbookAfterVo> notbookAfter_list = notbookAfterService.selectAll();
        	dealSuccess.content.put("notbookAfter_list", notbookAfter_list);
            return dealSuccess;
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 图标详情
     * @return
     * @author hucong
     */
    @PostMapping("icoDetail")
    public ResponseObject icoDetail(Integer ico_id) {
        try {
        	LOGGER.info("请求拿本栏目详情");
        	ResponseObject dealSuccess = dealSuccess();
        	NotbookDetail ico_detail = notbokService.notbookDetail(ico_id);
        	dealSuccess.content.put("ico_detail", ico_detail);
            return dealSuccess;
        } catch (Exception e) {
            return dealException(e);
        }
    }
     
    
    /**
     * 拿本以后详情
     * @return
     * @author hucong
     */
    @PostMapping("notbookAfterDetail")
    public ResponseObject notbookAfterDetail(Integer bookAfter_id) {
        try {
        	LOGGER.info("请求拿本以后详情");
        	ResponseObject dealSuccess = dealSuccess();
        	NotbookAfterDetail notbookAfter_detail = notbookAfterService.notbookAfterDetail(bookAfter_id);
        	dealSuccess.content.put("notbookAfter_detail", notbookAfter_detail);
            return dealSuccess;
        } catch (Exception e) {
            return dealException(e);
        }
    }
    
    
    
    /**
     * 驾考秘笈列表
     * @return
     * @author hucong
     */
    @PostMapping("secretList")
    public ResponseObject secretList() {
        try {
        	LOGGER.info("驾考秘笈列表");
        	ResponseObject dealSuccess = dealSuccess();
        	List<DriveSecretVo> secret_List = driveSecretService.driveSecretList();
        	dealSuccess.content.put("secret_List", secret_List);
            return dealSuccess;
        } catch (Exception e) {
            return dealException(e);
        }
    }
    
    
    /**
     * 驾考秘笈详情
     * @return
     * @author hucong
     */
    @PostMapping("secretDetail")
    public ResponseObject secretDetail(Integer secret_id) {
        try {
        	LOGGER.info("驾考秘笈详情");
        	ResponseObject dealSuccess = dealSuccess();
        	DriveSecretDetail secret_detail = driveSecretService.driveSecretDetail(secret_id);
        	dealSuccess.content.put("secret_detail", secret_detail);
            return dealSuccess;
        } catch (Exception e) {
            return dealException(e);
        }
    }
    
    /**
     * 驾考技巧列表
     * @return
     * @author hucong
     */
    @PostMapping("skillIcos")
    public ResponseObject skillIcos(Integer subject_type) {
        try {
        	LOGGER.info("驾考技巧列表");
        	ResponseObject dealSuccess = dealSuccess();
        	List<SkillsIco> sklls_icons = driveSkillService.skllsIcons(subject_type);
        	dealSuccess.content.put("sklls_icons", sklls_icons);
            return dealSuccess;
        } catch (Exception e) {
            return dealException(e);
        }
    }
    
    /**
     * 驾考技巧详情
     * @return
     * @author hucong
     */
    @PostMapping("skillDetail")
    public ResponseObject skillDetail(Integer skill_id) {
        try {
        	LOGGER.info("驾考技巧详情");
        	ResponseObject dealSuccess = dealSuccess();
        	SkillsDetail skill_detail = driveSkillService.skillDetail(skill_id);
        	dealSuccess.content.put("skill_detail", skill_detail);
            return dealSuccess;
        } catch (Exception e) {
            return dealException(e);
        }
    }
    
   
}
