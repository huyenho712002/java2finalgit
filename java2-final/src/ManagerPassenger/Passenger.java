/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerPassenger;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author ADMIN
 */
public class Passenger {
    private String passengerID;
    private String name;
    private String birthDay;
    private String address;
    private String phone;
    private String testDate;
    private String flightDay;

    static class Passenger {

        private WebTarget webTarget;
        private Client client;
        private static final String BASE_URI = "https://ecs.amazonaws.com/onca";

        public Passenger() {
            client = javax.ws.rs.client.ClientBuilder.newBuilder().sslContext(getSSLContext()).build();
            webTarget = client.target(BASE_URI).path("xml");
        }

        public Passenger(String username, String password) {
            this();
            setUsernamePassword(username, password);
        }

        /**
         * @param responseType Class representing the response
         * @param aWSAccessKeyId query parameter[REQUIRED]
         * @param searchIndex query parameter[REQUIRED]
         * @param keywords query parameter[REQUIRED]
         * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
         * List of optional query parameters:
         * <LI>ResponseGroup [OPTIONAL]
         * @return response object (instance of responseType class)
         */
        public <T> T itemSearch(Class<T> responseType, String aWSAccessKeyId, String searchIndex, String keywords, String... optionalQueryParams) throws ClientErrorException {
            String[] queryParamNames = new String[]{"AWSAccessKeyId", "SearchIndex", "Keywords", "Service"};
            (ERROR);
            (ERROR);
        }

        private Form getQueryOrFormParams(String[] paramNames, String[] paramValues) {
            Form form = new javax.ws.rs.core.Form();
            for (int i = 0; i < paramNames.length; i++) {
                if (paramValues[i] != null) {
                    form = form.param(paramNames[i], paramValues[i]);
                }
            }
            return form;
        }

        private MultivaluedMap getQParams(String... optionalParams) {
            MultivaluedMap<String, String> qParams = new javax.ws.rs.core.MultivaluedHashMap<String, String>();
            for (String qParam : optionalParams) {
                String[] qPar = qParam.split("=");
                if (qPar.length > 1) {
                    qParams.add(qPar[0], qPar[1]);
                }
            }
            return qParams;
        }

        public void close() {
            client.close();
        }

        public final void setUsernamePassword(String username, String password) {
            webTarget.register(new org.glassfish.jersey.client.filter.HttpBasicAuthFilter(username, password));
        }

        private HostnameVerifier getHostnameVerifier() {
            return new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
                    return true;
                }
            };
        }

        private SSLContext getSSLContext() {
            // for alternative implementation checkout org.glassfish.jersey.SslConfigurator
            javax.net.ssl.TrustManager x509 = new javax.net.ssl.X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws java.security.cert.CertificateException {
                    return;
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws java.security.cert.CertificateException {
                    return;
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            SSLContext ctx = null;
            try {
                ctx = SSLContext.getInstance("SSL");
                ctx.init(null, new javax.net.ssl.TrustManager[]{x509}, null);
            } catch (java.security.GeneralSecurityException ex) {
            }
            return ctx;
        }
    }
}
//

