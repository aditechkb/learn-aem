package com.sankham.aem.guides.site.core.services.impl;

import com.sankham.aem.guides.site.core.services.MyService;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = MyService.class,
        immediate = true,
        property = {"country=us"}
)
public class MyServiceImplAnother implements MyService{

    private static final Logger LOGGER = LoggerFactory.getLogger(MyServiceImplAnother.class);

    public String printLogger(){
        return "Test Successful!! country=us";
    }
}
