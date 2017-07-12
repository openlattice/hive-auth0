package com.openlattice.com.openlattice.authentication;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.kryptnostic.rhizome.configuration.amazon.AmazonLaunchConfiguration;
import com.openlattice.ResourceConfigurationLoader;
import digital.loom.rhizome.configuration.auth0.Auth0Configuration;

/**
 * @author Matthew Tamayo-Rios &lt;matthew@openlattice.com&gt;
 */
public class S3HiveAuth0AuthenticationProvider extends HiveAuth0AuthenticationProvider {
    private static final AmazonS3                  s3        = new AmazonS3Client();
    private static final AmazonLaunchConfiguration awsConfig = ResourceConfigurationLoader
            .loadConfiguration( AmazonLaunchConfiguration.class );

    public S3HiveAuth0AuthenticationProvider() {
        super( ResourceConfigurationLoader.loadConfigurationFromS3( s3,
                awsConfig.getBucket(),
                awsConfig.getFolder(),
                Auth0Configuration.class ) );
    }
}
