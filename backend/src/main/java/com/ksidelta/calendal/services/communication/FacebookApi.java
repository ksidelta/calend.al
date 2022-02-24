package com.ksidelta.calendal.services.communication;

import java.util.List;

import com.ksidelta.calendal.config.FacebookConfig;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@ConditionalOnBean(FacebookConfig.class)
public class FacebookApi {
    @Autowired
    protected FacebookConfig facebookConfig;

    @Autowired
    protected RestTemplate restTemplate;

    public List<Page> fetchPages(String fuzzyPageName) {
        var str = restTemplate.getForObject(
                String.format("https://graph.facebook.com/pages/search?q=%s&fields=id,name,location,link&access_token=%s", fuzzyPageName, facebookConfig.getAccessToken()),
                String.class
        );

        return null;
    }

    @Configuration
    static class InternalConfig {
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }


}
