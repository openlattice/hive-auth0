package com.openlattice.com.openlattice.authentication;

import digital.loom.rhizome.configuration.auth0.Auth0Configuration;

/**
 * @author Matthew Tamayo-Rios &lt;matthew@openlattice.com&gt;
 */
public class LocalHiveAuth0AuthenticationProvider extends HiveAuth0AuthenticationProvider {
    public LocalHiveAuth0AuthenticationProvider( Auth0Configuration auth0Configuration ) {
        super( auth0Configuration );
    }
}
