import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface ConfigValue {
	String key();
}

class ApplicationConfig {
	@ConfigValue(key = "app.name")
	public String appName;

	@ConfigValue(key = "app.version")
	private String appVersion; // Should still be handled by reflection

	public String nonConfigField = "default";

	public String getAppVersion() { return appVersion; }
}

class ConfigLoader {
	private static final java.util.Map<String, String> configMap = new java.util.HashMap<>();
	static {
		configMap.put("app.name", "MyWebApp");
		configMap.put("app.version", "1.0.0");
		configMap.put("db.url", "jdbc:mysql://localhost:3306/mydb");
	}

	public void loadConfig(Object target) throws IllegalAccessException {
        Class clazz = target.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for(Field field: fields)
        {
            if(field.isAnnotationPresent(ConfigValue.class))
            {
                ConfigValue annotation = field.getAnnotation(ConfigValue.class);
                String key = annotation.key();
                String value = configMap.get(key);

                if(value!=null)
                {
                    field.setAccessible(true);
                    field.set(target,value);
                }
            }
        }
        
		// Your code here: iterate through fields, check for @ConfigValue, and inject values
	}
}