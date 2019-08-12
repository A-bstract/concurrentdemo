package com.concurrent.demo.MQT;

import com.bld365.mq.core.annotation.MQTemplateConfiguration;
import com.bld365.mq.core.template.MQTemplate;

@MQTemplateConfiguration(group="${mq.producer.group}", nameServer="${mq.name-server}")
public class Pdoduct {

}
