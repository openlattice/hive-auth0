package com.openlattice.com.openlattice.authentication;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.GroupMappingServiceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by mtamayo on 7/3/17.
 */
public class Auth0GroupsMapping implements GroupMappingServiceProvider,Configurable{
    private static final Logger logger = LoggerFactory.getLogger( Auth0GroupsMapping.class );
    private final IMap<String, UUID>
    @Override public void setConf( Configuration configuration ) {

    }

    @Override public Configuration getConf() {
        return null;
    }

    @Override public List<String> getGroups( String username ) throws IOException {
        return null;
    }

    @Override public void cacheGroupsRefresh() throws IOException {

    }

    @Override public void cacheGroupsAdd( List<String> list ) throws IOException {

    }
}
