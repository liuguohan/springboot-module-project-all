package com.biyouche.mybatis.apply;

/**
 * 学车保险自定义sql
 * @author lgh
 *
 */
public class VipInsuranceSqlProvider {

	/**
	 * vip方案展示
	 * @return
	 */
	public String vipPlanList() {
		
		StringBuffer sql = new StringBuffer(100);
		sql.append(" SELECT vip.vip_id, vip.vip_level, vip.vip_name, vip.vip_fee, plan.retake_number, plan.cash, plan.fund ");
		sql.append(" FROM vip INNER JOIN vip_plan plan ON vip.plan_id = plan.plan_id ");
		
        return sql.toString();
    }
	
}
