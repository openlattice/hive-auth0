import com.auth0.client.auth.AuthAPI;
import com.auth0.exception.Auth0Exception;
import com.openlattice.ResourceConfigurationLoader;
import com.openlattice.com.openlattice.authentication.LocalHiveAuth0AuthenticationProvider;
import digital.loom.rhizome.configuration.auth0.Auth0Configuration;
import javax.security.sasl.AuthenticationException;
import org.junit.Test;

/**
 * @author Matthew Tamayo-Rios &lt;matthew@openlattice.com&gt;
 */
public class TestHiveAuth0AuthProvider {
    private static Auth0Configuration a0config = ResourceConfigurationLoader
            .loadConfiguration( Auth0Configuration.class );

    private static final AuthAPI auth = new AuthAPI( a0config.getDomain(),
            a0config.getClientId(),
            a0config.getClientSecret() );

    @Test
    public void testAuthentication() throws Auth0Exception, AuthenticationException {
//        auth.requestToken(  )
        String jwtToken = auth
                .login( "support@kryptnostic.com", "abracadabra", "Tests" )
                //.setAudience( "https://loom.auth0.com/api/v2/" )
                .setScope( "openid email nickname roles user_id organizations" )
                .execute().getIdToken();

        new LocalHiveAuth0AuthenticationProvider( a0config ).Authenticate( "support@kryptnostic.com", jwtToken );
    }
}
