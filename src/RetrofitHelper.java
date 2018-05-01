import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import pl.droidsonroids.retrofit2.JspoonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

class RetrofitHelper {

  private static final String BASE_URL = "https://ru.smedialink.com";

  static Retrofit createRetrofitInstance() {

    return new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(customOkHttpClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(JspoonConverterFactory.create())
        .build();
  }

  private static final TrustManager[] trustAllCerts = new TrustManager[]{
      new X509TrustManager() {
        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
            throws CertificateException {
        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
            throws CertificateException {
        }

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
          return new java.security.cert.X509Certificate[]{};
        }
      }
  };

  private static final SSLContext trustAllSslContext;

  static {
    try {
      trustAllSslContext = SSLContext.getInstance("SSL");
      trustAllSslContext.init(null, trustAllCerts, new java.security.SecureRandom());
    } catch (NoSuchAlgorithmException | KeyManagementException e) {
      throw new RuntimeException(e);
    }
  }

  private static final SSLSocketFactory socketFactory = trustAllSslContext.getSocketFactory();

  public static OkHttpClient customOkHttpClient() {

    OkHttpClient client = new OkHttpClient();
    Builder builder = client.newBuilder();
    builder.sslSocketFactory(socketFactory, (X509TrustManager) trustAllCerts[0]);
    builder.hostnameVerifier((hostname, session) -> true);
    return builder.build();
  }
}
