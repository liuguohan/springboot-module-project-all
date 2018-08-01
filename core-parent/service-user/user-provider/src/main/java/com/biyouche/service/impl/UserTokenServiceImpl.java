package com.biyouche.service.impl;

import com.biyouche.dao.user.UserTokenMapper;
import com.biyouche.domain.user.UserToken;
import com.biyouche.rabbitmq.producer.RabbitMQProducer;
import com.biyouche.redis.prefix.RedisKeyPrefix;
import com.biyouche.redis.utils.RedisTempleteUtils;
import com.biyouche.service.UserTokenService;
import com.biyouche.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userTokenService")
@SuppressWarnings({"unused"})
public class UserTokenServiceImpl implements UserTokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Value("${userqueue}")
    String queue;

    @Bean
    Queue queue() {
        return new Queue(queue, false);
    }

    @Autowired
    RabbitMQProducer producer;

    public void sendMsg(String msg) {
        producer.sendTo(queue, msg + " at " + new Date());
    }

    @RabbitListener(queues = "${userqueue}")
    public void handler(String message) {
        LOGGER.info("Consumer> " + message);
    }

    /**
     * 获取token
     * @param deviceType
     * @return
     */
    @Override
    public UserToken selectToken(String accessId, String deviceType) {

        //从redis中获取
        String token = RedisTempleteUtils.getStr(RedisKeyPrefix.USER_TOKEN_PREFIX + accessId);
        if (ValidatorUtils.isNull(token)){
            //redis中是空的,直接返回空的
            return null;
        }
        //不为空查询数据库
       return userTokenMapper.selectTokenByAccessId(accessId,deviceType);
    }
}
