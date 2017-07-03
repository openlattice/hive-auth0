package com.openlattice.com.openlattice.authentication;

import org.apache.hive.service.auth.PasswdAuthenticationProvider;

import javax.security.sasl.AuthenticationException;

public class HiveAuth0AuthenticationProvider implements PasswdAuthenticationProvider {
    private static final AuthenticationException AUTH_ERROR = new Auth0TokenException("Authentication Error");

    private JWTVerifier jwtVerifier;
    private String domain;
    private String issuer;
    private String clientId;
    private String clientSecret;
    private String securedRoute;
    private boolean base64EncodedSecret;
    private AuthorityStrategy authorityStrategy;
    private Algorithm signingAlgorithm;
    private String publicKeyPath;

    @Override public void Authenticate( String user, String password ) throws AuthenticationException {

    }

    @Override
    public void setAuthorityStrategy( AuthorityStrategy authorityStrategy ) {
        super.setAuthorityStrategy( authorityStrategy );
    }

    @Override
    public void setBase64EncodedSecret( boolean base64EncodedSecret ) {
        super.setBase64EncodedSecret( base64EncodedSecret );
    }

    @Override
    public void setClientId( String clientId ) {
        super.setClientId( clientId );
    }

    @Override
    public void setClientSecret( String clientSecret ) {
        super.setClientSecret( clientSecret );
    }

    @Override
    public void setDomain( String domain ) {
        super.setDomain( domain );
    }

    @Override
    public void setIssuer( String issuer ) {
        super.setIssuer( issuer );
    }

    @Override
    public void setPublicKeyPath( String publicKeyPath ) {
        super.setPublicKeyPath( publicKeyPath );
    }

    @Override
    public void setSecuredRoute( String securedRoute ) {
        super.setSecuredRoute( securedRoute );
    }

    @Override
    public void setSigningAlgorithm( Algorithm signingAlgorithm ) {
        super.setSigningAlgorithm( signingAlgorithm );
    }
}