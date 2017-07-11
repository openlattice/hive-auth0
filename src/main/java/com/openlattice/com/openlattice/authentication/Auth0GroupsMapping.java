package com.openlattice.com.openlattice.authentication;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.GroupMappingServiceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mtamayo on 7/3/17.
 */
public class Auth0GroupsMapping implements GroupMappingServiceProvider, Configurable {
    private static final Logger                     logger = LoggerFactory.getLogger( Auth0GroupsMapping.class );
    private final        Cache<String, Set<String>> cache  = CacheBuilder.newBuilder()
            .expireAfterWrite( 1, TimeUnit.SECONDS ).build();

    @Override public Configuration getConf() {
        return null;
    }

    @Override public void setConf( Configuration configuration ) {

    }

    @Override public List<String> getGroups( String username ) throws IOException {
        return null;
    }

    @Override public void cacheGroupsRefresh() throws IOException {

    }

    @Override public void cacheGroupsAdd( List<String> list ) throws IOException {

    }
}
