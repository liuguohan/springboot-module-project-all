package com.biyouche.dao.loan;

import com.biyouche.domain.loan.LearnLoan;
import org.apache.ibatis.annotations.*;

public interface LoanMapper {

    /**
     * 查询最近的一笔未支付的报名单
     *
     * @param payStatus
     * @param id
     * @param userId
     * @return
     */
    @Select("SELECT loan_id,status FROM user_learn_loan WHERE user_id = #{userId} AND pay_status = #{payStatus} ORDER BY create_time DESC limit 1")
    @Results({
            @Result(property = "loanId", column = "loan_id"),
            @Result(property = "status", column = "status"),
            @Result(property = "payStatus", column = "pay_status")
    })
    LearnLoan selectByUserId(@Param("userId") Integer userId, @Param("payStatus") int payStatus);

    /**
     * 查询审核中和审核成功的报名单数量
     *
     * @param userId
     * @param loanStatusUnpass
     * @return
     */
    @Select("SELECT COUNT(0) FROM user_learn_loan WHERE user_id = #{userId} AND status != #{status}")
//    @Results({
//            @Result(property = "userId", column = "user_id"),
//            @Result(property = "status", column = "status")
//    })
    int selectTotalNum(@Param("userId") Integer userId, @Param("status") int loanStatusUnpass);

    /**
     * 添加学车贷报名表
     *
     * @param learnLoan
     * @return
     */
    @Insert("INSERT INTO user_learn_loan (user_id,school_name,phone,user_name,card_no,bank_no,address,licence_type,create_time) " +
            "VALUES(#{ll.userId},#{ll.schoolName},#{ll.phone},#{ll.userName},#{ll.cardNo},#{ll.bankNo},#{ll.address},#{ll.licenceType},#{ll.createTime})")
    int insertLoan(@Param("ll") LearnLoan learnLoan);
}
