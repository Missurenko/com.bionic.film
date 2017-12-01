package com.bionic.film.service;

import com.bionic.film.dto.NotificationUser;

public interface NotificationFactory {

     void fire(NotificationUser event);
}
