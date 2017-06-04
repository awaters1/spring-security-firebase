package io.github.awaters1;

import java.io.InputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	
	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // you USUALLY want this
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedHeader("x-firebase-auth");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	
	@Bean
	public FirebaseAuth firebaseAuth() {
		// TODO: Fill in correct firebase auth
		InputStream in =
	            Application.class.getResourceAsStream("/firebase-adminsdk.json");
		FirebaseOptions options = new FirebaseOptions.Builder()
				  .setServiceAccount(in)
				  .setDatabaseUrl("https://mydatabaseurl.firebaseio.com/")
				  .build();

		FirebaseApp.initializeApp(options);
		return FirebaseAuth.getInstance();
	}
}
