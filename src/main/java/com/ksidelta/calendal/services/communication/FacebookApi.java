package com.ksidelta.calendal.services.communication;

import java.util.List;

import com.ksidelta.calendal.config.FacebookConfig;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service
@Import(FacebookApi.FacebookClientConfiguration.class)
public class FacebookApi {
    @Autowired
    FacebookClient facebookClient;

    public List<Page> fetchPages(String fuzzyPageName){
        var conn = facebookClient.fetchConnection("pages", Page.class, Parameter.with("q", fuzzyPageName));
        return conn.getData();
    }

    @Configuration
    static class FacebookClientConfiguration {
        @Autowired
        FacebookConfig facebookConfig;

        @Bean
        public FacebookClient facebookClient() {
            return new DefaultFacebookClient(
                    facebookConfig.clientId,
                    facebookConfig.clientSecret,
                    Version.VERSION_12_0);
        }
    }

}
