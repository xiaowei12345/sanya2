package sanya.com.tools;

import android.util.Log;

import java.io.*;


/**
 * @author Administrator
 * 
 */
public class FileUtils {
	private static final String TAG = "TAG";
	private static File f;


	public static int StringTOInt(String type) {
		if (type.equals("txt"))
			return 1;
		else if (type.equals("mp3"))
			return 2;
		else if (type.equals("apk"))
			return 3;
		else if (type.equals("rar"))
			return 4;
		else if (type.equals("doc"))
			return 5;
		else if (type.equals("jpg"))
			return 6;
		return 0;
	}

	/**
	 * 得到文件名加后缀
	 * 
	 * @param path
	 * @return
	 */
	public static String getName(String path) {
		// /mnt/sdcard/xxx
		String name = path.substring(path.lastIndexOf("/") + 1);
		return name;
	}

	/**
	 * 得到没有后缀的文件名
	 * 
	 * @param path
	 * @return
	 */
	public static String getFileName(String path) {
		// /mnt/sdcard/xxx
		String name = path.substring(path.lastIndexOf("/") + 1,
				path.indexOf("."));
		return name;
	}

	public static String readFile(String filePath) {// 输入文件路径
		try {
			FileInputStream fin = new FileInputStream(filePath);
			int p = (fin.read() << 8) + fin.read();
			String code = null;

			switch (p) {
			case 0xefbb:
				code = "UTF-8";
				break;
			case 0xfffe:
				code = "Unicode";
				break;
			case 0xfeff:
				code = "UTF-16BE";
				break;
			default:
				code = "GBK";
			}
			FileInputStream fin1 = new FileInputStream(filePath);
			InputStreamReader inputStreamReader = null;
			inputStreamReader = new InputStreamReader(fin1, code);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			StringBuffer sb = new StringBuffer("");
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String readFile(InputStream inputStream) {// 输入文件路径
		try {

			InputStreamReader inputStreamReader = null;
			inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			StringBuffer sb = new StringBuffer("");
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 从sdcard中删除文件
	public static boolean removeFileFromSDCard(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			try {
				file.delete();
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param filePath
	 *            : 修改文件的路径
	 * @param afterName
	 *            : 修改后的文件名字
	 */
	public static boolean renameFile(String filePath, String afterName) {
		// TODO Auto-generated method stub
		// String fileName=getFileName(filePath);
		File file = new File(filePath);
		if (file.exists()) {
			String afterPath = null;
			if (file.isFile()) {
				afterPath = filePath
						.substring(0, filePath.lastIndexOf("/") + 1)
						+ afterName
						+ filePath.substring(filePath.lastIndexOf("."));

			} else if (file.isDirectory()) {
				afterPath = filePath
						.substring(0, filePath.lastIndexOf("/") + 1)
						+ afterName;
			}
			if (afterPath.equals(filePath)) {
				return false;
			} else {
				File file2 = new File(afterPath);
				file.renameTo(file2);
				Log.i(TAG, "文件命名后-->" + afterPath);
				return true;
			}
		}
		return false;
	}
}
