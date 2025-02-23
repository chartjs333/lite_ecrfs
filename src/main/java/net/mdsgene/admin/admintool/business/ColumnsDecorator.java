package net.mdsgene.admin.admintool.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.modeshape.common.text.Inflector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;

@Controller
public class ColumnsDecorator {
	private static Properties названия_колонок;

    protected static final ColumnsDecorator INSTANCE = new ColumnsDecorator();

    public static final ColumnsDecorator getInstance() {
        return INSTANCE;
    }
    
    
	private static Properties загрузить_колонки() throws IOException {
        //changed the properties files name TODO
        try (InputStream input = new FileInputStream(new File("c:\\published_mjff\\fixed_columns.properties"))) {
            названия_колонок = new Properties();
            названия_колонок.load(input);
            return названия_колонок;
        } catch (IOException ex) {
            throw ex;
        }
	}

	public static String humanize(String key) {
		try {
			String property = загрузить_колонки().getProperty(key);
			return property;
		} catch (Exception e) {
			return key + "?";
		}
	}

}
