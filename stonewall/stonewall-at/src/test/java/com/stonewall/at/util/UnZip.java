package com.stonewall.at.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;

public class UnZip {

	private static final Logger logger = Logger.getLogger(UnZip.class);

	/**
	 * Unzip it
	 * 
	 * @param zipFile
	 *            input zip file
	 * @param output
	 *            zip file output folder
	 */
	public static void unZipIt(File zipFile, File folder) {
		Enumeration<? extends ZipEntry> enumEntries;
		ZipFile zip;

		try {
			zip = new ZipFile(zipFile);
			enumEntries = zip.entries();
			while (enumEntries.hasMoreElements()) {
				ZipEntry zipentry = (ZipEntry) enumEntries.nextElement();
				if (zipentry.isDirectory()) {
					(new File(folder.getAbsoluteFile(), zipentry.getName())).mkdir();
					continue;
				}
				extractFile(zip.getInputStream(zipentry), new FileOutputStream(folder.getAbsoluteFile() + "/"
						+ zipentry.getName()));
			}
			zip.close();
		} catch (IOException ioe) {
			logger.error("There is an IoException Occured :" + ioe);
			ioe.printStackTrace();
			return;
		}
	}

	public static void extractFile(InputStream inStream, OutputStream outStream) throws IOException {
		byte[] buf = new byte[1024];
		int l;
		while ((l = inStream.read(buf)) >= 0) {
			outStream.write(buf, 0, l);
		}
		inStream.close();
		outStream.close();
	}
}
