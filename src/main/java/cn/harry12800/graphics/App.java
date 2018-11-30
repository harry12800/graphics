package cn.harry12800.graphics;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import cn.harry12800.tools.FileUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String property = System.getProperty("user.dir");
        System.out.println(property);
        
        File file = new File("D:\\workspace\\java.work\\graphics\\src\\main\\Program");
        FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".class");
			}
		};
		List<File> traverseDir = FileUtils.traverseDir(file.getAbsolutePath(), filter );
		for (File file2 : traverseDir) {
			 file2.delete();
		}
        System.out.println();
    }
}
