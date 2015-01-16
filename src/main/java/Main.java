import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.test.MonEJBRemote;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties jndiProps = null;
		Context ctx = null;
		MonEJBRemote beanRemote = null;
		String msg = "";
		
		try {
			
			jndiProps = new Properties();
			
			jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");			
			jndiProps.put(Context.PROVIDER_URL, "remote://localhost:4447");
			jndiProps.put(Context.SECURITY_PRINCIPAL, "remoteuser1");
			jndiProps.put(Context.SECURITY_CREDENTIALS, "remotepwd1§");
			jndiProps.put("jboss.naming.client.ejb.context", true);
			
			ctx = new InitialContext(jndiProps);
			
			beanRemote = (MonEJBRemote)ctx.lookup("TestEJBv0.02/MonEJB!com.test.MonEJBRemote");
			
			msg = beanRemote.ditBonjour(" Bart");

			System.out.println("Méthode Bonjour = " + msg);
					
			System.in.read();

			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("EXCEPTION");
			e.printStackTrace();
		}
	}

}
