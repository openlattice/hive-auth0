package com.openlattice.com.openlattice.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import digital.loom.rhizome.configuration.auth0.Auth0Configuration;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import javax.security.sasl.AuthenticationException;
import org.apache.commons.codec.binary.Base64;
import org.apache.hive.service.auth.PasswdAuthenticationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HiveAuth0AuthenticationProvider implements PasswdAuthenticationProvider {
    private final Logger logger = LoggerFactory.getLogger( getClass() );
    private JWTVerifier jwtVerifier;
    //    private String      domain;
    private String      issuer;
    private String      clientId;
    private String      clientSecret;
    //    private String      securedRoute;
    private boolean     base64EncodedSecret;
    //    private String      publicKeyPath;

    protected HiveAuth0AuthenticationProvider( Auth0Configuration auth0Configuration ) {
        //        this.domain = auth0Configuration.getDomain();
        this.issuer = auth0Configuration.getIssuer();
        this.clientId = auth0Configuration.getClientId();
        this.clientSecret = auth0Configuration.getClientSecret();
        //        this.securedRoute = auth0Configuration.getSecuredRoute();
        this.base64EncodedSecret = auth0Configuration.isBase64EncodedSecret();
        //        this.publicKeyPath = auth0Configuration.getPublicKeyPath().orNull();
        this.jwtVerifier = getJwtVerifier( auth0Configuration.getSigningAlgorithm() );
    }

    @Override
    @SuppressWarnings( value = "NM_METHOD_NAMING_CONVENTION", justification = "Don't have any control over interface." )
    public void Authenticate( String user, String password ) throws AuthenticationException {
        final String jwtToken = password;
        final DecodedJWT decodedToken = jwtVerifier.verify( jwtToken );
        logger.info( "Claims: {}", Maps.transformValues( decodedToken.getClaims(), Claim::asString ) );
        //TODO: Perform additional verification of claims.
    }

    public JWTVerifier getJwtVerifier( String signingAlgorithm ) {
        final Algorithm algorithm;
        final byte[] cs;

        if ( base64EncodedSecret ) {
            cs = Base64.decodeBase64( clientSecret );// clientId, issuer );
        } else {
            cs = clientSecret.getBytes( Charsets.UTF_8 ); //, clientId, issuer );
        }

        switch ( signingAlgorithm ) {
            case "HS256":
                algorithm = Algorithm.HMAC256( cs );
                break;
            case "HS384":
                algorithm = Algorithm.HMAC384( cs );
                break;
            case "HS512":
                algorithm = Algorithm.HMAC512( cs );
                break;
            //TODO: Implement RSA signature verification.
            case "RS256":
            case "RS384":
            case "RS512":
            default:
                throw new UnsupportedOperationException( "Unrecognized signing algorithm: " + signingAlgorithm );
        }
        return JWT.require( algorithm )
                .withIssuer( issuer )
                .withAudience( clientId )
                .build();

    }
}