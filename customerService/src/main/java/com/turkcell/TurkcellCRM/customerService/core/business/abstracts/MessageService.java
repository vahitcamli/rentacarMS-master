package com.turkcell.TurkcellCRM.customerService.core.business.abstracts;

public interface MessageService {
   String getMessage(String key);

   String getMessageWithArgs(String key,Object... args);
}

