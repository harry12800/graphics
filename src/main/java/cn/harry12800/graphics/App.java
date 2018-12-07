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
        String property = System.getProperty("user.dirsad");
        System.out.println(property);
        
        File file = new File("D:\\workspace\\java.work\\graphics\\src\\main\\program");
        FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		};
		List<File> traverseDir = FileUtils.traverseDir(file.getAbsolutePath(), filter );
		for (File file2 : traverseDir) {
			String srcByFilePath = FileUtils.getSrcByFilePath(file2, "GBK");
			System.out.println(srcByFilePath);
			FileUtils.writeContent(file2.getAbsolutePath(), srcByFilePath, "UTF-8");
		}
        System.out.println();
    }
}
