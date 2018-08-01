package com.biyouche.service;

import com.biyouche.domain.user.UserToken;

public interface UserTokenService {

    UserToken selectToken(String accessToken, String deviceType);
}
