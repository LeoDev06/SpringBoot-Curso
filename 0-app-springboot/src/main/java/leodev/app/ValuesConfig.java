package leodev.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/* 
 * permite que spring detecte el archivo values.properties
 * al configurarlo de esta manera podremos escribir con acentos ñÁá
 */
@Configuration
@PropertySource(value = "classpath:values.properties", encoding = "UTF-8")

/*
 * ! Para configurar mas de un archivo .properties
 * 
 * @PropertySource({
 * 
 * @PropertySource(value="classpath:values.properties", encoding = "UTF-8"),
 * 
 * @PropertySource(value="classpath:values.properties", encoding = "UTF-8"),
 * 
 * @PropertySource(value="classpath:values.properties", encoding = "UTF-8")
 * 
 * })
 */

public class ValuesConfig {
}
